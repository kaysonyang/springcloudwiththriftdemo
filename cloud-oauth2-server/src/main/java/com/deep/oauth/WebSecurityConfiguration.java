/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.deep.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private ExtAuthenticationProvider xfAuthenticationProvider;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService);
		 auth.authenticationProvider(xfAuthenticationProvider);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		// 设置拦截规则  
//        // 自定义accessDecisionManager访问控制器,并开启表达式语言  
//        http.authorizeRequests()
//                .antMatchers("/**/*.do*").hasRole("USER")  
//                .antMatchers("/**/*.htm").hasRole("ADMIN").and()  
//                .exceptionHandling().accessDeniedPage("/login");  
//  
//        // 开启默认登录页面  
//        http.formLogin();  
//  
//        // 自定义登录页面  
//        http.csrf().disable().formLogin().loginPage("/login")  
//                .failureUrl("/login?error=1")  
//                .loginProcessingUrl("/j_spring_security_check")  
//                .usernameParameter("j_username")  
//                .passwordParameter("j_password").permitAll();  
//  
//        // 自定义注销  
//        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login")  
//                .invalidateHttpSession(true);  
//  
//        // session管理  
//        http.sessionManagement().sessionFixation().changeSessionId()  
//                .maximumSessions(1).expiredUrl("/");  
//  
//        // RemeberMe  
//        http.rememberMe().key("webmvc#FD637E6D9C0F1A5A67082AF56CE32485");  
//	}
//	
//	@Override  
//    public void configure(WebSecurity web) throws Exception {  
//        // 设置不拦截规则  
//        web.ignoring().antMatchers("/static/**", "/**/*.css","/**/*.js");  
//  
//    }  
  
}
