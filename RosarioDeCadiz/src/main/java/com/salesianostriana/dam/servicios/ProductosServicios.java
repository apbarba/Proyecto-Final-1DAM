package com.salesianostriana.dam.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.ProductosModel;
import com.salesianostriana.dam.repository.ProductosRepository;

@Service
public class ProductosServicios {
	
	@Autowired
	private ProductosRepository productos;
	
	public ProductosServicios(ProductosRepository productos) {
		super();
		this.productos = productos;
	}

//methods 
	
	public ProductosModel add(ProductosModel p) { 
		
		return productos.save(p); 
		
	}
	
	public ProductosModel edit(ProductosModel p) { 
		
		return productos.save(p); 
		
	}

	public void delete(ProductosModel p) { 
		
		productos.delete(p); 
		
	}
	

	public void delete(long id_productos) { 
		
		productos.deleteById(id_productos); 
		
	}
	
	public List<ProductosModel> findAll() { 
		
		return productos.findAll(); 
		
	}
	
	public ProductosModel findById(long id_productos) {
		
		return productos.findById(id_productos).orElse(null);
	}

}
