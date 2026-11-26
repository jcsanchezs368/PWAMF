package es.concesionario;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="VEHICULOS")
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculo_seq")
	@SequenceGenerator(name="vehiculo_seq", sequenceName = "VEHICULO_SEQ", allocationSize = 1)
	@Column(name="ID_VEHICULO", nullable = false)
	protected int idVehiculo;
	@Column(name="MARCA")
	protected String marca;
	@Column(name="MODELO")
	protected String modelo;
	@Column(name="POTENCIA")
	protected double potencia;
	
	public Vehiculo() {
		
	}
	
	public Vehiculo(String marca, String modelo, double potencia) {
		this.marca = marca;
		this.modelo = modelo;
		this.potencia = potencia;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	@Override
	public String toString() {
		return "VEHÍCULO:\n"
				+ "\tMarca: " + this.marca + "\n"
				+ "\tModelo: " + this.modelo + "\n"
				+ "\tPotencia: " + this.potencia + "\n";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(marca, modelo, Double.valueOf(potencia));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo)
				&& Double.doubleToLongBits(potencia) == Double.doubleToLongBits(other.potencia);
	}
	
}
