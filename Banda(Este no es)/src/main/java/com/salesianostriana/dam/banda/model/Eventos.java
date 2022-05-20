package com.salesianostriana.dam.banda.model;

import java.time.LocalDate;

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
public class Eventos {
	

	@Id
	@GeneratedValue
	private long id;
	
	private String lugar; //Donde se celebrará el concierto
	private LocalDate fecha;
	private String asunto;
	private String organizador; //Hermandad que organiza el concierto
	
}