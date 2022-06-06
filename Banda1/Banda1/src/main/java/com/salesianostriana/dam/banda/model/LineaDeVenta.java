package com.salesianostriana.dam.banda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LineaDeVenta {

	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne
	private Productos productos;
	private int cantidad;
	private double precioT;
	@ManyToOne
	private Carrito carrito;
	
	
	//Algunos métodos del carrito junto con los de línea de venta
	
	/**
	 * Amplementar un producto al carrito
	 * @param c
	 */
	public void implementarTicket(Carrito c) {
		
		carrito = c;
		c.getLinea().add(this);
	}
	
	/**
	 * Elimar un producto del carrito
	 * @param c
	 */
	public void eliminarDelTicket(Carrito c) {
		
		c.getLinea().remove(this);
		
		carrito = null;
	}
}
