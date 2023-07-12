package metodos;

import java.util.Scanner;

public class NombreClase {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introdduce un numero");
		int numero = entrada.nextInt();
		
		System.out.println("El doble es");
		
		//Implementacion o aplicacion Que dobla el valor
		
//		doblarNumero(numero);
		int doble= devolverDoble(numero);
		
		System.out.println(doble);
		
	}
	
	private static void doblarNumero(int numerito) {
		numerito = numerito * 2;
		System.out.println(numerito);
	}
	
	private static int devolverDoble(int numerito) {
		numerito = numerito * 2;
		return numerito;
	}
	
	
}
