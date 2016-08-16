package com.jia50;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * Created by 02 on 2016/8/15.
 *
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableOAuth2Client
public class ResourceServerApplication {
    private static Logger log = LoggerFactory.getLogger(ResourceServerApplication.class);
    private static final String RESOURCE_ID = "restservice";

    public static void main(String[] args) {
        SpringApplication.run(ResourceServerApplication.class, args);
        log.info("com.jia50.ResourceServerApplication run");
    }

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConf extends
            ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            // @formatter:off
            resources
                    .resourceId(RESOURCE_ID);
            // @formatter:on
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            // @formatter:off

            http
                    .authorizeRequests()
                    //用户
                    .antMatchers(HttpMethod.POST,"/pay").authenticated()
            .and().csrf().disable();
            // @formatter:on

        }

        @LoadBalanced
        @Bean
        public OAuth2RestTemplate loadBalancedOauth2RestTemplate(
                OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context) {
            return new OAuth2RestTemplate(resource, context);
        }
    }
}
