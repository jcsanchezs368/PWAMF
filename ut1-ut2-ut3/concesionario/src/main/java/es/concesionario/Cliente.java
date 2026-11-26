package es.concesionario;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="CLEINTE")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
	@SequenceGenerator(name="cliente_seq", sequenceName="CLIENTE_SEQ", allocationSize = 1)
	@Column(name="ID_CLIENTE", nullable = false)
	protected int idCliente;
	@Column(name = "DOCUMENTO", unique = true, nullable = false)
	protected String documento;
	@Column(name="APELLIDO1", nullable = false)
	protected String apellido1;
	@Column(name="APELLIDO2", nullable = false)
	protected String apellido2;
	
	
	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturas = new ArrayList<Factura>();
	
	@OneToMany
	@JoinTable(name="CLIENTE_PRODUCTO", joinColumns = @JoinColumn(name="idCliente"), inverseJoinColumns = @JoinColumn(name="idVehiculo", unique = true))
	protected int idVehiculo;
	
	protected List<Vehiculo> vehiculos;
	
	public Cliente() {
	
	}
	
	public Cliente(int idCliente, String documento, String apellido1, String apellido2, int idVehiculo) {
		super();
		this.idCliente = idCliente;
		this.documento = documento;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.idVehiculo = idVehiculo;
	}
	
	
	@XmlTransient
	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	
	
	
	
}
