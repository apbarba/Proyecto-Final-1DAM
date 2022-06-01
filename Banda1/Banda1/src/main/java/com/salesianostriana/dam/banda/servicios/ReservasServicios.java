package com.salesianostriana.dam.banda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.banda.model.Productos;
import com.salesianostriana.dam.banda.model.Reserva;
import com.salesianostriana.dam.banda.repository.ReservasRepository;

@Service
public class ReservasServicios {

	@Autowired
	private ReservasRepository reservas;
	
	public void delete(Reserva r ) { 
		
		reservas.delete(r);
	}
	
	public void delete(long id) { 
		
		reservas.deleteById(id); 
	}
	
	public List<Reserva> findAll() {
		
		return reservas.findAll(); 
	}
	
}
