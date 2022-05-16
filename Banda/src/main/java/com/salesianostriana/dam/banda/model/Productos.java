package com.salesianostriana.dam.banda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Productos {
	
	private String nombre;
	private int cantidad;
	private double precio;
	private boolean disponibilidad;
	
	@Id
	@GeneratedValue
	private long id;
}
