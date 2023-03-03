package pruebas;

import java.util.ArrayList;

public class Declarar {

	public static void main(String[] args) {
		
		//DECLARAR ARRAYList
		ArrayList<Integer> b = new ArrayList<>();
		
		//AÑADIR UN NUMERO
		b.add(6);
		b.add(12);
		b.add(14);
		b.add(-5);
		
		//ELIMINAR UN NUMERO
		b.remove(0);
		
		//SUSTITUIR UNO POR OTRO
		b.set(0, 111);// --> Eliminara el nuemro de la posicion 0 y pondra el numero 111
		
		
	}
	
}
