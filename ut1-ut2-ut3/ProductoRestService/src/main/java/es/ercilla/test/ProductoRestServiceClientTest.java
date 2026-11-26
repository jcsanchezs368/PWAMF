package es.ercilla.test;

import es.ercilla.cliente.ProductoRestServiceCliente;
import es.ercilla.modelo.Producto;

public class ProductoRestServiceClientTest {
	
	public static void main(String[] args) {
		Producto producto = new Producto("Perfume muy caro", "Perfume", 200);
		
		ProductoRestServiceCliente cliente = new ProductoRestServiceCliente();
		System.out.println(cliente.insertar(producto));
		System.out.println(cliente.actualizar(producto, "Perfume extremadamente caro", "Perfume", 500 ));
	}
}
