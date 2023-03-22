package Modelos;

import java.util.ArrayList;
import java.util.Objects;

public class Contacto {
	private String nombre;
	private ArrayList<String> telefono;
	private ArrayList<String> email;
	
	
	/**
	 * 
	 * @param nombre
	 */
	public Contacto(String nombre) {
		
		this.nombre = nombre;
		this.telefono = new ArrayList<>();
		this.email = new ArrayList<>();
		
	}
	
	/**
	 * 
	 * @param nombre
	 * @param telefono
	 * @param email
	 */
	public Contacto(String nombre, ArrayList<String> telefono, ArrayList<String> email) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getTelefono() {
		return telefono;
	}

	public void setTelefono(ArrayList<String> telefono) {
		this.telefono = telefono;
	}

	public ArrayList<String> getEmail() {
		return email;
	}

	public void setEmail(ArrayList<String> email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return nombre.length();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Contacto)
			return this.getNombre().equals(((Contacto) obj).getNombre());
		
		return false;
	}
	
	
		
}
