package programa;

public class GestionPrograma {
	
	private static Programa[] prgms = new Programa [25];
	private static int contador=0;
	
	public static void addPrograma(Programa software) {
		if(contador > 24) {
			prgms[contador]= new Programa (software);
			contador++;
		}	
	}
	
	public static void showContador() {
		System.out.println(contador);
	}
	
	public static Programa[] getProgramas() {
		return prgms;
	}
	
	public static void delPrograma() {
		
		prgms[contador]= new Programa();
		if(contador == 0) {			
			contador --;
		}
	}
	
	public static void showProgramas() {
		if (contador > 0){
			
			for(int i=0; i < contador;i++) {
				System.out.println((i+1)+"- "+prgms[i].getNombre());
			}
		}
	}
	
	public static void filterLicencia(String licencia) {
		Boolean isThere = false;
		
		for (int i= 0;i<contador;i++) {
			if(prgms[i].getLicencia().equalsIgnoreCase(licencia)) {
				System.out.println((i+1)+"- "+prgms[i].getNombre());
				isThere= true;
			}
			
			if (!isThere) {
				System.out.println("No hay registros con licencia: "+licencia);
			}	
		}
	}
	public static void filterFuncion(String funcion) {
		Boolean isThere = false;
		
		for (int i= 0;i<contador;i++) {
			if(prgms[i].getFuncion().equalsIgnoreCase(funcion)) {
				System.out.println((i+1)+"- "+prgms[i].getNombre());
				isThere= true;
			}
			
			if (!isThere) {
				System.out.println("No hay registros con licencia: "+funcion);
			}	
		}
	}
	
	public static Programa filterNombre(String nombre) {
		Boolean isThere = false;
		
		for (int i= 0;i<contador;i++) {
			if(prgms[i].getNombre().equalsIgnoreCase(nombre)) {
				System.out.println((i+1)+"- "+prgms[i].getNombre());
				return prgms[i];
			}
		}
			
		System.out.println("No hay registros con Nombre: "+nombre);
		return null;
	}
	

}
