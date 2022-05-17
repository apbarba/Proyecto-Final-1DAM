package com.salesianostriana.dam.banda.servicios.base;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public class ProductosBaseImpl<T,ID,R extends JpaRepository<T, ID>> implements ProductosBase<T, ID> {

	@Override
	public List<T> findAll() {
		
		return null;
	}

	@Override
	public Optional<T> findById(ID id) {
		
		return null;
	}

	@Override
	public T save(T a) {
		
		return null;
	}

	@Override
	public List<T> saveAll(List<T> list) {
		
		return null;
	}

	@Override
	public T edit(T a) {
		
		return null;
	}

	@Override
	public void delete(T a) {
		
	}

	@Override
	public void deleteById(ID id) {
		
	}

}
