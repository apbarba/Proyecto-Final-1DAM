package com.salesianostriana.dam.banda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.banda.model.Productos;
import com.salesianostriana.dam.banda.servicios.ProductosServicios;

@Controller
public class ProductosController {
	
//	@GetMapping("/eventos") 
//	public String otra(Model model){
//		model.addAttribute("mensaje", "Funciona");
//		return "eventos";//Mostramos la página eventos
//	}

	@Autowired
	private ProductosServicios productosServicio;
	
	public ProductosController(ProductosServicios servicio) {
		this.productosServicio = servicio;
	}

	@GetMapping("/lista")
	public String listarTodos(Model model) {
		
		model.addAttribute("lista", productosServicio.findAll());
		
		return "productos";
	}
	
	@GetMapping("/buscar")
	public String buscar(Model model, @RequestParam String nombre) {
		
		model.addAttribute("lista", productosServicio.buscarPorNombre(nombre));
		
		return "productos";
	}
	
	@GetMapping("/nuevoProducto")
	public String mostrarFormulario(Model model) {
		
		model.addAttribute("productos", new Productos());
		
		return "formularioProductos";
	}
	
	
	@PostMapping("/productoNuevo/submit")
	public String procesarFormulario(@ModelAttribute("productos") Productos p) {
		
		productosServicio.add(p);
		
		return "redirect:/";
	}
	
	@GetMapping("/editarProducto/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {		 
		
		Productos aEditar = productosServicio.findById(id);
		
		if (aEditar != null) {
			
			model.addAttribute("productos", aEditar);
			
			return "formularioProductos";
			
		} else {
			
			return "redirect:/";
		}
		
		
	}
	
	@PostMapping("/editarProducto/submit")
	public String procesarFormularioEdicion(@ModelAttribute("productos") Productos p) {
		
		productosServicio.edit(p);
		
		return "redirect:/";
	}
	
	@GetMapping("/borrarProducto/{id}")
	public String borrar(@PathVariable("id") long id) {
		
		productosServicio.delete(id);
		
		return "redirect:/";
	}
}
