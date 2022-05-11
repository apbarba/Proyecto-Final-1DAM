package com.salesianostriana.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.model.EventosModel;

public interface EventosRepository extends JpaRepository<EventosModel, Long> {

}
