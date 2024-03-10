package Objetos;

public class Maestro {
	private String id;
	private String nombre;
	private String dni;
	private String titulo;
	private String especialidad;
	
	
	public Maestro(String nombre, String dni, String titulo, String especialidad) {
		this.nombre = nombre;
		this.dni = dni;
		this.titulo = titulo;
		this.especialidad = especialidad;
	}


	public String getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public String getDni() {
		return dni;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	
	
}
