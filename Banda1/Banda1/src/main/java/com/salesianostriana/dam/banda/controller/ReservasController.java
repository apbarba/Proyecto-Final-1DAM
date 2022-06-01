package com.salesianostriana.dam.banda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.banda.servicios.ReservasServicios;

@Controller
public class ReservasController {

	@Autowired
	private ReservasServicios reservas;

	public ReservasController(ReservasServicios reservas) {
		super();
		this.reservas = reservas;
	}
	
	@GetMapping("/reserva")
	public String mostrarReservas(Model model) {
		
		model.addAttribute("lista", reservas.findAll());
		
		return "reserva";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		
		reservas.delete(id);
		
		return "redirect:/lista/reservas";
	}
	
	@GetMapping("/lista/reservas")
	public String mostrarRAdmin(Model model) {
		
		model.addAttribute("lista", reservas.findAll());
		
		return "reservaAdmin";
	}
	
}
