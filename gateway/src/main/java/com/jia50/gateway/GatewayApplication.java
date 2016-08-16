package com.jia50.gateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;



/**
 * Created by 02 on 2016/8/9.
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
//@EnableOAuth2Sso
public class GatewayApplication {//extends WebSecurityConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }


}


/**
 *
 *    @Override
public void configure(HttpSecurity http) throws Exception {
// @formatter:off

http.antMatcher("/**")
.authorizeRequests()
.antMatchers("/**").permitAll()
.anyRequest().permitAll().and().csrf().disable();

// @formatter:on
}
 *
 *
 *
 * */