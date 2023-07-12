package entrenando;

import java.util.Set;

public class Empleado extends Persona implements humano {

	private String idioma;
	private String correo;
	private Set<String> trabajos;
	
	public Empleado() {
		super();
	}
	
	public Empleado(String idioma, String correo, Set<String> trabajos, String id, String nombre) {
		super(id, nombre);
		this.idioma = idioma;
		this.correo = correo;
		this.trabajos = trabajos;
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

	public void setTrabajos(Set<String> trabajos) {
		this.trabajos = trabajos;
	}

	@Override
	public String obetenerId() {
		return super.getId();
	}

	@Override
	public String obtenerNombre() {
		return super.getNombre();
	}
	
	
}
