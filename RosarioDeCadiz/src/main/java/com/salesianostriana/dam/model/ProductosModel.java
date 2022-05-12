package com.salesianostriana.dam.model;

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
public class ProductosModel {


	private String nombre_Producto;
	private int cantidad;
	private double precio;
	private boolean disponibilidad;
	
	@Id
	@GeneratedValue
	private long id_producto;
	
}
