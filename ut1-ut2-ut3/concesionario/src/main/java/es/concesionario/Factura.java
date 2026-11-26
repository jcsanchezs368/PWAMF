package es.concesionario;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "factura_seq")
	@SequenceGenerator(name="factura_seq", sequenceName="FACTURA_SEQ", allocationSize = 1)
	@Column(name = "ID_FACTURA", nullable = false)
	private int idFactura;
	@Column(name = "IMPORTE", nullable = false)
	private double importe;
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE", nullable = false)
	private Cliente cliente;
	
	@ManyToMany
	@JoinTable(name = "FACTURA_VEHICULO", joinColumns = @JoinColumn(name="ID_FACTURA"), inverseJoinColumns = @JoinColumn(name="ID_VEHICULO"))
	private List<Producto> productos = new ArrayList<Producto>();
	
}
