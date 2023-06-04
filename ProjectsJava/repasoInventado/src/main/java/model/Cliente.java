package model;

import java.io.Serializable;

public class Cliente implements Serializable{
	private String numeroCliente;
	private String nombre;
	private String telefono;
	private String ciudad;
	private String pais;
	
	public Cliente() {
		super();
	}
	public Cliente(String numeroClientes, String nombre, String telefono, String ciudad, String pais) {
		super();
		this.numeroCliente = numeroClientes;
		this.nombre = nombre;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "Clientes [numeroClientes=" + numeroCliente + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", ciudad=" + ciudad + ", pais=" + pais + "]";
	}
	public String getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(String numeroClientes) {
		this.numeroCliente = numeroClientes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
}
