package com.ai.ewa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
	
	@Autowired
	private final JwtAuthenticationFilter jwtAuthFilter;
	@Autowired
	private final AuthenticationProvider authenticationProvider;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.requestMatchers("/customer/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		
		
		return http.build();
	}

}
