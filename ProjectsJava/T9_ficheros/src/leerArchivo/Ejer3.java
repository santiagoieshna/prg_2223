package leerArchivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejer3 {
	/*
	 * Diseña un programa Java que solicite palabras (sin espacios) al usuario
	 * (método next() de Scanner) y las guarde en un archivo. EL proceso de petición
	 * finaliza cuando el usuario teclee “fin”.
	 */
	public static void main(String[] args) {
		String palabra="";
		Scanner sc = new Scanner(System.in);
		
		BufferedWriter escritor = null;
		System.out.println("Inserte palabras que se guardarán");
		
		try {
			escritor = new BufferedWriter(new FileWriter("Ejercicio3.txt"));
			while(!palabra.equalsIgnoreCase("fin")) {
				palabra=sc.next();
				if(!palabra.equalsIgnoreCase("fin")) {
					escritor.write(palabra);
					escritor.newLine();
				}
			}
			escritor.close();
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
