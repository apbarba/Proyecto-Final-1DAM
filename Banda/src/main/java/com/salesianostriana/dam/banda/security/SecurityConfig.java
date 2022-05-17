package com.salesianostriana.dam.banda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.salesianostriana.dam.banda.repository.UsuariosRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UsuariosRepository usuarios;

//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService());
//    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/private/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/**", "/gestion/**").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and().exceptionHandling().accessDeniedPage("/error")
                .and().formLogin().loginPage("/").loginProcessingUrl("/login")
                		.defaultSuccessUrl("/")
                		.failureUrl("/login-error").permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll()
                .and().headers().frameOptions().disable();

    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//
//        usuarios.getUsuarios()
//                .stream()
//                .map(u -> {
//                    return User
//                            .withUsername(u.getUsername())
//                            .password("{noop}"+ u.getPassword())
//                            .roles(u.getRole())
//                            .build();
//
//                })
//                .forEach(userDetailsManager::createUser);
//
//
//        return userDetailsManager;
//
//
//    }
}
