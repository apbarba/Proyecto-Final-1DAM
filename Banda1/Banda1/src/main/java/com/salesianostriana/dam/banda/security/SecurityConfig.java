package com.salesianostriana.dam.banda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.salesianostriana.dam.banda.repository.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioRepository usuarios;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
        http
        .headers().frameOptions().disable().and()        
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/private/**").hasAnyRole("USER", "ADMIN")
    	.antMatchers("/editarProducto/**").hasRole("ADMIN")
//		 .antMatchers("/list/**")
//           .hasAnyRole("ADMIN")
		.antMatchers("/editar").hasRole("ADMIN")
		.antMatchers("/nuevoProducto").hasRole("ADMIN")
		.antMatchers("/borrarProducto").hasRole("ADMIN")
		.antMatchers("/lista/producto/**").hasRole("ADMIN")
		.antMatchers("/nuevo").hasRole("ADMIN")
		.antMatchers("/borrar").hasRole("ADMIN")
		.antMatchers("/lista/eventos").hasRole("ADMIN")
		.antMatchers("/categoria").hasRole("ADMIN")
        .anyRequest().permitAll()
        .and().exceptionHandling().accessDeniedPage("/error")
        .and().formLogin().loginPage("/").loginProcessingUrl("/login")
        		.defaultSuccessUrl("/inicio")
        		.failureUrl("/login-error").permitAll()
        .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();

	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {

		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

		usuarios.getUsuarios().stream().map(u -> {
			return User.withUsername(u.getUsername()).password("{noop}" + u.getPassword()).roles(u.getRole()).build();

		}).forEach(userDetailsManager::createUser);

		return userDetailsManager;

	}
}