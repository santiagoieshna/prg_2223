package producto;

import java.util.HashMap;

public class Producto {

	private StringBuilder codigo;
	private StringBuilder nombre;
	private HashMap<Integer, Short> ventasAnuales;
	
	/**
	 * @param codigo
	 * @param nombre
	 * @param ventasAnuales
	 */
	public Producto(StringBuilder codigo, StringBuilder nombre, HashMap<Integer, Short> ventasAnuales) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ventasAnuales = ventasAnuales;
	}

	public StringBuilder getCodigo() {
		return codigo;
	}


	public StringBuilder getNombre() {
		return nombre;
	}

	public void setNombre(StringBuilder nombre) {
		this.nombre = nombre;
	}

	public HashMap<Integer, Short> getVentasAnuales() {
		return ventasAnuales;
	}

	public void setVentasAnuales(HashMap<Integer, Short> ventasAnuales) {
		this.ventasAnuales = ventasAnuales;
	}
	
	
	
}
