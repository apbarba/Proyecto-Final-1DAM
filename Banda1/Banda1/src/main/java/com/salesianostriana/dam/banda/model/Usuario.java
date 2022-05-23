package com.salesianostriana.dam.banda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
	
	private String username;
	private String password;
	private String role;
	private String nombre;

}
