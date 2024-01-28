package com.aspire.hackathon.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.aspire.hackathon.filter.AuthorizationFilter;

@EnableWebSecurity
public class AppSecurityConfigurer extends WebSecurityConfigurerAdapter{

	private UserDetailsService userDetailsService;
	private AuthorizationFilter authorizationFilter;
	
	public AppSecurityConfigurer(UserDetailsService userDetailsService, AuthorizationFilter authorizationFilter) {
		this.userDetailsService = userDetailsService;
		this.authorizationFilter = authorizationFilter;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public AuthenticationManager getAuthenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/user/signup").permitAll()
		.antMatchers("/user/login").permitAll()
		.anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
