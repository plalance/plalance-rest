package com.plalance.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Application SPRING configuration.
 * 
 */
@Configuration
@ComponentScan(basePackages = "com.plalance")
public class SpringConfig {
	
	@Bean
	public ObjectMapper mapper() {
	  return new ObjectMapper();
	}
	
}
