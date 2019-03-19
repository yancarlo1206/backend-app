package com.tksis.backendapp;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import com.tksis.backendapp.auth.filter.JWTAuthenticationFilter;
import com.tksis.backendapp.auth.filter.JWTAuthorizationFilter;
import com.tksis.backendapp.auth.service.JWTService;
import com.tksis.backendapp.models.service.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
		
		/*
		build.inMemoryAuthentication()
		.withUser(users.username("admin").password("1234").roles("ADMIN", "USER"))
		.withUser(users.username("carlos").password("1234").roles("USER"));
		
		
		build.jdbcAuthentication()
		.dataSource(datasource)
		.passwordEncoder(encoder)
		.usersByUsernameQuery(" select username, password, enabled from users where username = ? ")
		.authoritiesByUsernameQuery(" select u.usename, a.authority from authorities a inner join users u on a.user_id = u.id where u.username = ? ");
		*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/usuario","/usuario/saludar","/login").permitAll()

		.anyRequest().authenticated()
		/*
		.and()
		.formLogin()
		.and()
		.logout().permitAll()
		*/
		.and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtService))
		.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtService))
		//.addFilterBefore(new VewSecurityCorsFilter(), ChannelProcessingFilter.class)
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().cors();
		

	}
	
}

