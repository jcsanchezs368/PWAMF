package es.ercilla.service;

import es.ercilla.dao.ProductoDAO;
import es.ercilla.modelos.Producto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/producto")
public class ProductoRestService {
	private ProductoDAO productoDAO = new ProductoDAO();
	
	@POST
	@Path("/insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertar(Producto producto) {
		return productoDAO.insertar(producto);
	}
	
	@GET
	@Path("/consultar/{idProducto}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getById(@PathParam("idProducto") int idProducto) {
		Producto p = productoDAO.getById(idProducto);
		if(p != null) {
			return "PRODUCTO ENCONTRADO: " + p;
		}
		return "No se ha encontrado el producto";
	}
	
	@DELETE
	@Path("/eliminar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String eliminar(Producto producto) {
		return productoDAO.eliminar(producto);
	}
	
	@PUT
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizar(Producto producto) {
		return productoDAO.actualizar(producto);
	}
	
	
	
}
