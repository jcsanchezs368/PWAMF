package es.ercilla.api.services;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/operacion")
public class OperacionRestService {
	@GET
	@Path("/suma/{numero1}/{numero2}")
	@Produces(MediaType.TEXT_PLAIN)
	public int sumar(@PathParam("numero1") int numero1, @PathParam("numero2") int numero2) {
		return numero1 + numero2;
	}
	
	@GET
	@Path("/concatenar/{string1}/{string2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String concatenar(@PathParam("string1") String string1, @PathParam("string2") String string2) {
		return string1 + string2;
	}
	
	
}
