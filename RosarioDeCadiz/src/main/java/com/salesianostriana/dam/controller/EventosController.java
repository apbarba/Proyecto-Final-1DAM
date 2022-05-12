package com.salesianostriana.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.model.EventosModel;
import com.salesianostriana.dam.servicios.EventosServicios;

@Controller 
public class EventosController {
	
	@Autowired
	private EventosServicios eventos;
	
	
	public EventosController(EventosServicios eventos) {
		super();
		this.eventos = eventos;
	}


	@GetMapping({"/", "/eventos"}) //Ruta de donde se encuentra
	public String eventosBanda(Model model) {
		
		model.addAttribute("eventosLista", eventos.findAll());
		
		return "Eventos"; //El nombre de la página html en la que irá los eventos de la banda
	}
	
	@GetMapping("/eventoNuevo")
	public String mostrarFormulario(Model model) {
		
		model.addAttribute("eventos", new EventosModel());
		
		return "EventoNuevo"; //El nombre de la páguina en la que añadimos un evento nuevo
	}
	
	@PostMapping("/eventoNuevo/proceso")
	public String procesarFormulario(@ModelAttribute("eventos") EventosModel e) {
		
		eventos.add(e);
		
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id_evento, Model model) { //Especificamos el nombre de la ruta
		
		EventosModel edit = eventos.findById(id_evento);
		
		if (edit != null) {
			
			model.addAttribute("eventos", edit);
			
			return "Eventos";
			
		} else {
			
			return "redirect:/";
		}
		
		
	}
	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("eventos") EventosModel e) { //El nombre que le damos al model
		
		eventos.edit(e);
		
		return "redirect:/";
	}
	
	@GetMapping("/borrar/{id}")
	
	public String borrar(@PathVariable("id") long id) { //Especificamos el nombre de la ruta
		
		eventos.delete(id);
		
		return "redirect:/";
	}

}
