package Productos;

import java.time.LocalDate;

public class Refrigerados extends Productos {
	private String orgSupervision;
	/**
	 * 
	 * @param idproducto
	 * @param descripcion
	 * @param fechaCaducidad
	 * @param numLote
	 * @param orgSupervision
	 */
	public Refrigerados(String idproducto, String descripcion, LocalDate fechaCaducidad, String numLote,
			String orgSupervision) {
		super(idproducto, descripcion, fechaCaducidad, numLote);
		this.orgSupervision = orgSupervision;
	}

	public String getOrgSupervision() {
		return orgSupervision;
	}

	public void setOrgSupervision(String orgSupervision) {
		this.orgSupervision = orgSupervision;
	}

	@Override
	public String toString() {
		return "Refrigerados [idproducto=" + this.getIdproducto() + ", descripcion=" + this.getDescripcion() + ",\n\t fechaCaducidad= "
				+ this.getFechaCaducidad() + ", numLote=" + this.getNumLote() +", orgSupervision=" + orgSupervision + "]";
	}
	
	
}
