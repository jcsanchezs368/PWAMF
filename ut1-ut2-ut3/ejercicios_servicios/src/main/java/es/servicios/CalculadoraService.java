package es.servicios;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(serviceName = "CalculadoraService")
public class CalculadoraService {
	
	/**
	 * @param num1
	 * @param num2
	 * @return suma de num1 y num2
	 */
	
	@WebMethod(operationName = "sumar")
	public int sumar(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
		return num1 + num2;
	}
	
	@WebMethod(operationName = "restar")
	public int restar(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
		return num1 - num2;
	}
	
	@WebMethod(operationName = "multiplicar")
	public int multiplicar(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
		return num1 * num2;
	}
	
	@WebMethod(operationName = "dividir")
	public int dividir(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
		if(num2 != 0) {
			return num1 / num2;
		}
		return 0;
	}
}
