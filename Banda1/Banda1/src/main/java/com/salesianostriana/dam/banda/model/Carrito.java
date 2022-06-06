package com.salesianostriana.dam.banda.model;

import java.time.LocalDateTime;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carrito {

	@Id
	@GeneratedValue
	private long id;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="carrito", fetch= FetchType.EAGER)
	@Builder.Default
	private List<LineaDeVenta> linea = new ArrayList<LineaDeVenta>();
	private LocalDateTime fecha;
	
	private double total;
}
