package com.salesianostriana.dam.banda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	//Ruta de inicio, es decir, sin poner nada en el navegador después de localhost:9000/
	@GetMapping("/")
	public String index() {
		return "index";//Mostramos la plantilla index
	}


}