package com.salesianostriana.dam.banda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.banda.model.Eventos;
import com.salesianostriana.dam.banda.servicios.EventosServicios;

@Controller
//@RequestMapping("/admin")
public class EventosController {
	
//	@GetMapping("/eventos") 
//	public String otra(Model model){
//		model.addAttribute("mensaje", "Funciona");
//		return "eventos";//Mostramos la página eventos
//	}

	@Autowired
	private EventosServicios eventosServicio;
	
	public EventosController(EventosServicios servicio) {
		this.eventosServicio = servicio;
	}

	@GetMapping("/list")
	public String listarTodos(Model model) {
		
		model.addAttribute("lista", eventosServicio.findAll());
		
		return "eventos";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		
		model.addAttribute("eventos", new Eventos());
		
		return "formularioEvento";
	}
	
	
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("eventos") Eventos e) {
		
		eventosServicio.add(e);
		
		return "redirect:/list";
	}
	
	
	
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		 
		
		Eventos aEditar = eventosServicio.findById(id);
		
		if (aEditar != null) {
			
			model.addAttribute("eventos", aEditar);
			
			return "formularioEvento";
			
		} else {
	
			return "redirect:/list";
		}
		
		
	}
	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("eventos") Eventos a) {
		
		eventosServicio.edit(a);
		
		return "redirect:/";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		
		eventosServicio.delete(id);
		
		return "redirect:/list";
	}
}
