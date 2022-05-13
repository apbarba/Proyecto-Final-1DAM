package com.salesianostriana.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
		@Autowired
		private ProductosServicios productos;

		public ProductosController(ProductosServicios productos) {
			super();
			this.productos = productos;
		}

		@GetMapping("/productos") //Ruta de donde se encuentra
		public String eventosBanda(Model model) {
			
			model.addAttribute("productosLista", productos.findAll());
			
			return "Productos"; //El nombre de la página html en la que irá los eventos de la banda
		}
		
		@GetMapping ("/Mostrarproductos")
		public String mostrarProducto() {
			
			return "Productos";
		}
		
		@GetMapping("/productoNuevo")
		public String mostrarFormulario(Model model) {
			
			model.addAttribute("productos", new ProductosModel());
			
			return "ProductoNuevo";
		}
		
		@PostMapping("/productoNuevo/submit")
		public String procesarFormulario(@ModelAttribute("productos") ProductosModel e) {
			
			productos.add(e);
			
			return "redirect:/";
		}
		
		@GetMapping("/editar/{id}")
		public String mostrarFormularioEdicion(@PathVariable("id") long id_producto, Model model) { //Especificamos el nombre de la ruta
			
			ProductosModel edit = productos.findById(id_producto);
			
			if (edit != null) {
				
				model.addAttribute("productos", edit);
				
				return "Productos";
				
			} else {
				
				return "redirect:/";
			}
			
			
		}
		
		@PostMapping("/editar/submit")
		public String procesarFormularioEdicion(@ModelAttribute("productos") ProductosModel e) { //El nombre que le damos al model
			
			productos.edit(e);
			
			return "redirect:/";
		}
		
		@GetMapping("/borrar/{id}")
		
		public String borrar(@PathVariable("id") long id_producto) { //Especificamos el nombre de la ruta
			
			productos.delete(id_producto);
			
			return "redirect:/";
		}
	}



//private String nombre_Producto;
//private int cantidad;
//private double precio;
//private boolean disponibilidad;
//private long id_producto;
