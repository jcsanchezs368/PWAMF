package es.ercilla.dao;

import es.ercilla.config.JpaUtil;
import es.ercilla.modelos.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProductoDAO {
	public String insertar(Producto producto) {
		String resultado = "";
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(producto);
			resultado = "Se ha insertado el producto: " + producto;
			et.commit();
			
		} catch (Exception e) {
			if(et.isActive()) {
				et.rollback();
				em.close();
			}
			resultado = "Error al introducir el producto";
		}
		return resultado;
	}
	
	public boolean actualizar(Producto producto) {
		boolean actualizado = false;
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(producto);
			et.commit();
			actualizado = true;
			
		} catch (Exception e) {
			if(et.isActive()) {
				et.rollback();
				em.close();
			}
			actualizado = false;
		}
		return actualizado;
	}
	
	public boolean eliminar(int idProducto) {
		boolean eliminado = false;
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Producto producto = null;
		try {
			et.begin();
			producto = em.find(Producto.class, idProducto);
			if(producto != null) {
				em.remove(producto);
				eliminado = true;
				et.commit();
			}
		} catch (Exception e) {
			if(et.isActive()) {
				et.rollback();
				em.close();
			}
		}
		return eliminado;
	}
	
	public Producto getById(int idProducto) {
		Producto producto = null;
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			producto = em.find(Producto.class, idProducto);
		} catch (Exception e) {
			if(et.isActive()) {
				em.close();
			}
		}
		return producto;
	}
}
