package es.ercilla.modelos;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idCliente;
	@Column(name = "DOCUMENTO", nullable = false, unique = true)
	private String documento; 
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	@Column(name = "APELLIDO", nullable = false)
	private String apellido;
	
	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturas;
	
	public Cliente() {
		
	}

	public Cliente(int idCliente, String documento, String nombre, String apellido) {
		super();
		this.idCliente = idCliente;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Cliente(String documento, String nombre, String apellido) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, documento, Integer.valueOf(idCliente), nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(documento, other.documento)
				&& idCliente == other.idCliente && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", documento=" + documento + ", nombre=" + nombre + ", apellido="
				+ apellido + "]";
	}
	
	
	
	
}
