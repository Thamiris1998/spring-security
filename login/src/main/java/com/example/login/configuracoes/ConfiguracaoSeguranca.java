package com.example.login.configuracoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter{

	protected void configuguire(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryUserDetailsManagerConfigurer = auth.inMemoryAuthentication();
		inMemoryUserDetailsManagerConfigurer.withUser("admin").password("123").roles("USER");
		inMemoryUserDetailsManagerConfigurer.withUser("tata").password("123").roles("USER");
	}
}
