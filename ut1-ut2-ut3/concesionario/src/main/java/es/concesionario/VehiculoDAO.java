package es.concesionario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class VehiculoDAO {
	
	public void insertarVehiculo(Vehiculo v) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		entityManager.persist(v);
		
		transaction.commit();
		
		entityManager.close();
	}
	
	public Vehiculo eliminarVehiculo(int idProducto) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		Vehiculo v = recurerarProductoPorId(idProducto);
		try {
			if(v != null) {
				entityManager.remove(v);
				transaction.commit();
			}
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			entityManager.close();
		}
		
		return v;
		
	
	}
	
	public Vehiculo recurerarProductoPorId(int idVehiculo) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		Vehiculo v = null;
		
		try {
			transaction.begin();
			v = entityManager.find(Vehiculo.class, idVehiculo);
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			entityManager.close();
		}
		return v;
	}
	
	public void actualizarProducto(Vehiculo v) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			entityManager.merge(v);
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			entityManager.close();
		}
	}
	
	
	
}
