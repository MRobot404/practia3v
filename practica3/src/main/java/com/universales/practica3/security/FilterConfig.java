package com.universales.practica3.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class FilterConfig {

	@Bean
	FilterRegistrationBean<JwtFilter> jwtFilter() {
		FilterRegistrationBean<JwtFilter> filter = new FilterRegistrationBean<>();
		filter.setFilter(new JwtFilter());
		filter.addUrlPatterns("/auth/*");
		return filter;
	}
}
