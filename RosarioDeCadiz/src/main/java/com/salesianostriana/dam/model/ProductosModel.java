package com.salesianostriana.dam.model;

public class ProductosModel {


	private String nombre_Producto;
	private int cantidad;
	private double precio;
	private boolean disponibilidad;
	private long id_producto;
	
	public ProductosModel(String nombre_Producto, int cantidad, double precio, boolean disponibilidad,
			long id_producto) {
		super();
		this.nombre_Producto = nombre_Producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.disponibilidad = disponibilidad;
		this.id_producto = id_producto;
	}
	
}
