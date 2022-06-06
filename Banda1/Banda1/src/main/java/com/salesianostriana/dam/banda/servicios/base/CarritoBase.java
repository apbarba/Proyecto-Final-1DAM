package com.salesianostriana.dam.banda.servicios.base;

import java.util.List;
import java.util.Optional;

public interface CarritoBase<T, ID> {

	public List<T> findAll();
	
	public Optional<T> findById(ID id);
	
	public T save(T a);
	
	public List<T> saveAll(List<T> list);
	
	public T edir(T a);
	
	public void delete(T a);
	
	public void deleteById(ID id);
}
