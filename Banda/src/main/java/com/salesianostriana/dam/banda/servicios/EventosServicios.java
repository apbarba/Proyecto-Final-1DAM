package com.salesianostriana.dam.banda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.banda.model.EventosModel;
import com.salesianostriana.dam.banda.repository.EventosRepository;

@Service 
public class EventosServicios {

	@Autowired
	private EventosRepository eventosRepository;
	
	
	public EventosServicios(EventosRepository repo) {
		super();
		this.eventosRepository = repo;
	}


	/**
	 * Inserta un nuevo alumno
	 * 
	 * @param a el Alumno a insertar
	 * @return El alumno ya insertado (con el Id no vacío).
	 */
	public EventosModel add(EventosModel e) { return eventosRepository.save(e); }
	
	
	/**
	 * Edita un alumno, si existe; si no, lo inserta como uno nuevo.
	 * @param a
	 * @return
	 */
	public EventosModel edit(EventosModel e) { return eventosRepository.save(e); }

	/**
	 * Elimina el alumno
	 * 
	 * @param a
	 */
	public void delete(EventosModel e) { eventosRepository.delete(e); }
	
	/**
	 * Elimina a un alumno por su Id
	 * @param id
	 */
	public void delete(long id) { eventosRepository.deleteById(id); }
	
	/**
	 * Devuelve todos los alumnos
	 * @return
	 */
	public List<EventosModel> findAll() { return eventosRepository.findAll(); }
	
	
	/**
	 * Devuelve un alumno en base a su Id
	 * @param id
	 * @return el alumno encontrado o <code>null</code>
	 */
	public EventosModel findById(long id) {
		return eventosRepository.findById(id).orElse(null);
	}

}
