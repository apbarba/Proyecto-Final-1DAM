package com.salesianostriana.dam.banda.servicios;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.banda.model.Productos;
import com.salesianostriana.dam.banda.repository.ProductosRepository;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoServicios {

	@Autowired
	private ProductosRepository productosRepository;
	
	private Map<Productos, Integer> productos = new HashMap <> ();
	
	public CarritoServicios (ProductosRepository productorepository) {
		this.productosRepository=productorepository;
	}
	
	/**
	 * Si el producto ya está en el map (en el carrito), solo se incrementará en uno la cantidad, una unidad más
	 * Si el producto no está en el mapa, significa que no se ha comprado nada de él en este momento, por lo que se añade con cantidad 1
	 * 
	 * @param producto
	 * */
	
	public void addProducto (Productos p) {
		if (productos.containsKey(p)) {
			productos.replace(p, productos.get(p)+1);
		}else {
			productos.put(p, 1);
		}
	}
	
	/**
	 * Método que elimina un producto del carrito.
	 * Si en el carrito la cantidad de dicho producto es más de uno baja la cantidad en una unidad y si es uno elimina el producto entero
	 * @param producto
	 * */
	
	public void removeProducto (Productos p) {
		
        if (productos.containsKey(p)) {
            if (productos.get(p) > 1)
                productos.replace(p, productos.get(p) - 1);
            else if (productos.get(p) == 1) {
                productos.remove(p);
            }
        }
	}
	
    /**
     * @return unmodifiable Copia del carrito no modificable, solo vista
     */
	

    public Map<Productos, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(productos);
    }
	
    /**
     * Se debería tener un método para revisar si hay suficiente 
     * cantidad de productos en el stock 
     * (si se gestiona el stock) no desarrollada en este ejemplo,
     * puesto que no se gestiona ni el stock ni cantidad de producto 
     * es atributo de la clase POJO Producto,
     * esto debería estar gestionado en línea de pedido, pedido, etc.
     * Se podría tener una excepción propia 
     * (del estilo NotEnoughProductsInStockException) y gestionarlo
     */
}
