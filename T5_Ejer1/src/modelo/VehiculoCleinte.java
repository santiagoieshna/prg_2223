package modelo;

import java.time.LocalDate;

public class VehiculoCleinte {
	private Cliente cliente;
	private Vehiculo vehiculo;
	private LocalDate fechaAlquiler;
	private int numeroDias;
	
	/**
	 * 
	 * @param cliente
	 * @param vehiculo
	 * @param fechaAlquiler
	 * @param numeroDias
	 */
	public VehiculoCleinte(Cliente cliente, Vehiculo vehiculo, LocalDate fechaAlquiler, int numeroDias) {
		super();
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.fechaAlquiler = fechaAlquiler;
		this.numeroDias = numeroDias;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}
	public void setFechaAlquiler(LocalDate fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}
	public int getNumeroDias() {
		return numeroDias;
	}
	public void setNumeroDias(int numeroDias) {
		this.numeroDias = numeroDias;
	}
	
	@Override
	public String toString() {
		return "VehiculoCleinte [cliente=" + cliente + ", vehiculo=" + vehiculo + ", fechaAlquiler=" + fechaAlquiler
				+ ", numeroDias=" + numeroDias + "]";
	}
}
