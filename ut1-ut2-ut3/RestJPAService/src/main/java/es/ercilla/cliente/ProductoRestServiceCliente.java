package es.ercilla.cliente;

import es.ercilla.config.ConfiguracionAlmacenRestService;
import es.ercilla.modelos.Producto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;

public class ProductoRestServiceCliente {
	private Client client = null;
	
	public ProductoRestServiceCliente() {
		this.client = ClientBuilder.newBuilder().register(org.glassfish.jersey.jackson.JacksonFeature.class).build();
	}
	
	public String insertar(es.ercilla.modelos.Producto producto) {
		return client.target(ConfiguracionAlmacenRestService.URL_PRODUCTO)
				.path("insertar")
				.request(MediaType.TEXT_PLAIN)
				.post(Entity.entity(producto, MediaType.APPLICATION_JSON), String.class);
	}
	
	public String actualizar(Producto producto, String nombre, String familia, double precio) {
		return client.target(ConfiguracionAlmacenRestService.URL_PRODUCTO)
		.path("actualizar")
		.path(nombre)
		.path(familia)
		.path(String.valueOf(precio))
		.request(MediaType.TEXT_PLAIN)
		.post(Entity.entity(producto, MediaType.APPLICATION_JSON), String.class);
	}
	
	
	public String actualizarConQueryParam(Producto producto, String nombre, String familia, double precio) {
		return client.target(ConfiguracionAlmacenRestService.URL_PRODUCTO)
		.path("actualizar")
		.queryParam(nombre)
		.queryParam(familia)
		.queryParam(String.valueOf(precio))
		.request(MediaType.TEXT_PLAIN)
		.post(Entity.entity(producto, MediaType.APPLICATION_JSON), String.class);
	}
	
	public String consultar() {
		return client.target(ConfiguracionAlmacenRestService.URL_PRODUCTO)
				.path("consultar")
				.request(MediaType.TEXT_PLAIN).toString();
	}
}
