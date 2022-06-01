package com.salesianostriana.dam.banda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {
	
	@Id
	@GeneratedValue
	private long id;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private String nombre;
	private int telefono;
	private String correo;
	private String mensaje;
		
}
