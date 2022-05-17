package com.salesianostriana.dam.banda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.banda.model.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
	
	List<Productos> findByNombreContainsIgnoreCase(String nombre);
}
