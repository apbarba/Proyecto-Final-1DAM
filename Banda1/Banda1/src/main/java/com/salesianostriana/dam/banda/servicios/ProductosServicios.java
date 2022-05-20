package com.salesianostriana.dam.banda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.banda.model.Productos;
import com.salesianostriana.dam.banda.repository.ProductosRepository;

@Service 
public class ProductosServicios {

	@Autowired
	private ProductosRepository productosRepository;	
	
	public ProductosServicios(ProductosRepository repo) {
		super();
		this.productosRepository = repo;
	}

	public Productos add(Productos p) { 
		
		return productosRepository.save(p); 
	}
	
	public Productos edit(Productos p) { 
		
		return productosRepository.save(p); 
	}

	public void delete(Productos p ) { 
		
		productosRepository.delete(p);
	}
	
	public void delete(long id) { 
		
		productosRepository.deleteById(id); 
	}
	
	public List<Productos> findAll() {
		
		return productosRepository.findAll(); 
	}
	
	public Productos findById(long id) {
		
		return productosRepository.findById(id).orElse(null);
	}
	
/*	public List<Productos> buscarPorNombre(String nombre){
		
		return productosRepository.findByNombreContainsIgnoreCase(nombre);
	}*/
	
	
	public List<Productos> buscarPorCategoriaONombre(String nombre) {
		
		return productosRepository.findByNombreContainsIgnoreCaseOrCategoriasNombreContainsIgnoreCase(nombre, nombre);
	}
	
//	/**
//	 * Devolverá los productos que tengan como  categoria ropa
//	 */
//	public List<Productos> productosRopa(){
//		
//		return productosRepository.productosRopa();
//	}
//	
//	/**
//	 * Devolverá los productos que tengan como categoria accesorios
//	 * @return
//	 */
//	public List<Productos> productosAccesorios(){
//		
//		return productosRepository.productosAccesorios();
//	}

}