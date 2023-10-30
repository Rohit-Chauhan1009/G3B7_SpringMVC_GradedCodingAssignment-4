package com.GreatLearning.EmployeeManagementRestAPI.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.GreatLearning.EmployeeManagementRestAPI.ServiceImpl.UserDetailsServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");

	}

	// Authentication Setup
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/addNewEmployee").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/aaddRole").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/addUser").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/listAllEmployees").authenticated()
				.antMatchers(HttpMethod.GET, "/getEmployeeById/**", "/getEmployeeById**")
				.authenticated()
				.antMatchers(HttpMethod.DELETE, "/deleteEmployeeById/{id}", "/deleteEmployeeById/**")
				.hasRole("ADMIN").antMatchers("/employees/{id}").hasAnyRole("ADMIN", "USER").anyRequest()
				.fullyAuthenticated().and().httpBasic();

	}
	

}
