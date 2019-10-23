/* package com.example.bank.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {
	
	private ServerHttpSecurity http;
	
	public SecurityConfig(ServerHttpSecurity http) {
		this.http = http;
	}

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain() {
		http.authorizeExchange().anyExchange().permitAll();
		return http.build();
	}
} */
