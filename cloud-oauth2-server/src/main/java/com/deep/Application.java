package com.deep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EnableDiscoveryClient
public class Application{
	private static Logger log = LoggerFactory.getLogger(Application.class);
	

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("SpringApplication run");
	}
}
