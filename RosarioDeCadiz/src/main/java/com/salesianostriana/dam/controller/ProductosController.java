package com.salesianostriana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.model.EventosModel;
import com.salesianostriana.dam.model.ProductosModel;
import com.salesianostriana.dam.servicios.EventosServicios;
import com.salesianostriana.dam.servicios.ProductosServicios;

@Controller
public class ProductosController {
	
	@Controller 
	public class EventosController {
		
		private ProductosServicios productos;
		
		
		public EventosController(ProductosServicios productos) {
			super();
			this.productos = productos;
		}
		
		@GetMapping("/productos")
		public String mostrar() {
			
			return "productos";
		}

		@GetMapping({"/", "/productos"}) //Ruta de donde se encuentra
		public String eventosBanda(Model model) {
			
			model.addAttribute("productosLista", productos.findAll());
			
			return "productos"; //El nombre de la página html en la que irá los eventos de la banda
		}
		
		@GetMapping("/productoNuevo")
		public String mostrarFormulario(Model model) {
			
			model.addAttribute("alumno", new ProductosModel());
			
			return "productoNuevo";
		}
		
		@PostMapping("/productoNuevo/proceso")
		public String procesarFormulario(@ModelAttribute("eventos") ProductosModel e) {
			
			productos.add(e);
			
			return "redirect:/";
		}
		
		@GetMapping("/editar/{id}")
		public String mostrarFormularioEdicion(@PathVariable("id") long id_producto, Model model) { //Especificamos el nombre de la ruta
			
			ProductosModel edit = productos.findById(id_producto);
			
			if (edit != null) {
				
				model.addAttribute("alumno", edit);
				
				return "productos";
				
			} else {
				
				return "redirect:/";
			}
			
			
		}
		
		@PostMapping("/editar/submit")
		public String procesarFormularioEdicion(@ModelAttribute("eventos") ProductosModel e) { //El nombre que le damos al model
			
			productos.edit(e);
			
			return "redirect:/";
		}
		
		@GetMapping("/borrar/{id}")
		
		public String borrar(@PathVariable("id") long id_producto) { //Especificamos el nombre de la ruta
			
			productos.delete(id_producto);
			
			return "redirect:/";
		}
	}
}


//private String nombre_Producto;
//private int cantidad;
//private double precio;
//private boolean disponibilidad;
//private long id_producto;
