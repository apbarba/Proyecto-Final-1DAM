package com.salesianostriana.dam.banda.servicios;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.banda.model.Productos;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoServicios {

	@Autowired
	private ProductosServicios productos;
	
	@Autowired
	private Map<Productos, Integer> lista = new HashMap<>();
	
	

	public CarritoServicios(ProductosServicios productos, Map<Productos, Integer> lista) {
		super();
		this.productos = productos;
		this.lista = lista;
	}


	public void implementarProducto(Productos p) {
		
		int uno = 1;
		
		if(lista.containsKey(p)) {
			
			lista.replace(p, lista.get(p) + uno);
			
		}else {
			
			lista.put(p, uno);
		}
	}
	
	public void eliminarProducto(Productos p) {
		
		int uno = 1;
		
		if(lista.containsKey(p)) {
			
			if(lista.get(p) > uno)
				lista.replace(p, lista.get(p) - uno);
			
			else if(lista.get(p) == uno) {
				
				lista.remove(p);
			}
		}
	}
	
	//Me falta la configuración de stocks con un if 
	
}
