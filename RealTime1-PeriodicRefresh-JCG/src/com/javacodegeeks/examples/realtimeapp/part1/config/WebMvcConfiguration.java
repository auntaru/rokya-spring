package com.javacodegeeks.examples.realtimeapp.part1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.javacodegeeks.examples.realtimeapp.part1.services.TaskService;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.javacodegeeks.examples.realtimeapp.part1")
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public TaskService taskService() {
		return new TaskService();
	}
}
