package com.salesianostriana.dam.banda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.banda.model.EventosModel;

public interface EventosRepository extends JpaRepository<EventosModel, Long> {

}
