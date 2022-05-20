package com.salesianostriana.dam.banda.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

public class Categoria {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String descripcion;
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="categorias", fetch = FetchType.EAGER)
	private List<Productos> productos = new ArrayList<>();
	

}