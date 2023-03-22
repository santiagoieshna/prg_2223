package modelo;

import java.util.ArrayList;

public interface Gestion {
	
	
	default void gestionar() {
		System.out.println("Esto es un default");
	}
	
	/**
	 * 
	 * @param cochecito
	 */
	public void addCoche(Coche cochecito);
	
	
	public ArrayList<Coche> showCochesAlquilados();
	
//	public ArrayList<Coche> sortCochesListj(a);
	public void sortCochesListj();
	
	
	
}
