package com.salesianostriana.dam.banda.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.banda.model.Productos;
import com.salesianostriana.dam.banda.servicios.CarritoServicios;
import com.salesianostriana.dam.banda.servicios.ProductosServicios;

public class CarritoController {

	@Autowired
	private CarritoServicios carritoServicios;
	
	@Autowired
	private ProductosServicios productosServicios;
	
    @Autowired
    public CarritoController(CarritoServicios carritoServicios, ProductosServicios productosServicios) {
        this.carritoServicios = carritoServicios;
        this.productosServicios = productosServicios;
    }
    
    @GetMapping ("/carrito")
    public String showCarrito (Model model) {
    	
    	if (model.addAttribute("productos",carritoServicios.getProductsInCart()) == null)
    		return "redirect:/";
    	return "productos";
    }

    @GetMapping ("/productoACarrito/{id}")
    public String productoACarrito (@PathVariable("id") Long id, Model model) {
    	
    	carritoServicios.addProducto(productosServicios.findById(id));
    	    		 	
    	return "redirect:/carrito";
    }
    
    @GetMapping("/borrarProducto/{id}")
    public String removeProductFromCart(@PathVariable("id") Long id) {
        
    	carritoServicios.removeProducto(productosServicios.findById(id));
        return "redirect:/carrito";
    }
    
    @ModelAttribute("total_carrito")
    public Double totalCarrito () {
    	
    	Map <Productos,Integer> carrito=carritoServicios.getProductsInCart();
    	double total=0.0;
    	if (carrito !=null) {
        	for (Productos p: carrito.keySet()) {
        		total+=p.getPrecio()*carrito.get(p);
        	}
        	return total;
    	}
    	
    	return 0.0;
    }
}