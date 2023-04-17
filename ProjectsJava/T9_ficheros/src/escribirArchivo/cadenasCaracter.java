package escribirArchivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class cadenasCaracter {
	public static void main(String[] args) {
		List<String> cadenas = Arrays.asList(new String[] { "En un lugar de la Mancha",
				"de cuyo nombre no quiero acordarme,", "no ha mucho tiempo que vivía ",
				"un hidalgo de los de lanza en astillero", " adarga antigua", "rocín flaco y galgo corredor." });

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("quijote.txt"));
			for (String string : cadenas) {
				bw.write(string);
				bw.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				System.out.println("Archivo creado");
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
}
