package com.plalance.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Application SPRING configuration.
 * 
 */
@Configuration
@ComponentScan(basePackages = "com.plalance")
@PropertySource("classpath:application.properties")
public class SpringConfig {

	// Allow ObjectMapper Injection
	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}

	// Allow Spring Environnement Injection
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
