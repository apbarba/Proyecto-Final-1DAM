//package com.salesianostriana.dam.banda.servicios;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
//import org.springframework.stereotype.Service;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.salesianostriana.dam.banda.model.Carrito;
//import com.salesianostriana.dam.banda.model.LineaDeVenta;
//import com.salesianostriana.dam.banda.model.Productos;
//import com.salesianostriana.dam.banda.repository.CarritoRepository;
//import com.salesianostriana.dam.banda.servicios.base.CarritoBaseII;
//
//@Service
//@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
//public class CarritoServicios extends CarritoBaseII<Carrito, Long, CarritoRepository>{
//
//	@Autowired
//	private ProductosServicios productos;
//	
//	@Autowired
//	private Map<Productos, Integer> listaP = new HashMap<>();
//	
//	@Autowired
//	private LineaDeVentaServicios lineaVenta;
//	
//	
//
//	public CarritoServicios(ProductosServicios productos, Map<Productos, Integer> lista) {
//		super();
//		this.productos = productos;
//		this.listaP = lista;
//	}
//
//
//	public void implementarProducto(Productos p) {
//		
//		int uno = 1;
//		
//		if(listaP.containsKey(p)) {
//			
//			listaP.replace(p, listaP.get(p) + uno);
//			
//		}else {
//			
//			listaP.put(p, uno);
//		}
//	}
//	
//	public void eliminarProducto(Productos p) {
//		
//		int uno = 1;
//		
//		if(listaP.containsKey(p)) {
//			
//			if(listaP.get(p) > uno)
//				listaP.replace(p, listaP.get(p) - uno);
//			
//			else if(listaP.get(p) == uno) {
//				
//				listaP.remove(p);
//			}
//		}
//	}
//	
//	  public Map<Productos, Integer> getProductsInCart() {
//		  
//	        return Collections.unmodifiableMap(listaP);
//	    }
//	  
//	  
//		
//	  public void completarTicket() {
//		  
//		  List<LineaDeVenta> lista = new ArrayList<LineaDeVenta>();
//		  
//		  Carrito c;
//		  
//		  double totalCarrito = 0;
//		  
//		  for(Map.Entry<Productos, Integer> list : ((Map<Productos,Integer>) lista).entrySet()) {
//			  
//			  lista.add(
//					  LineaDeVenta.builder()
//					  
//					  .productos(list.getKey())
//					  .cantidad(list.getValue())
//					  .precioT(list.getKey().getPrecio() * list.getValue())
//					  .build()
//					  
//					  );
//			  
//			  totalCarrito += (list.getKey().getPrecio() * list.getValue());
//			  
//		  }
//		  
//		  c = Carrito.builder()
//				  
//				  .fecha(LocalDateTime.now())
//				  .total(totalCarrito)
//				  .build();
//		  
//		  if(!listaP.isEmpty()) {
//			  
//			  save(c);
//			  
//			  for(LineaDeVenta linea : lista) {
//				  
//				  linea.implementarTicket(c);
//			  	  lineaVenta.save(linea);
//			  }
//			  
//			  listaP.clear();
//		  }
//	  }
//
//}
