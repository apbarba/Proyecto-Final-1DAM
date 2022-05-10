package com.salesianostriana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class PartiturasController {
	
	@GetMapping 
	public String partiturasBanda() {
		
		return "Repertorio"; //Nombre de la página en la que se mostrarían las partituras
	}
}
