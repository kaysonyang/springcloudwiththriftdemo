package com.deep.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "customerEntityManager", transactionManagerRef = "customerTransactionManager", 
	basePackages = {"com.deep" })
public class PrimaryDBConfig {
	@Autowired
	private DataSourceConfig dsConfig;
	
	
	@Bean(name = "customerEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] {"com.deep"});
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(jpaProperties());
		em.setPersistenceUnitName("customers");

		return em;
	}
	
	Properties jpaProperties(){
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
//		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Bean
	@ConfigurationProperties(prefix="exuefu")
	public DataSource dataSource(){
		DruidDataSource dds= new DruidDataSource();
		dds.setDriverClassName(dsConfig.getDriverClassName());
		dds.setUrl(dsConfig.getUrl());
		dds.setUsername(dsConfig.getUsername());
		dds.setPassword(dsConfig.getPassword());
		
		//配置初始化大小、最小、最大 
		dds.setMaxActive(20);
		dds.setInitialSize(1);
		dds.setMinIdle(1);
		
		//配置获取连接等待超时的时间  单位毫秒
		dds.setMaxWait(20000);
		//配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		dds.setTimeBetweenEvictionRunsMillis(60000);
		//配置一个连接在池中最小生存的时间，单位是毫秒 
		dds.setMinEvictableIdleTimeMillis(300000);
		
		
		dds.setValidationQuery("SELECT 'x'");
		dds.setTestWhileIdle(true);
		dds.setTestOnReturn(false);
		dds.setTestOnBorrow(false);
		
		//打开PSCache，并且指定每个连接上PSCache的大小
		dds.setPoolPreparedStatements(false);
		//dds.setMaxPoolPreparedStatementPerConnectionSize(20);
		
		//配置监控统计拦截的filters
		try {
			dds.setFilters("stat");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//打开removeAbandoned功能
		dds.setRemoveAbandoned(true);
		// 1800秒，也就是30分钟
		dds.setRemoveAbandonedTimeout(1800);
		dds.setLogAbandoned(true);
		

		return dds;

	}	
	
	@Bean(name = "customerTransactionManager")
	@Primary
	public JpaTransactionManager transactionManager(EntityManagerFactory customerEntityManager){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(customerEntityManager);
		
		return transactionManager;
	}

}
