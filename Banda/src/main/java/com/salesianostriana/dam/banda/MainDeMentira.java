package com.salesianostriana.dam.banda;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.banda.model.Eventos;
import com.salesianostriana.dam.banda.model.Productos;
import com.salesianostriana.dam.banda.repository.EventosRepository;
import com.salesianostriana.dam.banda.repository.ProductosRepository;

@Component
public class MainDeMentira {
	
	@Autowired
	private EventosRepository eventosRepository;
	
	@Autowired
	private ProductosRepository productosRepository;

	
	@PostConstruct
	public void run() {
		
		
		Eventos e = Eventos.builder()
					.asunto("HOLA")
					.lugar("micasas")
					.fecha(LocalDate.now())
					.organizador("pepe")
					.build();
		
		eventosRepository.save(e);
		
	}
	
	@PostConstruct
	public void runProducto() {
		
		Productos p = Productos.builder()
						.nombre("Pulsera")
						.cantidad(30)
						.precio(1.00)
						.disponibilidad(true)
						.build();
		
		productosRepository.save(p);
	}
}