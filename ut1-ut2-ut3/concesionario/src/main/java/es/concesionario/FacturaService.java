package es.concesionario;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

public class FacturaService {
	private FacturaDAO facturaDAO = new FacturaDAO();
	private ClienteService clienteService = new ClienteService();
	private ProductoService productoService = new ProductoService();
	
	@WebMethod
	public String insertarFactura(@WebParam(name = "factura") FacturaRequest facturaRequest) {
		Factura factura = null;
		if(facturaRequest == null) {
			return "Factura nula o vacía, no se puede insertar";
		}
		factura = requestFacturaToFactura();
	}
}
