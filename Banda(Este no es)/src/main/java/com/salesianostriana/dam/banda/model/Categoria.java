package com.salesianostriana.dam.banda.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor

public class Categoria {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String descripcion;
	
	@OneToMany(mappedBy="categorias", fetch = FetchType.EAGER)
	private List<Productos> productos = new ArrayList<>();
	

}