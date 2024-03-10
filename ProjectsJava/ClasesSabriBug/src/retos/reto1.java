package retos;

public class reto1 {

	public static void main(String[] args) {

		/**
		 * ##########################################################################
		 * Crea un programa que cuente cuantas veces se repite cada palabra y que #
		 * muestre el recuento final de todas ellas. - Los signos de puntuación no #
		 * forman parte de la palabra. - Una palabra es la misma aunque aparezca en #
		 * mayúsculas y minúsculas. - No se pueden utilizar funciones propias del #
		 * lenguaje que lo resuelvan automáticamente. #
		 * ##########################################################################
		 **/

		String cadena = "hola amigo mio hola a todos hola a mi";
		String cadenaMin = "";
		int a = 0;
		String palabra = " ";
		int contador = contarPalabras(cadenaMin);
		String[] arrayPalabra = new String[contador];
		int [] coincidencias = new int[contador];

		cadenaMin = minusculas(cadena, cadenaMin);

		int i = 0;

		while (i < cadena.length()) {

			if (cadenaMin.charAt(i) != ' ') {

				palabra = palabra + cadena.charAt(i);

			} else {

				arrayPalabra[a] = palabra;
				a++;

			}
			i++;
		}

		for (int p = 0; p < arrayPalabra.length; p++) {

			int contadorCasualidades = 0;
			
			for (int o = 0; o < arrayPalabra.length; o++) {

			if (arrayPalabra[p].equals(arrayPalabra[o])) {
				
				contadorCasualidades++;
				
				}

			}
			
			coincidencias[p] = contadorCasualidades;
		}
		

		printCpincidencias(coincidencias);
	}



	public static void printCpincidencias(int[] coincidencias) {
		for (int k = 0; k < coincidencias.length; k++) {
			System.out.print( "coincidencias: "  + coincidencias[k]);
		}
	}

	

	public static String minusculas(String cadena, String cadenaMin) {

		for (int i = 0; i < cadena.length(); i++) {

			char letraMinuscula = (char) ((int) cadena.charAt(i) + 32);

			cadenaMin = cadenaMin + letraMinuscula;

		}

		return cadenaMin;
	}

	public static int contarPalabras(String cadena) {
		int contador = 0;
		for (int i = 0; i < cadena.length() - 1; i++) {

			if (cadena.charAt(i) == ' ' && cadena.charAt(i + 1) > 96 && cadena.charAt(i + 1) < 123) {

				contador++;
			}

		}

		return contador;

	}

}
