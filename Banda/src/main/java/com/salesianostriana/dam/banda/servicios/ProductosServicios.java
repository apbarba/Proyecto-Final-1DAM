package com.salesianostriana.dam.banda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.banda.model.Eventos;
import com.salesianostriana.dam.banda.model.Productos;
import com.salesianostriana.dam.banda.repository.EventosRepository;
import com.salesianostriana.dam.banda.repository.ProductosRepository;

@Service 
public class ProductosServicios {

	@Autowired
	private ProductosRepository productosRepository;
	
	
	public ProductosServicios(ProductosRepository repo) {
		super();
		this.productosRepository = repo;
	}


	/**
	 * Inserta un nuevo alumno
	 * 
	 * @param a el Alumno a insertar
	 * @return El alumno ya insertado (con el Id no vacío).
	 */
	public Productos add(Productos p) { return productosRepository.save(p); }
	
	
	/**
	 * Edita un alumno, si existe; si no, lo inserta como uno nuevo.
	 * @param a
	 * @return
	 */
	public Productos edit(Productos p) { return productosRepository.save(p); }

	/**
	 * Elimina el alumno
	 * 
	 * @param a
	 */
	public void delete(Productos p ) { productosRepository.delete(p); }
	
	/**
	 * Elimina a un alumno por su Id
	 * @param id
	 */
	public void delete(long id) { productosRepository.deleteById(id); }
	
	/**
	 * Devuelve todos los alumnos
	 * @return
	 */
	public List<Productos> findAll() { return productosRepository.findAll(); }
	
	
	/**
	 * Devuelve un alumno en base a su Id
	 * @param id
	 * @return el alumno encontrado o <code>null</code>
	 */
	public Productos findById(long id) {
		return productosRepository.findById(id).orElse(null);
	}

}