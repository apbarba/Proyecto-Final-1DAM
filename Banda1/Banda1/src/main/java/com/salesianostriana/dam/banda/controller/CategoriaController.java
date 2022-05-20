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
import com.salesianostriana.dam.banda.servicios.CategoriaServicios;
import com.salesianostriana.dam.banda.servicios.ProductosServicios;

@Controller
public class CategoriaController {

//	@Autowired
//	private CategoriaServicios categoriaServicios;
//	
//	@Autowired
//	private ProductosServicios productosServicios;
//	
//	@GetMapping("/categoria")
//	public String index(Model model) {
//		
//		model.addAttribute("categorias", categoriaServicios.findAll());
//		return "/categoria";
//	}
//	
//	@GetMapping("/categoriaNueva")
//	public String nuevaCategoria(Model model) {
//		
//		model.addAttribute("categoria", new Categoria());
//		
//		return "/formularioCategoria";
//	}
//	
//	@PostMapping("/categoriaNueva/submit")
//	public String submitNuevaCategoria(@ModelAttribute("categoria") Categoria categoria, Model model) {
//		
//		categoriaServicios.save(categoria);
//		
//		return "redirect:/categoria";
//	}
//	
//	@GetMapping("/categoriaEditar/{id}")
//	public String editarCategoria(@PathVariable("id") Long id, Model model) {
//		
//		Optional<Categoria> categoria = categoriaServicios.findById(id);
//		
//		if (categoria != null) {
//			
//			model.addAttribute("categoria", categoria);
//			
//			return "/formularioCategoria";
//			
//		} else {
//			
//			return "redirect:/categoria";
//		}
//		
//	}
	
//	@GetMapping("/borrar/{id}")
//	public String borrarCategoria(@PathVariable("id") Long id, Model model) {
//		
//		Optional<Categoria> categoria = categoriaServicios.findById(id);
//		
//		if (categoria != null) {
//			
//			if (productosServicios.numeroProductosCategoria(categoria) == 0) {
//				
//				categoriaServicios.delete(categoria);			
//				
//			} else {
//				
//				return "redirect:/admin/categoria/?error=true";
//			}
//			
//		} 
//
//		return "redirect:/admin/categoria/";
//		
//		
//	}
}
