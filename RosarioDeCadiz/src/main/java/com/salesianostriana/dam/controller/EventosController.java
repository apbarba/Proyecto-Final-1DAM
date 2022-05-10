package com.salesianostriana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class EventosController {
	
	@GetMapping //Para la vista que queremos ver
	public String eventosBanda() {
		
		return "Eventos"; //El nombre de la página html en la que irá los eventos de la banda
	}
}
