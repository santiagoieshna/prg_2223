package ejercicio;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	        char actual;
	        char anterior='1';
	        int contador=0;

	        do {
	            actual = sc.nextLine().charAt(0);

	            if(actual == '0') {
	                if(anterior == '5' || anterior == '6') {
	                    contador++;
	                }
	            }

	            anterior=actual;

	        }while(actual != '.');
		
	        System.out.println("el numero de 0 tras un 5 o un 6 es de: " + contador);
	}
}
