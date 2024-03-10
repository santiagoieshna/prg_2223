package metodos;

import java.util.Scanner;

public class Metodo1 {

	public static void main(String[] args) {

		int numero;
		boolean isPrimo;
		Scanner entrada = new Scanner(System.in);

		System.out.print("Introduce un numero: ");
		numero = entrada.nextInt();

		isPrimo = numeroPrimo(numero);

		System.out.println(isPrimo);
		System.out.println( numeroPrimo(numero));

	}

	public static boolean numeroPrimo(int numero) {

		int contador = 0;
		boolean primo = true;

		for (int i = 1; i <= numero; i++) {

			if (numero % i == 0) {

				contador++;
			}
		}

		if (contador != 2) {

			primo = false;

		}

		return primo;
	}

	// Diseña un Metodo que pasado 2 numeros enteros por parametros,
	// devuelva un Boolean segun si son numeros amigos o no.

	public static boolean numerosAmigos(int num1, int num2, int sumatorio1, int sumatorio2) {

		boolean resultado = true;

		if(num1 == sumatorio2 && num2 == sumatorio1) {
			
			
		} else {
			
			resultado = false;
			
		}
		
		return resultado;
	}

	public static void BucleAmigos(int num1) {

		int sumatorio = 0;

		for (int i = 1; i <= num1; i++) {

			if (num1 % i == 0) {

				sumatorio = sumatorio + i;

			}
		}
	}
}
