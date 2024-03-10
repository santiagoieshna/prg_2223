package Listas;

import java.util.ArrayList;
import java.util.Random;

public class arrayList {

	public static void main(String[] args) {
		
		String nombre1 = "Sabrina";
		String nombre2 = "Samara";
		
		
		ArrayList<String> nombres = new ArrayList<>();
		
		nombres.add(nombre1);
		nombres.add(nombre2);
		
//		System.out.println(nombres.size());
		
//		for (int i = 0; i < nombres.size(); i++) {
//			String elemento = nombres.get(i);
//			System.out.println(elemento);
//		}
	
//		for (int i = 0; i < 10; i++) {
//			nombres.add(getRandomName()); 
//		}
//		
		
		// Llenar la lista
		String[] nombrecitos = getStaticNames();
		
		for (String nombrecito : nombrecitos) {
			nombres.add(nombrecito);
		}
		
		printLista(nombres);
		
		System.out.println("---------------------");
		
		//BORRAR ELEMENTO
		String samantha = "Samantha Peralta";
		
		int posicion = nombres.indexOf(samantha);
		System.out.println(posicion);
		
		System.out.println(nombres.get(posicion));
		
		
		System.out.println(nombres.remove(samantha));;
		System.out.println("-------Borrado-------");
		
		System.out.println(nombres.get(posicion));
//		printLista(nombres);
		
		
	}



	public static void printLista(ArrayList<String> nombres) {
		for (String nombre : nombres) {
			System.out.println(nombre);
		}
	}
	
	public static String getRandomName() {
		Random rnd = new Random();
		String[] nombres = {"Samantha", "Lira", "Carol", "Sabrina", "Samara"};
		String[] apellido = {"Peralta", "Vasquez", "Cristobal", "Bolivar"};
		String random = nombres[rnd.nextInt(nombres.length)]+" "+apellido[rnd.nextInt(apellido.length)];
		
		return random;
	}
	
	public static String[] getStaticNames() {
		String[] nombres = {"Samantha Peralta", "Lira Cristobal", "Carol Vasquez",
							"Sabrina Peralta", "Samara Peralta"};
		
		return nombres;
	}
	
}
