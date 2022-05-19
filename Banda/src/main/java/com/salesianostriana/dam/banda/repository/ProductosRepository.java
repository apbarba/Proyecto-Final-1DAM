package com.salesianostriana.dam.banda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.banda.model.Categoria;
import com.salesianostriana.dam.banda.model.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
	
	List<Productos> findByNombreContainsIgnoreCase(String nombre);
	
	//Para Probar si funciona
	
//	@Query("select p.id from Producto p")
//	public List<Long> obtenerIds();
//	
//	@Query("select p from Producto p where p.categoria.id = ?1")
//	public List<Productos> findByCategoriaId(Long categoriaId);
//	
//	@Query("select count(p) from Producto p where p.categoria = ?1")
//	public int findNumProductosByCategoria(Categoria categoria);
	
}
