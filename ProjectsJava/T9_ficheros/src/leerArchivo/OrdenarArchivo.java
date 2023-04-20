package leerArchivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class OrdenarArchivo  {

	public static void ordenar(String nombreArchivo) throws IOException {

		ArrayList<String> palabras = leerArchivo(nombreArchivo);
		ordenarPalabrasReferencia(palabras);
		escribirArchivo(nombreArchivo, palabras);

	}

	private static ArrayList<String> leerArchivo(String nombreArchivo) throws IOException  {
		BufferedReader lector = null;
		String palabra;
		ArrayList<String> palabras= null;
		
			lector = new BufferedReader(new FileReader(nombreArchivo));
			palabras= new ArrayList<>();
			while((palabra=lector.readLine())!=null) {
				palabras.add(palabra);
			}
				lector.close();
			
		
		return palabras;
	}

	private static void ordenarPalabrasReferencia(ArrayList<String> palabras) {

		palabras.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}

		});
	}

	private static void escribirArchivo(String nombreArchivo, ArrayList<String> palabras) throws IOException {
		BufferedWriter escritor = null;

		
			escritor = new BufferedWriter(new FileWriter(nombreArchivo));
			for (String palabra : palabras) {
				escritor.write(palabra);
				escritor.newLine();
			}
			escritor.close();
			
	}

	public static void imprimirPalabras(ArrayList<String> palabras) {
		palabras.forEach(palabra -> System.out.println(palabra));
	}

}
