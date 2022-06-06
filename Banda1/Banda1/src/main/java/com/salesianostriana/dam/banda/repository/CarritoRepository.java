package com.salesianostriana.dam.banda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.banda.model.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long>{

}
