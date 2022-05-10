package com.salesianostriana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {

	@GetMapping
	public String contactoBanda() {
		
		return "Quienes Somos"; //Nombre de la página en la que se verá
	}
}
