package com.salesianostriana.dam.banda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.banda.model.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
	
	List<Productos> findByNombreContainsIgnoreCaseOrCategoriasNombreContainsIgnoreCase(String nombre, String nombre2);
	
//	@Query("select p from productos p where p.categorias_id = 1")
//	public List<Productos> productosRopa();
//	
//	@Query("select p from productos p where p.categorias_id = 2")
//	public List<Productos> productosAccesorios();
	
//	@Query("select p from productos p where p.categoria.id = ?id_categoria")
//	public List<Productos> findByCategoriaId(Long id_categoria);
//	public List<Productos> findByCategoriasNombreContainsIgnoreCase(String nombre);	
}
