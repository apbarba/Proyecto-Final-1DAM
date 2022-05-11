package com.salesianostriana.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.model.ProductosModel;

public interface ProductosRepository extends JpaRepository<ProductosModel, Long> {

}
