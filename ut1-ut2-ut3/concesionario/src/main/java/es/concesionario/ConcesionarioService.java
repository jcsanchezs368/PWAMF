package es.concesionario;

import java.util.ArrayList;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(serviceName = "ConcesionarioService")
public class ConcesionarioService {
	private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	VehiculoDAO vehiculoDAO = new VehiculoDAO();
	
	@WebMethod(operationName = "insertarVehiculo")
	public String insertarProducto(@WebParam(name="vehiculo") Vehiculo v) {
		try {
			vehiculoDAO.insertarVehiculo(v);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return v + " guardado correctamente";
	}
	
	@WebMethod(operationName = "crearVehiculo")
	public String crearVehiculo(@WebParam(name="vehiculo") Vehiculo v) {
		if(!vehiculos.contains(v)) {
			vehiculos.add(v);
			return "Vehículo añadido: " + vehiculos.getLast();
		}
		
		System.out.println("No se pudo añadir el vehículo " + v);
		return "No se pudo añadir el vehículo " + v;
	}
	
	@WebMethod(operationName = "borrarVehiculo")
	public String borrarVehiculo(@WebParam(name="vehiculo") Vehiculo v) {
		
		if(vehiculos.remove(v)) {
			System.out.println("Vehiculo Eliminado: " + v);
			return "Vehículo Eliminado:" + v;
		}
		System.out.println("No se pudo eliminar el vehículo " + v);
		return "No se pudo eliminar el vehículo" + v;
		
	}
	
	@WebMethod(operationName = "consultaVehiculo")
	public Vehiculo consultaVehiculo(@WebParam(name="vehiculo") Vehiculo v) {
		if(vehiculos.contains(v)) {
			return v;
		}
		return null;
	}
	
	@WebMethod(operationName = "editarVehiculo")
	public String editarVehiculo(@WebParam(name="vehiculo") Vehiculo v, @WebParam(name="marca") String marca, @WebParam(name="modelo") String modelo, @WebParam(name="potencia") double potencia) {
			Vehiculo vModificado = consultaVehiculo(v);
			if(vModificado != null) {
			vModificado.setMarca(marca);
			vModificado.setModelo(modelo);
			vModificado.setPotencia(potencia);
			System.out.println("Vehículo Editado: " + v + " - " + vModificado);
			return "Vehículo Editado:" + v + " - " + vModificado;
			}
		return "No se ha modificado ningún vehículo";
	}
	
	@WebMethod(operationName = "listarVehiculos")
	public String listarVehiculos() {
		return this.vehiculos.toString();
	}
	
	
	
}
