package errores;

import java.util.Scanner;

public class StringToParseInt {

	public static void main(String[] args) {
		/*
		 * Diseña un programa Java que solicite al usuario una cadena y la convierta en
		 * entero mediante Integer.parseInt. Estudia el error que se produce si no es
		 * posible la transformación, por ejemplo si la cadena no comienza en dígito.
		 * Captura el error y trátalo.
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
