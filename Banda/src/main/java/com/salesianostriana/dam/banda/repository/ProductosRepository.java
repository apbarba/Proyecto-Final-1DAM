package com.salesianostriana.dam.banda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.banda.model.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Long> {

	public  List<Productos> findByNombreContainingIgnoreCase(String nombre);

}
