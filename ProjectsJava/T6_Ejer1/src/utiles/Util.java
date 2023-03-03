package utiles;

public class Util {

	public void leerChar(String cadena) {
		
		for (int i = 0; i < cadena.length(); i++) {
			
			System.out.println(cadena.charAt(i)+" es: ");
			if(Character.isAlphabetic(cadena.charAt(i))) {
				System.out.println("Letra");			
			}else if(Character.isDigit(cadena.charAt(i))) {
				System.out.println("Digito");
			}else {
				System.out.println("Otro");
			}	
		}
	}
	
	/**
	 * Dise�a una funci�n que reciba un array de cadenas y devuelva otro array en
	 * el que figuren las cadenas del primer array que finalizan con un patr�n
	 * concreto. La funci�n recibe el array y el patr�n
	 * @param cadenas
	 * @return
	 */
	public String[] catchPattern(String[] cadenas, String pattern) {
		String[] cadenasLimpias= new String[cadenas.length];
		
		for (int i = 0; i < cadenas.length; i++) {
			if(cadenas[i].endsWith(pattern)) {
				cadenasLimpias[i]=cadenas[i];
			}
		}
		return cadenasLimpias;
	}
	
	/**
	 * Dise�a una funci�n que reciba una cadena de palabras separadas por un
	 * mismo car�cter (punto y coma, coma, etc.) y devuelva un array de String con
	 * cada una de esas palabras. La funci�n tambi�n debe llevar como par�metro el
	 * separador
	 * @param frase
	 * @param patron
	 * @return
	 */
	public String[] escupePalabras(String frase, String patron) {
		String[] palabras;
		
		palabras = frase.split(patron);
		
		return palabras;
	}
	
	
}
