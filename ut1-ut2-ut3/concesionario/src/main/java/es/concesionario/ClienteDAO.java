package es.concesionario;


import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ClienteDAO {
	public void comprarProducto(int idCliente, int idVehiculo) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		Cliente clienteRecuperado = null;
		
		Vehiculo vehiculoRecuperado = null;
		
		try {
			transaction.begin();
			clienteRecuperado = entityManager.find(Cliente.class, idCliente);
			vehiculoRecuperado = entityManager.find(Vehiculo.class, idVehiculo);
			
			clienteRecuperado.getVehiculos().add(vehiculoRecuperado);
			
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	public List<Cliente> listarClientes(){
		List<Cliente> clientes = null;
		
		try {
			EntityManager entityManager = JpaUtil.getEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			clientes = entityManager.createQuery("SELECT * FROM CLIENTES;", Cliente.class).getResultList();	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}

}
