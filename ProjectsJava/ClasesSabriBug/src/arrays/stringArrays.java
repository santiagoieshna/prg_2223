package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class stringArrays {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] nombres = new String[5];
		String[] palabras = {"Hello", "Tony", "Sabrina", "Sebastian", "Ariel", "Rarita"};
		
		// For para mostrar valores
		for (int i = 0; i < nombres.length; i++) {
			
			System.out.print(nombres[i] + " ");
		}

		System.out.println();
		// For para insertar valores
		for (int i = 0; i < nombres.length; i++) {

			nombres[i] =  palabras[i]; // "nombre"+i
		}

		// For para mostrar valores
		for (int i = 0; i < nombres.length; i++) {
			System.out.print(nombres[i] + " ");
		}

//		System.out.println();
//		System.out.println(Arrays.toString(nombres));

	}
	
	
	
}
