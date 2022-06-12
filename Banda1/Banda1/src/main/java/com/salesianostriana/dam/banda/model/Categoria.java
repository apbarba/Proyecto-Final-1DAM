package com.salesianostriana.dam.banda.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
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
	@Column(length = 1000)
	private String descripcion;
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="categorias", fetch = FetchType.EAGER)
	private List<Productos> productos = new ArrayList<>();
	

}