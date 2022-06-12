package com.salesianostriana.dam.banda.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.banda.model.LineaDeVenta;
import com.salesianostriana.dam.banda.repository.LineaDeVentaRepository;
import com.salesianostriana.dam.banda.servicios.base.ProductosBaseImpl;

@Service
public class LineaDeVentaServicio extends ProductosBaseImpl<LineaDeVenta, Long, LineaDeVentaRepository>{

	public List<LineaDeVenta> findByTicket(Long id){
		
		return repositorio.findByCarritoId(id);
	}
}
