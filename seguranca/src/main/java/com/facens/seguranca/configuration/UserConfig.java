package com.facens.seguranca.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User
            .withUsername("usuario")
            .password("{noop}senha")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
