package com.salesianostriana.dam.banda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.banda.model.EventosModel;
import com.salesianostriana.dam.banda.servicios.EventosServicios;

@Controller
public class EventosController {
	
//	@GetMapping("/eventos") 
//	public String otra(Model model){
//		model.addAttribute("mensaje", "Esto si cojones");
//		return "eventos";//Mostramos la página eventos
//	}
	
	/** Necesitaremos llamar a los métodos del servicio por lo que declaramos aquí un objeto del tipo AlumnoServicio con el que poder llamar
	 * a métodos de dicho servicio, en este caso, como solo es un envoltorio del repositorio solo serán cruds, pero podría ser cualquier otro*/
	
	private EventosServicios eventosServicio;
	
	public EventosController(EventosServicios servicio) {
		this.eventosServicio = servicio;
	}
	
	/**
	 * Método que gestiona la petición "índice" o de listado de alumnos, ya que en ambas se mostrará la lista completa de alumnos.
	 * Para ello, como puede verse, se añaden al GetMapping los dos nombres, entre comillas dobles separados por coma.
	 * 
	 */
	@GetMapping("/list")
	public String listarTodos(Model model) {
		
		model.addAttribute("lista", eventosServicio.findAll());
		
		return "eventos";
	}
	
	/**
	 * Método que atiende la petición de mostrar formulario, en este caso vacío. Pasamos al model un nuevo alumno vacío.
	 */
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		
		model.addAttribute("alumno", new EventosModel());
		
		return "formularioEvento";
	}
	
	/**
	 * Método que procesa la respuesta del formulario.
	 * Nombramos "la petición" en el PostMapping con la ruta /nuevo/submit para distinguirla de la de editar que será, 
	 * como puede verse más abajo, /editar/submit
	 * Por otro lado, no mandamos directamente a una web en el return, ya que esto no nos "pintaría" la tabla con el nuevo elemento
	 * sino que devolvemos o redirigimos de nuevo al controller inicial (listarTodos) para que pinte la tabla con el nuevo alumno recién agregado
	 */
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("alumno") EventosModel e) {
		
		eventosServicio.add(e);
		
		return "redirect:/";//Podría ser también return "redirect:/list
	}
	
	
	/**
	 * Método que atiende la petición de mostrar el formulario de edición de un alumno, con los datos del alumno a
	 * modificar ya cargados en los campos. Para ello, "cogeremos" el id al pinchar en el botón de editar del alumno seleccionado
	 * y por ello, {id}. Este id se decta como un parámetro al estar entre llaves y cambiará dependiendo de en qué alumno
	 * hayamos pinchado para editar. 
	 * 
	 * @param id del alumno a editar
	 * @param model
	 * @return
	 */
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		//Buscamos al alumno por id y recordemos que el método findById del servicio, devuelve el objeto buscado o null si no se encuentra.
		 
		
		EventosModel aEditar = eventosServicio.findById(id);
		
		if (aEditar != null) {
			
			model.addAttribute("alumno", aEditar);
			
			return "formularioEvento";
			
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/";
		}
		
		
	}
	
	/**
	 * Método que procesa la respuesta del formulario al editar
	 */
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("eventos") EventosModel a) {
		
		eventosServicio.edit(a);
		
		return "redirect:/";//Volvemos a redirigir la listado a través del controller para pintar la lista actualizada con la modificación hecha
	}
	
	/**
	 * Método que borrar un alumno por su Id
	 * @param id
	 * @return
	 */
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		
		eventosServicio.delete(id);
		
		return "redirect:/";
	}
}
