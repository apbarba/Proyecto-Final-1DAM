package com.salesianostriana.dam.model;

import java.time.LocalDate;

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
public class PartiturasModel {

	private String audio;
	private double precio;
	private int tipo_partituras;
	private String bandas_interpretan;
	private int id_partitura;

}
