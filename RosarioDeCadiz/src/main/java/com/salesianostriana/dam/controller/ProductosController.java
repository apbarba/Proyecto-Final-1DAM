package com.salesianostriana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductosController {
	
	@GetMapping 
	public String productosBanda() {
		
		return "Productos"; //Nombre de la página en la que se verá al igual que venta
	}
}
