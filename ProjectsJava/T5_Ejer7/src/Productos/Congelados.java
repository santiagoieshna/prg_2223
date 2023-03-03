package Productos;

import java.time.LocalDate;

public class Congelados extends Productos {
	
	private double tempRecomendada;
	
	/**
	 * 
	 * @param idproducto
	 * @param descripcion
	 * @param fechaCaducidad
	 * @param numLote
	 * @param tempRecomendada
	 */
	public Congelados(String idproducto, String descripcion, LocalDate fechaCaducidad, String numLote,
			double tempRecomendada) {
		super(idproducto, descripcion, fechaCaducidad, numLote);
		this.tempRecomendada = tempRecomendada;
	}

	public double getTempRecomendada() {
		return tempRecomendada;
	}

	public void setTempRecomendada(double tempRecomendada) {
		this.tempRecomendada = tempRecomendada;
	}

	@Override
	public String toString() {
		
		return "Congelados  [idproducto=" + this.getIdproducto() + ", descripcion=" + this.getDescripcion() + ",\n\t fechaCaducidad="
				+ this.getFechaCaducidad() + ", numLote=" + this.getNumLote() + ";,tempRecomendada=" + tempRecomendada + "]";
	}
	
}
