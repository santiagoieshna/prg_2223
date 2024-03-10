package complejos1Eva;

import java.util.Random;

public class TiradasDado {
	public static void main(String[] args) {

		Integer tiradas = 6000; // numero de tiradas
		int tirada = 0;
		Random valorTirada = new Random();
		int[] contadorValores = new int[6]; // Contador de cada valor del dado
		
		for (int i = 0; i <= tiradas; i++) {
			
			tirada = valorTirada.nextInt(6)+1; // Obtener valor de la tirada 
			
			contadorValores[tirada-1] += 1; 
			
		}
		
		System.out.println("--Contador de valores--");
		//For para leer cualquier array
		for (int i = 0; i < contadorValores.length; i++) {
			System.out.println("Valor "+i+": "+contadorValores[i]);
		}
		
	}
}
