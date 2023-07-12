package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Empleado extends Persona implements humano {

	private String idioma;
	private String correo;
	private Set<String> trabajos;
	
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param idioma
	 * @param correo
	 * @param trabajos
	 */
	public Empleado( String nombre, String idioma, String correo) {
		super( nombre);
		this.idioma = idioma;
		this.correo = correo;
		this.trabajos = new HashSet<>();
	}
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param idioma
	 * @param correo
	 * @param trabajos
	 */
	public Empleado( String nombre, String idioma) {
		super( nombre);
		this.idioma = idioma;
		this.trabajos = new HashSet<>();
	}
	
	

	public String getIdioma() {
		return idioma;
	}



	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public Set<String> getTrabajos() {
		return trabajos;
	}


	/**
	 * 
	 * @param trabajos String
	 */
	public void setTrabajos(Set<String> trabajos) {
		this.trabajos = trabajos;
	}
	
	public void addTrabajo(String trabajo) {
		this.trabajos.add(trabajo);
	}



	@Override
	public int getId() {
		
		return super.getId();
	}

	@Override
	public String getNombre() {
		
		return super.getNombre();
	}
	@Override
	public String toString() {
		return "Empleado [idioma=" + idioma + ", correo=" + correo + ", trabajos=" + trabajos + "]";
	}
	
	
	
}
