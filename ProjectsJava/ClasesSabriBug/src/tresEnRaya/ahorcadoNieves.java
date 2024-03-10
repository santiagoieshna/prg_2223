package tresEnRaya;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class ahorcadoNieves {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int juegosGanados = 0;
		int juegosRealizados=0;
		Random random = new Random();

		String nombre = " ";
		int intentos = 10;
		int opcion = 0;

		char[] arrayVacio;
		String palabra = " ";

		System.out.println(
				"Temas disponibles: \n [0] Temas aleatorios \n [1] Animales \n [2] Partes del cuerpo \n [3] Nombre de paises \n [4] Comida \n "
						+ "[5] Instrumentos Musicales [6] Trabajos \n [7] Deportes \n [8] Asignaturas escolares \n [9] Vehiculos \n [10] El tiempo");
		System.out.print("Elige una opcion: ");
		opcion = entrada.nextInt();
		char[] arrayContenido = contenidoArray(opcion);

		System.out.println("\nComenzando... ");

		arrayVacio = new char[arrayContenido.length];
		llenarArrayVacio(arrayVacio);

		char[] arrayIntentos = new char[intentos + arrayContenido.length];
		llenarArrayVacio(arrayIntentos);
		
		boolean palabraCompleta = false;
		String jugarOtraVez;
		do {	
			while(intentos>0 && !palabraCompleta) {
				
				System.out.println();
				System.out.println("Te quedan "+intentos+" intentos.");
				System.out.println("Haz tu adivinanza: ");
				
				char letra = entrada.next().charAt(0);
				
				if(!esMayuscula(letra)) {
					letra = pasarAMayuscula(letra);
				}
				
				boolean letraRepetida = comprobarLetrasIntento(arrayIntentos,letra);
				
				if(letraRepetida) {
					
					System.out.println("\nYa has intentado esta letra, prueba otra\n");
				}else {
					boolean encontrada = false;
					for (int i = 0; i < arrayContenido.length; i++) {
						if(arrayContenido[i]== letra) {
							arrayVacio[i]= letra;
							encontrada = true;
						}
					}
					boolean letraIntroducida = false;
					for (int i=0; i<arrayIntentos.length; i ++) {
						if(arrayIntentos[i]=='-' && !letraIntroducida) { // a , b ,p , z , s , s , s, s , -
							arrayIntentos[i]= letra;
							letraIntroducida=true;
						}
					}
					
					if(!encontrada) {
						System.out.println("\nTu adivinanza es incorrecta!\n");
						intentos --;
					}
					
					palabraCompleta = comprobarPalabra(arrayContenido, arrayVacio);
					
				}
				printArray(arrayVacio);
				
			}
			
			juegosRealizados++;
			
			if(palabraCompleta) {
				System.out.println();
				System.out.println("Felicidades, has ganado!");
				juegosGanados ++;
				
			}else {
				System.out.println("\nNo tienes mas intentos, has perdido.");
			}
			System.out.println("¿Desea jugar otra vez? (Escribe S o N):");
			jugarOtraVez = entrada.next();
			// Como pongo todo esto en funciones?? 
			
			if(jugarOtraVez.equals("S")) {
				palabraCompleta=false;
				intentos=10;
				System.out.println(
						"Temas disponibles: \n [0] Temas aleatorios \n [1] Animales \n [2] Partes del cuerpo \n [3] Nombre de paises \n [4] Comida \n "
								+ "[5] Instrumentos Musicales [6] Trabajos \n [7] Deportes \n [8] Asignaturas escolares \n [9] Vehiculos \n [10] El tiempo");
				System.out.print("Elige una opcion: ");
				opcion = entrada.nextInt();
				arrayContenido = contenidoArray(opcion);
	
				System.out.println("\nComenzando... ");
	
				arrayVacio = new char[arrayContenido.length];
				llenarArrayVacio(arrayVacio);
	
				arrayIntentos = new char[intentos + arrayContenido.length];
				llenarArrayVacio(arrayIntentos);
			}
			
		}while(jugarOtraVez.equals("S"));
		
		System.out.println("Has ganado "+juegosGanados+" de "+juegosRealizados+" juegos. ¡Hasta pronto!");
	}

	private static char pasarAMayuscula(char letra) {
		return (char)(letra - 32);
	}

	private static boolean esMayuscula(char letra) {
		if(letra >= 'A' && letra <='Z') {
			return true;
		}
		return false;
	}

	private static boolean comprobarPalabra(char[] arrayContenido, char[] arrayVacio) {
		for (int i = 0; i < arrayVacio.length; i++) {
			if(arrayVacio[i]!=arrayContenido[i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean comprobarLetrasIntento(char[] arrayIntentos, char letra) {
		
		for (int i = 0; i < arrayIntentos.length; i++) {
			if(arrayIntentos[i]==letra) {
				return true;
			}
		}
		
		return false;
	}

	public static void printArray(char[] arrayContenido) {
		for (int i = 0; i < arrayContenido.length; i++) {

			System.out.print(arrayContenido[i]);

		}
	}

	public static void llenarArrayVacio(char[] arrayVacio) {
		for (int i = 0; i < arrayVacio.length; i++) {

			arrayVacio[i] = '-';

		}
	}

	public static char[] contenidoArray(int opcion) {
		char[] arrayContenido = new char[2];
		String palabra;
		switch (opcion) {

		case 0:

			palabra = "AMISTAD";
			arrayContenido = convertirChar(palabra);

			break;

		case 1:

			palabra = "AJOLOTE";
			arrayContenido = convertirChar(palabra);

			break;

		case 2:

			palabra = "ESTERNOCLEIDOMASTOIDEO";
			arrayContenido = convertirChar(palabra);

			break;

		case 3:

			palabra = "DINAMARCA";
			arrayContenido = convertirChar(palabra);

			break;

		case 4:

			palabra = "HAMBURGUESA";
			arrayContenido = convertirChar(palabra);

			break;

		case 5:

			palabra = "CLARINETE";
			arrayContenido =convertirChar(palabra);

			break;

		case 6:

			palabra = "ODONTOLOGO";
			arrayContenido = convertirChar(palabra);

			break;

		case 7:

			palabra = "BALONCESTO";
			arrayContenido = convertirChar(palabra);

			break;

		case 8:

			palabra = "BIOLOGIA";
			arrayContenido = convertirChar(palabra);

			break;

		case 9:

			palabra = "VOLKSWAGEN";
			arrayContenido = convertirChar(palabra);

			break;

		case 10:

			palabra = "NIEBLA";
			arrayContenido = convertirChar(palabra);

			break;
		}

		return arrayContenido;
	}
	
	private static char[] convertirChar(String palabra) {
		char[] arrayChar = new char[palabra.length()];
		
		for (int i = 0; i < palabra.length(); i++) {
			arrayChar[i]= palabra.charAt(i);
		}
		
		return arrayChar;
	}

}
