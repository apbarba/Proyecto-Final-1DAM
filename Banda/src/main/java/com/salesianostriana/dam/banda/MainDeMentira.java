package com.salesianostriana.dam.banda;

import java.time.LocalDate;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.banda.model.Eventos;
import com.salesianostriana.dam.banda.repository.EventosRepository;

@Component
public class MainDeMentira {
	
	@Autowired
	private EventosRepository eventosRepository;

	
	@PostConstruct
	public void run() {
		
		
		Eventos e = Eventos.builder()
					.asunto("HOLA")
					.lugar("micasas")
					.fecha(LocalDate.now())
					.organizador("pepe")
					.build();
		
		eventosRepository.save(e);
		
		
					
		
		
	}
}