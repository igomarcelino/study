package com.spring_security.spring_security.config;

import com.spring_security.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserService userService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity security)throws Exception{

        return security.formLogin(Customizer.withDefaults()).authorizeHttpRequests(aut ->
                aut.requestMatchers("/login/**").permitAll().
                        requestMatchers("/admin/**").hasAnyAuthority("admin").
                        requestMatchers("/users/**").hasAnyAuthority("admin","user").
                        anyRequest().authenticated()).
                userDetailsService(userService).build();
    }
}
