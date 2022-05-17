package com.salesianostriana.dam.banda.model;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuarios {
	
	private String username, password, role;
	private String nombre, apellidos;
	private String avatar;
	
}
