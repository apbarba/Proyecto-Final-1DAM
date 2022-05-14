package com.salesianostriana.dam.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactoModel {
	
	private String telefono;
	private String nombre;
	private String gmail;
	private String asunto;
	
	public ContactoModel(String telefono, String nombre, String gmail, String asunto) {
		super();
		this.telefono = telefono;
		this.nombre = nombre;
		this.gmail = gmail;
		this.asunto = asunto;
	}
	
}
