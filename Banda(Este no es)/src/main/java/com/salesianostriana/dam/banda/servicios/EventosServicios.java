package com.salesianostriana.dam.banda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.banda.model.Eventos;
import com.salesianostriana.dam.banda.repository.EventosRepository;

@Service 
public class EventosServicios {

	@Autowired
	private EventosRepository eventosRepository;
	
	
	public EventosServicios(EventosRepository repo) {
		super();
		this.eventosRepository = repo;
	}



	public Eventos add(Eventos e) { 
		
		return eventosRepository.save(e); 
		
	}
	

	public Eventos edit(Eventos e) { 
		
		return eventosRepository.save(e); 
		
	}

	
	public void delete(Eventos e) { 
		
		eventosRepository.delete(e);
		
	}
	

	public void delete(long id) {
		
		eventosRepository.deleteById(id); 
		
	}
	

	public List<Eventos> findAll() { 
		
		return eventosRepository.findAll(); 
		
	}
	
	

	public Eventos findById(long id) {
		
		return eventosRepository.findById(id).orElse(null);
	}

	/**
	 * Lógica de negocio en el cual no se podrá añadir un evento el mismo día que otro,
	 * por lo que debemos de buscar en la base de datos si ese evento que queremos añadir
	 * tiene una fecha en la cual no haya algún concierto, si es así, no se añadirá
	 * 
	 * @param eventos
	 * @return
	 */
//	public Eventos comprobarFecha(Eventos eventos) {
//		
//		if{
//			eventos
//		}
//		
//		
//	}
}
