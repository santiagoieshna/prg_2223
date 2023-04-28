package alumno;

import java.util.Arrays;


public class Alumno implements java.io.Serializable{
	private String codigo;
	private String nombre;
	private Double[] notas;
	/**
	 * @param codigo
	 * @param nombre
	 * @param notas
	 */
	public Alumno(String codigo, String nombre, Double[] notas) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.notas = notas;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double[] getNotas() {
		return notas;
	}
	public void setNotas(Double[] notas) {
		this.notas = notas;
	}
	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", nombre=" + nombre + ", notas=" + Arrays.toString(notas) + "]";
	}
	
	/*
	 * Return nota media de los alumnos optenido de su atributo notas[]
	 */
	public Double getNotaMedia() {
		Double sum=0D;
		for (int i = 0; i < notas.length; i++) {
			sum += notas[i]; 
		} 
		return sum/notas.length;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	public StringBuilder notasToString() {
		StringBuilder notasString = new StringBuilder();
		for (int i = 0; i < notas.length; i++) {
			notasString.append(String.valueOf(notas[i]));
			if (i!=notas.length)
				notasString.append(" ,");
		}
		return notasString;
	}
	
	public Double notaMasAlta() {
		Double notaAlta = -99999D;
		
		for (Double nota : notas) {
			if(nota>notaAlta)
				notaAlta=nota;
		}
		
		return notaAlta;
	}
	
	
}
