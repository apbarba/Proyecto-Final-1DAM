package com.salesianostriana.dam.banda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductosController {

	@GetMapping("/productos") 
	public String otra(Model model){
		model.addAttribute("mensaje", "Esto tamvién cojones");
		return "productos";//Mostramos otra página
	}
}
