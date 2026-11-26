package es.ercilla.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

	@Entity
	@Table(name="PRODUCTO")
	public class Producto {
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculo_seq")
		@SequenceGenerator(name="vehiculo_seq", sequenceName = "VEHICULO_SEQ", allocationSize = 1)
		@Column(name="ID_PRODUCTO", nullable = false)
		protected int idProducto;
		@Column(name="NOMBRE")
		protected String nombre;
		@Column(name="CATEGORIA")
		protected String modelo;
		@Column(name="PRECIO")
		protected double precio;
		
		public Producto() {
			
		}
}
