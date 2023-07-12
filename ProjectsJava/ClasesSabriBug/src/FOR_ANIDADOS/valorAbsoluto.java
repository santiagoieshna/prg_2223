package FOR_ANIDADOS;

import java.util.Scanner;

public class valorAbsoluto {

	public static void main(String[] args) {
		
		int numero1; int numeroSecuencial; int diferenciaActual = 99999999; int difMayor = -99999999;
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Cuantos numeros vas a introducir ");
		numero1 = entrada.nextInt();
		
		for(int i = 1; i <=numero1; i++) {
			
			System.out.println("Introduce el " + i + "º numero" );
			numeroSecuencial = entrada.nextInt();
			
			int numActual = numeroSecuencial;
			int resta = numeroSecuencial - numActual;
			System.out.println(resta);
			
//			if(diferenciaActual < difMayor) {
//				
//				diferenciaActual = difMayor;
//				System.out.println(diferenciaActual);
//				
//			}
			
		}
		
		

	}

}
