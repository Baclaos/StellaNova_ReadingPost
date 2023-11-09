package com.demo.springboot.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.http.HttpMethod.GET;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //http.authorizeRequests().antMatchers(GET, "/reading/**").hasAnyAuthority("ROLE_USER"); //SECURITY
//        http.authorizeRequests().antMatchers("/login/**","/account/**",  "/message/**").permitAll(); //"/account/token/refresh/**",

    }

}