package com.sp.mehta.applications.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses= ApplicationUserDetails.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired 
	private UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		//auth.inMemoryAuthentication().withUser("khushi").password("khushi").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		//.antMatchers("create").access("hasRole('user','admin')")
		.antMatchers("update").access("hasRole('user','admin')")
		.antMatchers("read").access("hasRole('user','manager')")
		.antMatchers("list").access("hasRole('user','user')")
/*		.and()
			.formLogin().loginPage("/login")
			.usernameParameter("username").passwordParameter("password")
		.and()
			.logout().logoutSuccessUrl("/login?logout") 
*/		.and()
			.exceptionHandling().accessDeniedPage("/403")
		.and().csrf().disable();
	}
		
	@Bean
	protected BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
}
