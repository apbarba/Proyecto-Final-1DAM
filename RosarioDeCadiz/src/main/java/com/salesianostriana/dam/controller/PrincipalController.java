package com.salesianostriana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class PrincipalController {


	@GetMapping("/productos")
	public String mostrar() {
		
		return "productos";
	}
}
