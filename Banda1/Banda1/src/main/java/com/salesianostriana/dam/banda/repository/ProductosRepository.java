package com.salesianostriana.dam.banda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.banda.model.Categoria;
import com.salesianostriana.dam.banda.model.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
	
	List<Productos> findByNombreContainsIgnoreCaseOrCategoriasNombreContainsIgnoreCase(String nombre, String nombre2);
	
	public long countByCategorias(Categoria categorias);
	
//	List<Productos> findByCategoriaId(Long id);
	
//	@Query("select p from productos p where p.categorias_id = 1")
//	public List<Productos> productosRopa();
//	
//	@Query("select p from productos p where p.categorias_id = 2")
//	public List<Productos> productosAccesorios();
	
//	@Query("select p from productos p where p.categoria.id = ?id_categoria")
//	public List<Productos> findByCategoriaId(Long id_categoria);
//	public List<Productos> findByCategoriasNombreContainsIgnoreCase(String nombre);	
	
//	@Query("select count(p) from productos p where p.categorias =?1 ")
//	public int findNumProductosByCategoria(Optional <Categoria> categoria);
	
}
