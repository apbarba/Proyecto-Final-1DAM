package com.salesianostriana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.model.ContactoModel;

@Controller
public class ContactoController {

	@GetMapping("/contacto")
	public String contactoBanda(Model model) {
		
		model.addAttribute("contacto", new ContactoModel("603567854", "Diego Jimenez", "diegojimenez@gmail.com", "Director Musical de Rosario de Cádiz"));
		
		return "Quienes Somos"; //Nombre de la página en la que se verá
	}
	
	@GetMapping("/contacto")
	public String contactoBanda2(Model model) {
		
		model.addAttribute("contacto", new ContactoModel("256987546", "Manuel López", "manuellopez@gmail.com", "Hermano mayor de la hermandad Nuestras Señora del Rosario Coronada, Patrona y Alcaldesa Perpetua de la ciudad de Cádiz"));
		
		return "Quienes Somos";
	}
	
	@GetMapping("/contacto")
	public String contactoBanda3(Model model) {
		
		model.addAttribute("contacto", new ContactoModel("985754865", "Leandro Barba", "leandrobarba@gmail.com", "Director de la banda de Rosario de Cádiz"));
		
		return "Quines Somos";
	}
}
