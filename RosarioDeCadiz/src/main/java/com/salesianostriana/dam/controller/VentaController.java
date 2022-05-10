package com.salesianostriana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class VentaController {
	
	@GetMapping 
	public String ventaBanda() {
		
		return "Productos"; //Nombre de la página en la quen iría la venta del producto
	}
}
