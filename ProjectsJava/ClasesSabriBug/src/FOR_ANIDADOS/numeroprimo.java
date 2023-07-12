package FOR_ANIDADOS;

import java.util.Scanner;

public class numeroprimo {

	public static void main(String[] args) {
		
		int numero = 0; int contador = 0;
		Scanner entrada = new Scanner(System.in);
				
		System.out.print("Introduce un numero para saber si es primo ");
		numero = entrada.nextInt();
		
		for(int i = 1; i <= numero; i++) {
			
			if(numero % i == 0) {
				
				contador++;	
			}	
		}
		
		if(contador == 2) {
			
			System.out.println(numero + " es primo ");
			
		} else {
			
			System.out.println(numero + " no es primo ");
		}

	}

}
