package metodos;

import java.util.Scanner;

public class Metodo3 {
	public static void main(String[] args) {

		char caracter = ' ';
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Introduce un caracter: ");
		caracter = entrada.next().charAt(0);
		
		System.out.println(Ascii(caracter));
		
	}
	
	//Diseña un Metodo que pasado un caracter por Parametros devuelva su numero correspondiente del codigo ASCII 

	public static int Ascii (char caracter) {
		
		int conversion =  caracter;
		
		return conversion;
	}
	
	
	
	public static boolean asdasd(int numero) {
	
		boolean confirmacion = true;
		
		for(int i = 2; i <= numero; i+=2) {
			
			if(numero % i == 0) {
					
			}
		}
		return confirmacion;
}
	
}
