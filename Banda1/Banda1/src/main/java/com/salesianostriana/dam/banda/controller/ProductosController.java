package com.salesianostriana.dam.banda.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.banda.model.Categoria;
import com.salesianostriana.dam.banda.model.Productos;
import com.salesianostriana.dam.banda.servicios.CategoriaServicios;
import com.salesianostriana.dam.banda.servicios.ProductosServicios;

@Controller
//@RequestMapping("/admin")
public class ProductosController {
	
//	@GetMapping("/eventos") 
//	public String otra(Model model){
//		model.addAttribute("mensaje", "funciona");
//		return "eventos";//Mostramos la página eventos
//	}

	@Autowired
	private ProductosServicios productosServicio;

	@Autowired
	private CategoriaServicios categoriaServicios;
	
	@GetMapping("/lista")
	public String listarTodos(Model model) {
		
		model.addAttribute("lista", productosServicio.findAll());
		
		String[] enviar = new String[] {"Domicilio", "Recoger"};
		
		model.addAttribute("enviar", enviar);
		return "productos";
	}
	
	@GetMapping("/buscar")
	public String buscar(Model model, @RequestParam String nombre) {
		
		model.addAttribute("lista", productosServicio.buscarPorCategoriaONombre(nombre));
		
		return "productos";
	}
	
	@GetMapping("/nuevoProducto")
	public String mostrarFormulario(Model model) {
		
		model.addAttribute("productos", new Productos());
		
		model.addAttribute("categorias", categoriaServicios.findAll());
		
		return "formularioProductos";
	}
	
	
	@PostMapping("/productoNuevo/submit")
	public String procesarFormulario(@ModelAttribute("productos") Productos p) {
		
		productosServicio.add(p);
		
		return "redirect:/lista/producto";
	}
	
	
	@GetMapping("/editarProducto/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {		 
		
		Optional<Productos> aEditar = productosServicio.findById(id);
		
		if (aEditar.isPresent()) {
			
			model.addAttribute(aEditar.get());
			
			model.addAttribute("categorias", categoriaServicios.findAll());
			
			return "formularioProductos";
			
		} else {
			
			return "redirect:/lista/producto";
		}
		
		
	}
	
	@PostMapping("/editarProducto/submit")
	public String procesarFormularioEdicion(@ModelAttribute("productos") Productos p) {
		
		productosServicio.edit(p);
		
		return "redirect:/lista/producto";
	}
	
	@GetMapping("/borrarProducto/{id}")
	public String borrar(@PathVariable("id") long id, Model model) {
		
		Optional<Productos> p = productosServicio.findById(id);
		
		if(p.isPresent()) {
			
			productosServicio.deleteById(id);
		}
		
		return "redirect:/lista/producto";
	}
	
	@GetMapping("/lista/producto")
	public String mostrarProductosAdmin (Model model) {
		
		model.addAttribute("lista", productosServicio.findAll());
		
		return "productosAdmin";
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> categorias() {
		
		return categoriaServicios.findAll();
	}
	
//	@GetMapping("/productos/categoria{id}")
//	public String productosPorCategoria(Model model, @PathVariable("id") long id) {
//		
//		Optional<Categoria> c = categoriaServicios.findById(id);
//		
//		List<Productos> productos =  new ArrayList<>();
//		
//		for(Productos producto : productosServicio.findByCategoria(id)) {
//			
//			productos.add(producto);
//		}
//		
//		model.addAttribute("productos", productos);
//		model.addAttribute("categorias", c);
//		
//		return "categoria";
//	}


}

