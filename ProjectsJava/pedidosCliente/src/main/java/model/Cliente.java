package model;

import java.io.Serializable;

public class Cliente implements Serializable{
	private String numeroCliente;
	private String nombre;
	private String nombreContacto;
	private String apellidoContacto;
	private String telefono;
	private String direccionLinea1;
	private String direccionlinea2;
	private String ciudad;
	private String estado;
	private String cpostal;
	private String pais;
	private String empleadoGestorVentas;
	private Float limiteCredito;
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(String numeroCliente, String nombre, String nombreContacto, String apellidoContacto, String telefono,
			String direccionLinea1, String direccionlinea2, String ciudad, String estado, String cpostal, String pais,
			String empleadoGestorVentas, float limiteCredito) {
		super();
		this.numeroCliente = numeroCliente;
		this.nombre = nombre;
		this.nombreContacto = nombreContacto;
		this.apellidoContacto = apellidoContacto;
		this.telefono = telefono;
		this.direccionLinea1 = direccionLinea1;
		this.direccionlinea2 = direccionlinea2;
		this.ciudad = ciudad;
		this.estado = estado;
		this.cpostal = cpostal;
		this.pais = pais;
		this.empleadoGestorVentas = empleadoGestorVentas;
		this.limiteCredito = limiteCredito;
	}
	public String getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	public String getApellidoContacto() {
		return apellidoContacto;
	}
	public void setApellidoContacto(String apellidoContacto) {
		this.apellidoContacto = apellidoContacto;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccionLinea1() {
		return direccionLinea1;
	}
	public void setDireccionLinea1(String direccionLinea1) {
		this.direccionLinea1 = direccionLinea1;
	}
	public String getDireccionlinea2() {
		return direccionlinea2;
	}
	public void setDireccionlinea2(String direccionlinea2) {
		this.direccionlinea2 = direccionlinea2;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCpostal() {
		return cpostal;
	}
	public void setCpostal(String cpostal) {
		this.cpostal = cpostal;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEmpleadoGestorVentas() {
		return empleadoGestorVentas;
	}
	public void setEmpleadoGestorVentas(String empleadoGestorVentas) {
		this.empleadoGestorVentas = empleadoGestorVentas;
	}
	public Float getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(Float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	@Override
	public String toString() {
		return "Cliente [numeroCliente=" + numeroCliente + ", nombre=" + nombre + ", nombreContacto=" + nombreContacto
				+ ", apellidoContacto=" + apellidoContacto + ", telefono=" + telefono + ", ciudad=" + ciudad + ", pais="
				+ pais + "]";
	}
	
}
