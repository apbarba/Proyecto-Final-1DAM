package com.salesianostriana.dam.banda.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.banda.model.Categoria;
import com.salesianostriana.dam.banda.model.Productos;
import com.salesianostriana.dam.banda.servicios.CarritoServicio;
import com.salesianostriana.dam.banda.servicios.CategoriaServicios;
import com.salesianostriana.dam.banda.servicios.ProductosServicios;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

	@Autowired
	private CarritoServicio carritoServicio;
	
	@Autowired
	private ProductosServicios productosServicios;
	
	@Autowired
	private CategoriaServicios categoriaServicios;
	
	@GetMapping("/mostrarCarrito")
	public String mostrarCarrito(Model model) {
		
		List<Categoria> categorias = categoriaServicios.findAll();
		
		model.addAttribute("categorias", categorias);
		
		model.addAttribute("productos", carritoServicio.productosCarrito());
		
		return "carrito";
	}
	
	@GetMapping("/productoACarrito/{id}")
	public String productoACarrito(@PathVariable("id") long id, Model model) {
		
		Optional<Productos> comprobar = productosServicios.findById(id);
		
		if(comprobar.isPresent()) {
			
			carritoServicio.anadirProducto(comprobar.get());

			return "redirect: /carrito/mostrarCarrito";

		}else {
			
			return "redirect:/inicio";
		}
	}
	
	@GetMapping("/borrarProductoCarrito/{id}")
	public String eliminarProductoDelCarrito(@PathVariable("id") long id) {
		
		carritoServicio.eliminarProducto(productosServicios.findById(id));
		
		return "redirect:/carrito/mostrarCarrito";
	}
	
	@GetMapping("/checkout")
	public String checkout() {
		
		carritoServicio.completarTicket();
		
		return "redirect:/lista";
	}
	
	@ModelAttribute("precio_total")
	public double precioTotal() {
		
		Map<Productos, Integer> carrito = carritoServicio.productosCarrito();
		double total = 0.0;
		
		if(carrito != null) {
			
			for(Productos p : carrito.keySet()) {
				
				total += p.getPrecio() * carrito.get(p);
			}
			
			return total;
		}
		
		return 0.0;
	}
	
	@GetMapping("/carrito/mostrarCarrito")
	public String mostrarCarrito() {
		
		return "carrito";
	}
}
