package es.ercilla.services;

import java.util.ArrayList;
import java.util.List;

import es.ercilla.modelo.Producto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/producto")
public class ProductoRestService {
	private static List<Producto> productos = new ArrayList<Producto>();
	
	@POST
	@Path("/insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertar(Producto p) {
		if(!productos.contains(p)) {
			productos.add(p);
			return "PRODUCTO: " + p + " insertado. Productos totales: " + productos;
		}
		
		return "El producto " + p + " ya existe";
	}
	
	@POST
	@Path("/insertarVarios")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertarVarios(ArrayList<Producto> productosInsertar) {
		String respuesta = "";
		for (Producto producto : productosInsertar) {
			if(!productos.contains(producto)) {
				productos.add(producto);
				respuesta += "PRODUCTO: " + producto + " insertado. Productos totales: " + productos + "\n";
			}
		}
		if(respuesta.isBlank()) {
			respuesta = "No se ha insertado ningún producto";
		}
		return respuesta;

	}
	
	@POST
	@Path("/eliminar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String eliminar(Producto p) {
		if(productos.contains(p)) {
			productos.remove(p);
			return "PRODUCTO: " + p + " eliminado. Productos restantes: " + productos;
		}
		return "El producto " + p + " no existe";
	}
	
	@POST
	@Path("/actualizar/{nombre}/{familia}/{precio}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizar(Producto p, @PathParam("nombre") String nombre, @PathParam("familia") String familia, @PathParam("precio")double precio) {
		String respuesta = "";			
		if(productos.contains(p)) {
			
			Producto producto = productos.get(productos.indexOf(p));
			
			if(nombre != null && !nombre.isBlank() && !producto.getNombre().equals(nombre)) {
				respuesta += "Nombre actualizado";
				producto.setNombre(nombre);
			}
			if(familia != null && !familia.isBlank() && !producto.getNombre().equals(familia)) {
				respuesta += "Familia actualizado";
				producto.setFamilia(familia);
			}
			if(precio > 0 && precio != producto.getPrecio()) {
				respuesta += "Precio actualizado";
				producto.setPrecio(precio);
			}
		}
		if(respuesta == "") {
			respuesta = "No se ha encontrado ningún producto por su ID.";
		}

		return respuesta;
	}
	
	@POST
	@Path("/actualizarConQueryParam")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarConQueryParam(Producto p, @QueryParam("nombre") String nombre, @QueryParam("familia") String familia, @QueryParam("precio") double precio) {
		String respuesta = "";			
		if(productos.contains(p)) {
			
			Producto producto = productos.get(productos.indexOf(p));
			
			if(nombre != null && !nombre.isBlank() && !producto.getNombre().equals(nombre)) {
				respuesta += "Nombre actualizado";
				producto.setNombre(nombre);
			}
			if(familia != null && !familia.isBlank() && !producto.getNombre().equals(familia)) {
				respuesta += "Familia actualizado";
				producto.setFamilia(familia);
			}
			if(precio > 0 && precio != producto.getPrecio()) {
				respuesta += "Precio actualizado";
				producto.setPrecio(precio);
			}
		}
		if(respuesta == "") {
			respuesta = "No se ha encontrado ningún producto por su ID.";
		}

		return respuesta;
	}
	
	
	
	@GET
	@Path("/consultar")
	@Produces(MediaType.TEXT_PLAIN)
	public String consultar() {
		if(productos.size() == 0) {
			return "No hay productos guardados";
		}
		return "Productos guardados: \n" + productos;
	}
	
	
}
