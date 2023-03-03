package Productos;

import java.time.LocalDate;

public abstract class  Productos {
	private String idproducto;
	private String descripcion;
	private LocalDate fechaCaducidad;
	private String numLote;
	
	/**
	 * 
	 * @param idproducto
	 * @param descripcion
	 * @param fechaCaducidad
	 * @param numLote
	 */
	public Productos(String idproducto, String descripcion, LocalDate fechaCaducidad, String numLote) {
		
		this.idproducto = idproducto;
		this.descripcion = descripcion;
		this.fechaCaducidad = fechaCaducidad;
		this.numLote = numLote;
	}

	@Override
	public String toString() {
		return "Productos [idproducto=" + idproducto + ", descripcion=" + descripcion + ", fechaCaducidad="
				+ fechaCaducidad + ", numLote=" + numLote + "]";
	}

	public String getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getNumLote() {
		return numLote;
	}

	public void setNumLote(String numLote) {
		this.numLote = numLote;
	}
	
	
	
}
