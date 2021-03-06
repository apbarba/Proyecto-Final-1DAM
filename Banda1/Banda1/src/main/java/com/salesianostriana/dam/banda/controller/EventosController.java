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
		
		if(!eventosServicio.comprobarFechas(e.getFecha())) { //lógica de negocio, no se podrá añadir un evento con una fecha ocupada
			
			eventosServicio.add(e);
			
			return "redirect:/lista/eventos";
			
		}else {
			
			return "redirect:/nuevo/?error=true";
		}
		
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {

		Eventos aEditar = eventosServicio.findById(id);

		if (aEditar != null) {

			model.addAttribute("eventos", aEditar);

			return "formularioEvento";

		} else {

			return "redirect:/lista/eventos";
		}

	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("eventos") Eventos a) {

		eventosServicio.edit(a);

		return "redirect:/lista/eventos";
	}

	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {

		eventosServicio.delete(id);

		return "redirect:/lista/eventos";
	}

	@GetMapping("/lista/eventos")
	public String mostrarEventosAdmin(Model model) {

		model.addAttribute("lista", eventosServicio.findAll());

		return "eventosAdmin";
	}

	@GetMapping({ "/", "/inicio" })
	public String mostrarInicio() {
		return "index";
	}

	@GetMapping("/login")
	public String mostrarLogin() {
		return "login";
	}

}
