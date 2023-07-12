package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import modelo.Empleado;


public class GestionEmpleados implements Gestiones {
	
	private ArrayList<Empleado> empleados;
	

	public GestionEmpleados() {
		super();
		this.empleados = new ArrayList<Empleado>();
	}

	@Override
	public boolean addEmpleado(Empleado empleado) {
		if(empleado !=null) {
			empleados.add(empleado);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Empleado getEmpleado(int id) {
		for (Empleado empleado : empleados) {
			if(empleado.getId()==id) {
				return empleado;
			}	
		}
		return null;
	}

	@Override
	public int getNumeroEmpleados(String trabajoBuscado) {
		int cont=0;
		
		for (Empleado empleado : empleados) {
			
			for (String trabajo : empleado.getTrabajos()) {
				if(trabajo.toLowerCase().equals(trabajoBuscado.toLowerCase())) {
					cont ++;
				}
			}
		}
		
		return cont;
	}

	@Override
	public void addTrabajo(String trabajo, int id) {
		Empleado empleado = getEmpleado(id);
		empleado.addTrabajo(trabajo);
		
	}

	@Override
	public HashMap<String, Integer>  getMapaIdioma() {
		HashMap<String, Integer> mapaIdiomas = new HashMap<>();
		
		for (Empleado empleado : empleados) {
			Integer value = mapaIdiomas.get(empleado.getIdioma());
			// Si value es distinto de null es que existe
			if(value != null) {
				//Si existe cogemos su valor y lo machacamos incrementandolo
				value = value + 1;
				mapaIdiomas.put(empleado.getIdioma(),value );
			}
			else {
				//Si no existe se crea con Valor 1
				mapaIdiomas.put(empleado.getIdioma(),1);
			}
			
		}
		return mapaIdiomas;
	}

	private boolean idiomaExist(String idiomaBuscado,HashMap<String, Integer> mapaIdiomas) {
		for (String idioma : mapaIdiomas.keySet()) {
			
			if(idioma.equals(idiomaBuscado)) {
				return true;
			}
		
		}
		return false;
	}

	@Override
	public ArrayList<String> getTodosTrabajosOrd() {
		HashSet <String> todosTrabajos = new HashSet<>();
		ArrayList<String> trabajosList = new ArrayList<>();
		
		for (Empleado empleado : this.empleados) {
			for (String trabajo : empleado.getTrabajos()) {
				todosTrabajos.add(trabajo);
			}
		}
		// Lo pasamos a un ArrayList
		for (String trabajo : todosTrabajos) {
			trabajosList.add(trabajo);
		}
		
		Collections.sort(trabajosList,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o2.compareTo(o1);
			}
			
		});
		
		return trabajosList;
	}
	
	
	
}
