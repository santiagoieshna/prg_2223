package Ejercicio_5_6;

import java.time.LocalDate;

public class Alumno {

	// Atributos
	private String numeroExpediente;
	private String nombre;
	private String apellido;
	private LocalDate fechaNac;
	private String curso;

	private int notas1;
	private int notas2;

	public Alumno(String numeroExpediente, String nombre, String apellido, LocalDate fechaNac, String curso,
			int notas1, int notas2) {
		super();
		this.numeroExpediente = numeroExpediente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.curso = curso;

		this.notas1 = notas1; 

		this.notas2 = notas2;
	}

	// gets

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public String getNombre() {

		return this.nombre;

	}

	public String getApellido() {

		return this.apellido;

	}

	public String getCurso() {

		return this.curso;
	}

	public LocalDate getfechaNac() {

		return this.fechaNac;
	}

	// sets

	public void setNumeroExpediente(String numeroExpediente) {

		this.numeroExpediente = numeroExpediente;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;

	}

	public void setApellido(String apellido) {
		this.apellido = apellido;

	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public int getNotas1() {
		return notas1;
	}

	public void setNotas1(int notas1) {
		this.notas1 = notas1;
	}

	public int getNotas2() {
		return notas2;
	}

	public void setNotas2(int notas2) {
		this.notas2 = notas2;
	}

	@Override
	public String toString() {
		return "Alumno2 [numeroExpediente=" + numeroExpediente + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNac=" + fechaNac + ", curso=" + curso + "]";

	}

	public double getNotaMedia() {
		return (double) (notas1 + notas2) / 2;
	}

	public void datosAlumno(Alumno alumno) {

		System.out.println("Alumno: Nombre:" + getNombre() + getApellido() + "Nº Expediente:" + getNumeroExpediente()
				+ " - Nota final:" + getNotaMedia());
	}

}
