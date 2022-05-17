package com.salesianostriana.dam.banda.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.banda.model.Usuarios;

@Repository
public class UsuariosRepository {

	private List<Usuarios> usuarios;

	public List<Usuarios> getUsuarios() {
		return Collections.unmodifiableList(usuarios);
	}

	public Optional<Usuarios> findUserByUsername(String username) {
		return usuarios.stream()
				.filter(u -> u.getUsername().equals(username))
				.findFirst();
	}
	
	@PostConstruct
	public void init() {
		usuarios = List.of(
				Usuarios.builder()
					.username("luismi")
					.password("12345678")
					.role("ADMIN")
					.nombre("Luis Miguel")
					.apellidos("López Magaña")
					.build()
				,
				Usuarios.builder()
				.username("angel")
				.password("87654321")
				.role("USER")
				.nombre("Ángel")
				.apellidos("Naranjo González")
				.build()
				
				
				);
				
	}

}