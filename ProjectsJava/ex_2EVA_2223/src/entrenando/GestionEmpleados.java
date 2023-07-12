package entrenando;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class GestionEmpleados implements gestionable {
	private ArrayList<Empleado> empleados;

	public GestionEmpleados() {
		super();
		empleados = new ArrayList<>();
	}

	@Override
	public void addEmpleado(Empleado empleado) {
		empleados.add(empleado);

	}

	@Override
	public Empleado getEmpleado(String id) {
		for (Empleado empleado : empleados) {
			if (empleado.getId().equals(id)) {
				return empleado;
			}
		}
		return null;
	}

	@Override
	public Integer getNumerosempleados(String trabajo) {
		Integer cont = 0;
		for (Empleado empleado : empleados) {
			for (String trabajoEmpleado : empleado.getTrabajos()) {
				if (trabajo.equals(trabajoEmpleado)) {
					cont++;
				}
			}
		}
		return cont;
	}

	@Override
	public boolean addTrabajo(String trabajo, String id) {
		boolean respuesta = false;
		Empleado empleado = getEmpleado(id);

		if (!empleado.getTrabajos().contains(trabajo)) {
			empleado.getTrabajos().add(trabajo);
			respuesta = true;
		}

		return respuesta;
	}

	@Override
	public HashMap<String, Integer> getMapaIdioma() {
		HashMap<String, Integer> mapaIdiomas = new HashMap<>();
		/**
		 * mapa{ "indio":2, "frances":1
		 * 
		 * }
		 * 
		 */
		for (Empleado empleado : empleados) {

			if (mapaIdiomas.get(empleado.getIdioma()) == null) {
				mapaIdiomas.put(empleado.getIdioma(), 1);
			} else {
				Integer valor = mapaIdiomas.get(empleado.getIdioma()) + 1;
				mapaIdiomas.put(empleado.getIdioma(), valor);
			}

		}

		return mapaIdiomas;
	}

	@Override
	public ArrayList<String> getTodosTrabajosOrd() {
		HashSet <String> todosTrabajos = new HashSet<>();
		ArrayList<String> trabajosList = new ArrayList<>();
		
		for (Empleado empleado : empleados) {
			for (String trabajo : empleado.getTrabajos()) {
				todosTrabajos.add(trabajo);
			}
		}
		
		// Lo pasamos a un ArrayList
		for (String trabajo : todosTrabajos) {
			trabajosList.add(trabajo);
		}
		
		//Se ordena
		Collections.sort(trabajosList,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o2.compareTo(o1);
			}
			
		});
		
		return trabajosList;
	}

}
