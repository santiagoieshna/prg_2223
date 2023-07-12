package solucion1;

import java.util.List;
import java.util.Map;

public class Termino{
	
	private Map<Integer, Significado> significados;

	public Termino() {
		
	}
	
	public Termino(Map<Integer, Significado> significados) {
		super();
		this.significados = significados;
	}
	
	
	public Map<Integer, Significado> getSignificados() {
		return significados;
	}

	public void setSignificados(Map<Integer, Significado> significados) {
		this.significados = significados;
	}

	
	
}
