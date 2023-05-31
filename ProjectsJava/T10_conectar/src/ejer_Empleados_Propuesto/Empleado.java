package ejer_Empleados_Propuesto;

import java.util.Objects;

public class Empleado {
	private String numeroEmpleado;
	private String apellido;
	private String nombre;
	private String extension;
	private String email;
	private String codigoOficina;
	private String jefedirecto;
	private String puestoTrabajo;


	public Empleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
		
	}

	public Empleado(String numeroEmpleado, String apellido, String nombre, String extension, String email,
			String codigoOficina, String jefedirecto, String puestoTrabajo) {
		super();
		this.numeroEmpleado = numeroEmpleado;
		this.apellido = apellido;
		this.nombre = nombre;
		this.extension = extension;
		this.email = email;
		this.codigoOficina = codigoOficina;
		this.jefedirecto = jefedirecto;
		this.puestoTrabajo = puestoTrabajo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigoOficina() {
		return codigoOficina;
	}

	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}

	public String getJefedirecto() {
		return jefedirecto;
	}

	public void setJefedirecto(String jefedirecto) {
		this.jefedirecto = jefedirecto;
	}

	public String getPuestoTrabajo() {
		return puestoTrabajo;
	}

	public void setPuestoTrabajo(String puestoTrabajo) {
		this.puestoTrabajo = puestoTrabajo;
	}

	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}
	@Override
	public String toString() {
		return "Empleado [numeroEmpleado=" + numeroEmpleado + ", apellido=" + apellido + ", nombre=" + nombre
				+ ", extension=" + extension + ", email=" + email + ", codigoOficina=" + codigoOficina
				+ ", jefedirecto=" + jefedirecto + ", puestoTrabajo=" + puestoTrabajo + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(numeroEmpleado);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(numeroEmpleado, other.numeroEmpleado);
	}
	

}
