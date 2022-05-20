package com.salesianostriana.dam.banda.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.banda.model.Categoria;
import com.salesianostriana.dam.banda.repository.CategoriaRepository;
import com.salesianostriana.dam.banda.servicios.base.ProductosBaseImpl;

@Service
public class CategoriaServicios extends ProductosBaseImpl<Categoria, Long, CategoriaRepository>{

	@Autowired	
	private CategoriaRepository categoriaRepository;

	public CategoriaServicios(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}

	public List<Categoria> findAll(){
		
		return categoriaRepository.findAll();
	}
	
	public Categoria save(Categoria categoria){
		
		return categoriaRepository.save(categoria);
	}
	
	public Optional<Categoria> findByCategoriaId(Long id) {
		
		return categoriaRepository.findById(id);
	}
	
	public void delete(Long id) {
		
		categoriaRepository.deleteById(id);
	}

}