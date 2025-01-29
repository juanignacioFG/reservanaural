package com.juan.reservanatural.config;

import static org.springframework.security.config.Customizer.withDefaults;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${api-endpoint}")
    String endpoint;


    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors(withDefaults())
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(endpoint+"/welcome").hasRole("USER") // principio de mínimos privilegios
                        .requestMatchers(endpoint + "/public").permitAll()
                        .requestMatchers(endpoint + "/private").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .userDetailsService(userDetailsService)
                .headers(headers -> headers.frameOptions(frame -> frame.disable()));


        return http.build();

    }


    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails mickey = User.builder()
                .username("mickey")
                .password("{noop}mouse")
                .roles("ADMIN")
                .build();

        UserDetails minnie = User.builder()
                .username("minnie")
                .password("{noop}mouse")
                .roles("USER")
                .build();

        Collection<UserDetails> users = new ArrayList<>();
        users.add(mickey);
        users.add(minnie);

        return new InMemoryUserDetailsManager(users);

    }

}