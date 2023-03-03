package Productos;

import java.time.LocalDate;

public class Frescos extends Productos {
	private LocalDate fechaEnvasado;
	private String paisOrigen;
	
	public Frescos(String idproducto, String descripcion, LocalDate fechaCaducidad, String numLote) {
		super(idproducto, descripcion, fechaCaducidad, numLote);
		
	}
	/**
	 * 
	 * @param idproducto
	 * @param descripcion
	 * @param fechaCaducidad
	 * @param numLote
	 * @param fechaEnvasado
	 * @param paisOrigen
	 */
	public Frescos(String idproducto, String descripcion, LocalDate fechaCaducidad, String numLote,
			LocalDate fechaEnvasado, String paisOrigen) {
		super(idproducto, descripcion, fechaCaducidad, numLote);
		this.fechaEnvasado = fechaEnvasado;
		this.paisOrigen = paisOrigen;
	}
	public LocalDate getFechaEnvasado() {
		return fechaEnvasado;
	}
	public void setFechaEnvasado(LocalDate fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	@Override
	public String toString() {
		return "Frescos [idproducto=" + this.getIdproducto() + ", descripcion=" + this.getDescripcion() + ",\n\t fechaCaducidad= "
				+ this.getFechaCaducidad() + ", numLote=" + this.getNumLote() + ",fechaEnvasado=" + fechaEnvasado + ",+"
				+ " paisOrigen=" + paisOrigen + "]";
	}
	
}
