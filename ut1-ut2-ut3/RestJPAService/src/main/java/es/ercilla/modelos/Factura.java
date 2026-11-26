package es.ercilla.modelos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "FACTURA")
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "factura_seq")
	@SequenceGenerator(name = "factura_seq", sequenceName = "FACTURA_SEQ", allocationSize = 1)
	@Column(name = "ID_FACTURA", nullable = false)
	private int idFactura;
	@Column(name = "IMPORTE")
	private double importe; 
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE", nullable = false)
	@JsonIgnoreProperties({"facturas"})
	private Cliente cliente; 
	// En la clase producto no hay que poner nada de @ManyToMany ni nada, aquí declaramos esta relación
	@ManyToMany
	@JoinTable(name = "FACTURA_PRODUCTO", joinColumns = @JoinColumn(name = "ID_FACTURA"), inverseJoinColumns = @JoinColumn(name="ID_PRODUCTO"))
	private List<Producto> productos = new ArrayList<Producto>();
	
}
