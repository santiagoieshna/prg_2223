package errores;

import java.util.Scanner;

public class StringToParseInt {

	public static void main(String[] args) {
		/*
		 * Dise�a un programa Java que solicite al usuario una cadena y la convierta en
		 * entero mediante Integer.parseInt. Estudia el error que se produce si no es
		 * posible la transformaci�n, por ejemplo si la cadena no comienza en d�gito.
		 * Captura el error y tr�talo.
		 * 
		 */
		Integer numero;
		Scanner sc = new Scanner(System.in);
		String cadena = sc.nextLine();

		try {
			numero = Integer.parseInt(cadena);

		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e);

		}

	}

}
