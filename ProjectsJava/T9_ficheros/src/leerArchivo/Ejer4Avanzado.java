package leerArchivo;

import java.io.IOException;

public class Ejer4Avanzado {

	public static void main(String[] args) {
		
		try {
			OrdenarArchivo.ordenar("Ejercicio3.txt");
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Yo ya");

	}

}
