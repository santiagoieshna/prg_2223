package entrenando;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public interface gestionable {
	
	public void addEmpleado(Empleado empleado);
	public Empleado getEmpleado(String id);
	public Integer getNumerosempleados(String trabajo);
	public boolean addTrabajo(String trabajo,String id);
	public HashMap<String, Integer> getMapaIdioma();
	/**
	 * Metodo que devuelve todos los diferentes trabajos
	 * ordenados de forma descendente.
	 * @return ArrayList<Atring>
	 */
	public ArrayList<String> getTodosTrabajosOrd();
	
	
}
