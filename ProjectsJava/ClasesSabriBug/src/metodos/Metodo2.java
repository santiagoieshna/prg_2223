package metodos;

import java.util.Scanner;

public class Metodo2 {

	public static void main(String[] args) {
		
		
		int numero1; int numero2;
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Introduce un numero: ");
		numero1 = entrada.nextInt();
		System.out.print("Introduce un numero: ");
		numero2 = entrada.nextInt();
		
		
		NumerosAmigos(numero1);
		NumerosAmigos(numero2);
		
		

	}
	
	
	// Diseña un Metodo que pasado 2 numeros enteros por parametros, 
	//devuelva un Boolean segun si son numeros amigos o no.

	public static int DivisoresNumerosAmigos (int numero) {
		
		int sumatorio = 0;
		
		for(int i = 1; i <= numero; i++) {
			
			if(numero % i == 0) {
				
				sumatorio = sumatorio + i;
			}
			
		}
		
		return sumatorio;
	}
	
	public static boolean NumerosAmigos (int sumatorio) {
		
		boolean confirmacion = false;
		if(DivisoresNumerosAmigos(sumatorio) == DivisoresNumerosAmigos(sumatorio)) {
			
			confirmacion = true;
			
		}
		
		return confirmacion;
	}
}
