package com.salesianostriana.dam.banda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Productos {
	
	@Id
	@GeneratedValue
	private long id;
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private String nombre;
	private int cantidad;
	private double precio;
	private String proveedores;
	private String envio;

	@Column(length=1000)
	private String texto; //Atl de la imágenes
	
	private String img;

	
	@ManyToOne
	private Categoria categorias;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void eliminarCategoria(Categoria c) {
		
		c.getProductos().remove(this);
		
		categorias = null;
	}

}
