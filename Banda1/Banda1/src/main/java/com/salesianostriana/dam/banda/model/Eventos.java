package com.salesianostriana.dam.banda.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

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
public class Eventos {
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private String lugar; //Donde se celebrará el concierto
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	@Id
	@GeneratedValue
	private long id;
	
	private String asunto;
	private String organizador; //Hermandad que organiza el concierto
	
}