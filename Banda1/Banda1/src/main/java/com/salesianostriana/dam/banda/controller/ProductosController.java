package com.salesianostriana.dam.banda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		
		return "redirect:/lista";
	}
	
	
	@GetMapping("/editarProducto/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {		 
		
		Productos aEditar = productosServicio.findById(id);
		
		if (aEditar != null) {
			
			model.addAttribute("productos", aEditar);
			
			model.addAttribute("categorias", categoriaServicios.findAll());
			
			return "formularioProductos";
			
		} else {
			
			return "redirect:/lista";
		}
		
		
	}
	
	@PostMapping("/editarProducto/submit")
	public String procesarFormularioEdicion(@ModelAttribute("productos") Productos p) {
		
		productosServicio.edit(p);
		
		return "redirect:/lista";
	}
	
	@GetMapping("/borrarProducto/{id}")
	public String borrar(@PathVariable("id") long id) {
		
		productosServicio.delete(id);
		
		return "redirect:/lista";
	}
	
	@GetMapping("/lista/producto")
	public String mostrarProductosAdmin () {
		return "productosAdmin";
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> categorias() {
		
		return categoriaServicios.findAll();
	}
	
	
	
	
	/**
	 * Nos llevará a la página ropa en la que se mostrarán los productos
	 * catalogados como ropa
	 * @return
	 */
//	@GetMapping("/categoriaRopa")
//	public String ropa() {
//		
//		productosServicio.productosRopa();
//		
//		return "ropa";
//	}
//	
//	/**
//	 * Nos llevará a la página accesorio y se mostrarán los productos
//	 * que tengan como categoria accesorios
//	 * @return
//	 */
//	@GetMapping("/categoriaAccesorios")
//	public String accesorios(){
//		
//		productosServicio.productosAccesorios();
//		
//		return "accesorios";
//	}


}

