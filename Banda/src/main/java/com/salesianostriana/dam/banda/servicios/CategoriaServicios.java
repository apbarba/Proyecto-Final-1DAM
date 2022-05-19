package com.salesianostriana.dam.banda.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.banda.model.Categoria;
import com.salesianostriana.dam.banda.repository.CategoriaRepository;
import com.salesianostriana.dam.banda.servicios.base.ProductosBaseImpl;

@Service
public class CategoriaServicios extends ProductosBaseImpl<Categoria, Long, CategoriaRepository>{


}