package escribirArchivo;

import java.io.FileWriter;
import java.io.IOException;

public class Ejer1 {
	/*
	 * Diseña un programa Java que cree un archivo en el que se guarde una cadena
	 * cualquiera carácter a carácter.
	 */
	public static void main(String[] args) {
		FileWriter fw = null;
		String cadena = "El dinero no puede comprar la vida";
		try {
			fw = new FileWriter("frase.txt");
			for (char c : cadena.toCharArray()) {
				fw.write(c);
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
	}
}
