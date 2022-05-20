package com.salesianostriana.dam.banda.servicios;

import java.time.LocalDate;
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
	 * No se si funciona, ya que a mi portatile sale error todos los gets y setters de los atributos, mientras
	 * que en las clases todo me funciona bien, sin problema alguno.s
	 */
//	public boolean eventoFecha(LocalDate fecha) {
//		
//		boolean colapsarFechaEventos = false;
//		
//		for (Eventos eventos : eventosRepository.findAll()) {
//			
//			if (eventos.getFecha().equals(fecha)) {
//				
//				return true;
//			}
//		}
//		return false;
//	}

}
