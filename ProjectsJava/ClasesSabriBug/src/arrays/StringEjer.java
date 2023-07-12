package arrays;

import java.util.Scanner;

public class StringEjer {
	public static void main(String[] args) {
		
		// Pide al usuario una frase y pasa esa frase a un array de caracteres
		Scanner entrada = new Scanner(System.in);
		String frase;
		char[] caracteres; // Declaro
		
		System.out.println("Inserte una frase: ");
		// Dar valor a frase
		frase = entrada.nextLine();
		
		 // Inicializamos a la logitud de la frase que insertemos
		caracteres= new char[frase.length()];
		
		// Recorremos caracteres e insertamos valores
		for (int i = 0; i < caracteres.length; i++) {
			
			caracteres[i]= frase.charAt(i);
			System.out.print(caracteres[i]);
		}
		
	}
	
	
}
