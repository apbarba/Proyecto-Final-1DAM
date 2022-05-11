package com.salesianostriana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.model.EventosModel;
import com.salesianostriana.dam.servicios.EventosServicios;

@Controller 
public class EventosController {
	
	private EventosServicios eventos;
	
	
	public EventosController(EventosServicios eventos) {
		super();
		this.eventos = eventos;
	}


	@GetMapping({"/", "/eventos"}) //Para la vista que queremos ver
	public String eventosBanda(Model model) {
		
		model.addAttribute("eventosLista", eventos.findAll());
		
		return "Eventos"; //El nombre de la página html en la que irá los eventos de la banda
	}
	
	@GetMapping("/eventoNuevo")
	public String mostrarFormulario(Model model) {
		
		model.addAttribute("alumno", new EventosModel());
		
		return "Evento Nuevo";
	}
	
	@PostMapping("/eventoNuevo/proceso")
	public String procesarFormulario(@ModelAttribute("eventos") EventosModel e) {
		
		eventos.add(e);
		
		return "redirect:/";
	}
}
