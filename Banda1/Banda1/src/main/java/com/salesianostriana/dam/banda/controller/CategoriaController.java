package com.salesianostriana.dam.banda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.banda.model.Categoria;
import com.salesianostriana.dam.banda.model.Eventos;
import com.salesianostriana.dam.banda.model.Productos;
import com.salesianostriana.dam.banda.repository.CategoriaRepository;
import com.salesianostriana.dam.banda.servicios.CategoriaServicios;
import com.salesianostriana.dam.banda.servicios.ProductosServicios;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaServicios categoriaServicios;
	
	@Autowired
	private ProductosServicios productosServicios;
	
	@Autowired
	private CategoriaRepository categoriaRepsository;
	
	@GetMapping("/categoria")
	public String index(Model model) {
		
		model.addAttribute("lista", categoriaServicios.findAll());
		
		return "/categoria";
	}
	
	@GetMapping("/categoriaNueva")
	public String nuevaCategoria(Model model) {
		
		model.addAttribute("categoria", new Categoria());
		
		return "/formularioCategoria";
	}
	
	@PostMapping("/categoriaNueva/submit")
	public String submitNuevaCategoria(@ModelAttribute("categoria") Categoria categoria, Model model) {
		
		categoriaServicios.save(categoria);
		
		return "redirect:/categoria";
	}
	
	@GetMapping("/categoriaEditar/{id}")
	public String editarCategoria(@PathVariable("id") Long id, Model model) {
		
		Optional<Categoria> categoria = categoriaServicios.findById(id);
		
		if (categoria.isPresent()) {
			
			model.addAttribute(categoria.get());
						
		} 
			
		return "/formularioCategoria";
		
	}
	
	@PostMapping("/categoriaEditar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("categoria") Categoria c) {

		categoriaServicios.edit(c);

		return "redirect:/categoria";
	}
	
	@GetMapping("/borrarCategoria/{id}")
	public String borrarCategoria(@PathVariable("id") Long id, Model model) {
		
		Optional<Categoria> categoria = categoriaServicios.findById(id);
		
		if(categoria.isPresent()) {
			
			if(productosServicios.encontrarNumProductos(categoria.get()) == 0) { //Lógica de negocio, no se podrá eliminar una categoria que tenga productos asociados
				
				categoriaServicios.deleteById(id);
				
				return "redirect:/categoria";
				
			}else {
				
				return "redirect:/categoria/?error=true";
			}
			
		}else {
			
			return "redirect:/categoria";
		}
		
		
		
	}
	
	
}
