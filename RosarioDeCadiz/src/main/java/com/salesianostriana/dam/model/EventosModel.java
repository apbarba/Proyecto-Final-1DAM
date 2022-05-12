package com.salesianostriana.dam.model;

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
public class EventosModel {
	
	private String lugar; //Donde se celebrará el concierto
	private LocalDate fecha;
	
	@Id
	@GeneratedValue
	private long id_evento;
	
	private String asunto;
	private String Organizador; //Hermandad que organiza el concierto
	
}
