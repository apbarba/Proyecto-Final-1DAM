package com.salesianostriana.dam.banda.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.banda.model.Productos;
import com.salesianostriana.dam.banda.servicios.CarritoServicios;
import com.salesianostriana.dam.banda.servicios.CategoriaServicios;
import com.salesianostriana.dam.banda.servicios.ProductosServicios;

@Controller
public class CarritoController {

	@Autowired
	private CarritoServicios carrito;
	
	@Autowired
	private ProductosServicios productos;
	
	@Autowired
	private CategoriaServicios categoria;

	public CarritoController(CarritoServicios carrito, ProductosServicios productos) {
		super();
		this.carrito = carrito;
		this.productos = productos;
	}
	
	@GetMapping("/carrito")
	public String showCarrito(Model model) {
		
		if(model.addAttribute("lista", carrito.getProductsInCart()) == null)
			
			return "redirect:/carrito";
		
		return "carrito";
	}
	
	@GetMapping("/productoCarrito/{id}")
//	public String productosAlCarrito(@PathVariable("id") Long id) {
//		
//		carrito.implementarProducto(productos.findById(id));
//		
//		return "redirect:/carrito";
//	}
//	
//	@GetMapping("/borrarProductoCarrito/{id}")
//	public String eliminarProductoCarrito(@PathVariable("id") Long id) {
//		
//		carrito.eliminarProducto(productos.findById(id));
//		
//		return "redirect:/carrito";
//	}
	
	@ModelAttribute("precio_total")
	public double precioTotal() {
		
		Map<Productos, Integer> shopping = carrito.getProductsInCart();
		
		double total = 0;
		
		if(shopping != null) {
			
			for(Productos p : shopping.keySet()) {
				
				total += p.getPrecio() * shopping.get(p);
			}
			return total;
		}
		
		return 0;
	}
	
	@GetMapping("/checkout")
	public String checkout() {
		
		carrito.completarTicket();
		
		return "redirect:/lista/productos";
	}
}
