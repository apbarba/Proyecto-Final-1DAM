package com.salesianostriana.dam.banda.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Usuarios {

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public class Usuario {
		
		private String username, password, role;
		private String nombre, apellidos;
		private String avatar;
	
		
	}

}
