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
}


//private String nombre_Producto;
//private int cantidad;
//private double precio;
//private boolean disponibilidad;
//private long id_producto;
