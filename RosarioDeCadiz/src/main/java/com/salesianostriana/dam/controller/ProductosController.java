package com.salesianostriana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.model.ProductosModel;

@Controller
public class ProductosController {
	
	@GetMapping ("/productos")
	public String productosBanda(Model model) {
		
		model.addAttribute("productos", new ProductosModel("Camiseta Rosario",100, 23.50, true,1 ));
		
		return "Productos"; //Nombre de la página en la que se verá al igual que venta
	}
	
	@GetMapping ("/productos")
	public String productosBanda2(Model model) {
		
		model.addAttribute("productos", new ProductosModel("Polo Rosario", 100, 50.99, true,2));
		
		return "Productos";
	}
	
	@GetMapping ("/productos")
	public String productosBanda3(Model model) {
		
		model.addAttribute("productos", new ProductosModel("Pulsera Rosario", 100, 1.00, false,3));
		
		return "Productos";
		
	}
	
	@GetMapping ("/productos")
	public String productosBanda4( Model model) {
		
	model.addAttribute("productos", new ProductosModel("Manopla Escudo", 100, 5.00, false, 4));
		
	return "Productos";
	}
}


//private String nombre_Producto;
//private int cantidad;
//private double precio;
//private boolean disponibilidad;
//private long id_producto;
