package com.cinema.cinemabookingapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserSecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		/*http
		.authorizeHttpRequests(authorize -> authorize
			.antMatchers("/login/**").hasRole("USER")
		);*/
		
		http.antMatcher("public/api/**")
		.authorizeRequests().anyRequest().hasAuthority("USER")
		.and()
		.formLogin()
			.loginPage("/signIn")
			.usernameParameter("username")
			.loginProcessingUrl("/signIn")
			.defaultSuccessUrl("/welcome")
			.permitAll()
		.and()
		.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/home");
		
		return http.build();

	}
}
