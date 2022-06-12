package com.salesianostriana.dam.banda.servicios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.banda.model.Carrito;
import com.salesianostriana.dam.banda.model.LineaDeVenta;
import com.salesianostriana.dam.banda.model.Productos;
import com.salesianostriana.dam.banda.repository.CarritoRepository;
import com.salesianostriana.dam.banda.repository.ProductosRepository;
import com.salesianostriana.dam.banda.servicios.base.ProductosBaseImpl;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoServicio extends ProductosBaseImpl<Carrito, Long, CarritoRepository>{

	@Autowired
	private LineaDeVentaServicio lineaDeVentaServicio;
	
	@Autowired
	private ProductosRepository productosRepository;
	
	private Map<Productos, Integer> productos = new HashMap<>();
	
	
	public Map<Productos, Integer> productosCarrito(){
		
		return Collections.unmodifiableMap(productos);
	}
	
	public void anadirProducto (Productos p) {
		
		if(productos.containsKey(p)) {
			
			productos.replace(p, productos.get(p) + 1);
			
		}else {
			
			productos.put(p, 1);
		}
	}
	
	public void eliminarProducto(Optional<Productos> optional) {
		
		if (productos.containsKey(optional.get())) {
			
			if (productos.get(optional.get()) > 1)
				
				productos.replace(optional.get(), productos.get(optional.get()) - 1);
			
			else if (productos.get(optional.get()) == 1) {
			
				productos.remove(optional.get());
			}
		}

	}
	
		public void completarTicket() {

			  List<LineaDeVenta> listaLineaDeVenta = new ArrayList<LineaDeVenta>();

			  Carrito c;

			  double totalCarrito = 0;

			  for(Map.Entry<Productos, Integer> lineaDeVenta : productos.entrySet()) {

				  listaLineaDeVenta.add(
						  LineaDeVenta.builder()

						  .productos(lineaDeVenta.getKey())
						  .cantidad(lineaDeVenta.getValue())
						  .precioT(lineaDeVenta.getKey().getPrecio() * lineaDeVenta.getValue())
						  .build()

						  );

				  totalCarrito += (lineaDeVenta.getKey().getPrecio() * lineaDeVenta.getValue());

			  }

			  c = Carrito.builder()

					  .fecha(LocalDateTime.now())
					  .total(totalCarrito)
					  .build();

			  if(!listaLineaDeVenta.isEmpty()) {

				  save(c);

				  for(LineaDeVenta linea : listaLineaDeVenta) {

					  linea.implementarTicket(c);
					  lineaDeVentaServicio.save(linea);
				  }

				  productosRepository.flush();
				  productos.clear();
			  }
		  }

	}