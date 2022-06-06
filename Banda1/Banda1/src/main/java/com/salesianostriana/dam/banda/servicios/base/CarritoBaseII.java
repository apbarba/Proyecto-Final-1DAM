package com.salesianostriana.dam.banda.servicios.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class CarritoBaseII<T, ID, R extends JpaRepository<T, ID>> implements CarritoBase<T, ID> {

	@Autowired
	protected R repository; //Favorable que sea proteguido para tener visibilidad
	
	@Override
	public List<T> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Optional<T> findById(ID id) {

		return repository.findById(id);
	}

	@Override
	public T save(T a) {

		return repository.save(a);
	}

	@Override
	public List<T> saveAll(List<T> list) {

		return repository.saveAll(list);
	}

	@Override
	public T edir(T a) {

		return save(a);
	}

	@Override
	public void delete(T a) {
		
		repository.delete(a);
		
	}

	@Override
	public void deleteById(ID id) {
		
		repository.deleteById(id);
	}

}
