package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public interface Gestiones {
	
	/**
	 * 
	 * @param empleado
	 * @return True si se ha podido añadir el empleado.
	 * 			False caso contrario
	 */
	public boolean addEmpleado(Empleado empleado);
	public Empleado getEmpleado(int id);
	/**
	 * 
	 * @param trabajo
	 * @return int de empleados donde sus trabajos coincidan
	 * 	
	 */
	public int getNumeroEmpleados(String trabajoBuscado);
	public void addTrabajo(String trabajo, int id);
	public HashMap<String, Integer> getMapaIdioma();
	public ArrayList<String> getTodosTrabajosOrd();
	
}
