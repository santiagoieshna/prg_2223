package leerArchivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Ejer4 {
	public static void main(String[] args) {
		
		String nombreArchivo ="Ejercicio3.txt";
		
		ArrayList<String> palabras = leerArchivo(nombreArchivo);
		System.out.println("\n-------Sin ordenar-----\n");
		imprimirPalabras(palabras);
		System.out.println("\n------------ordenado---------\n");
//		palabras= ordenarPalabras(palabras); //POR VALOR
		ordenarPalabras(palabras); // POR REFERENCIA
		escribirArchivo(nombreArchivo, palabras);
		palabras = leerArchivo(nombreArchivo);
		imprimirPalabras(palabras);
//		
		
		//METODOS PARA JUNTAR PALABRAS
//		// retorna las palabras sin espacio -> Existe el metodo String.join(" ", palabras);
//		palabras.forEach((str) -> System.out.print(str + " "));
//		// misma aplicacion anterior desde Wrapper String.join(" ", palabras)
//		System.out.println();
//		String contenido = String.join(" ", palabras);
//		System.out.println(contenido);
		
	}

	private static void escribirArchivo(String nombreArchivo, ArrayList<String> palabras) {
		BufferedWriter escritor = null;
		
		try {
			escritor = new BufferedWriter(new FileWriter(nombreArchivo));
			for(String palabra : palabras) {
				escritor.write(palabra);
				escritor.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				escritor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private static void imprimirPalabras(ArrayList<String> palabras) {
		palabras.forEach( palabra -> System.out.println(palabra));
	}
	
	/*
	 * Metodo que retornara una Lista de palabras contenidas en un fichero
	 */
	public static ArrayList<String> leerArchivo(String nombreArchivo){
		BufferedReader lector = null;
		String palabra;
		ArrayList<String> palabras= null;
		try {
			lector = new BufferedReader(new FileReader(nombreArchivo));
			palabras= new ArrayList<>();
			while((palabra=lector.readLine())!=null) {
				palabras.add(palabra);
			}
		}catch (IOException e) {
			System.out.println("Fallo en IOException");
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());			
//			e.printStackTrace();
		}finally {
			try {
				lector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return palabras;
	}
	
	public static ArrayList<String> ordenarPalabras(ArrayList<String> palabras){
		
		palabras.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2);
			}
		});
		
		return palabras;
	}
	
	public static void ordenarPalabrasReferencia(ArrayList<String> palabras){
		
		palabras.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {	
				return o1.compareToIgnoreCase(o2);
			}
		
		});
		
	}
}
