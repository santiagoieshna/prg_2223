package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class GestionVehiculos implements Gestion {
	
	private ArrayList <Coche> vehiculos;
	

	public GestionVehiculos() {
		super();
		this.vehiculos =  new ArrayList<>();
	}

	@Override
	public void addCoche(Coche cochecito) {
		 vehiculos.add(cochecito);
	}

	@Override
	public ArrayList<Coche> showCochesAlquilados() {
		ArrayList<Coche> auxVehiculo = new ArrayList<>();
		
		for (Coche vehiculo : vehiculos) {
			if(vehiculo.isAlquilado()) {
				auxVehiculo.add(vehiculo);
			}
		}
		
		return auxVehiculo;
	}

	@Override
	public void sortCochesListj() {
		
//		Collection
		
		vehiculos.sort(new Comparator<Coche>() {

			@Override
			public int compare(Coche o1, Coche o2) {
				
				return o1.getMatricula().compareTo(o2.getMatricula())*-1;
			}	
			// Por puertas PARSE INTEGER
//			vehiculos.sort(new Comparator<Coche>() {
//				
//				@Override
//				public int compare(Coche o1, Coche o2) {
//					
//					Integer puerta1 = (Integer) o1.getPuertas();
//					Integer puerta2 = (Integer) o2.getPuertas();
//					
//					return puerta2.compareTo(puerta1);
//				}	
		});
		
	}

	@Override
	public String toString() {
		return  ""+vehiculos+"";
	}
}
