package com.salesianostriana.dam.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.EventosModel;
import com.salesianostriana.dam.repository.EventosRepository;

@Service
public class EventosServicios {

	@Autowired
	private EventosRepository eventos;
	
	public EventosServicios(EventosRepository eventos) {
		super();
		this.eventos = eventos;
	}

	public EventosModel add(EventosModel e) { 
		
		return eventos.save(e); 
		
	}
	
	public EventosModel edit(EventosModel e) { 
		
		return eventos.save(e); 
		
	}

	public void delete(EventosModel e) { 
		
		eventos.delete(e); 
		
	}
	
	public void delete(long id_eventos) { 
		
		eventos.deleteById(id_eventos); 
		
	}
	
	public List<EventosModel> findAll() { 
		
		return eventos.findAll(); 
		
	}
	
	public EventosModel findById(long id_evento) {
		return eventos.findById(id_evento).orElse(null);
	}
}
