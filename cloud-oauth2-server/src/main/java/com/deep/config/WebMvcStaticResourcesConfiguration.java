package com.deep.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcStaticResourcesConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	
		if(!registry.hasMappingForPattern("/static/**")){
			registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		}
		super.addResourceHandlers(registry);
	}
	
	
}
