package pruebas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int opcion = 0;
		boolean salida = false;
		String preguntar = "1) Añadir un numero\n2) Eliminar un numero\n3) Sustituir un numero"
				+ "\n4) Mostrar tamaño\n5) Mostrar true si esta vacio\n6) Vaciar lista\n7) Comprueba si"
				+ " un elemento esta en la lista\n8)Ver arraylist \n9) Salir";
		ArrayList<Integer> intList = new ArrayList<Integer>();

		do {

			System.out.println(preguntar);
			opcion = entrada.nextInt();
			
			switch (opcion) {
			
			case 1: {
				// Añadir numero
				System.out.print("Introduce el numero: ");
				Integer numeroAdd = entrada.nextInt();
				intList.add(numeroAdd);
				break;
			}
			case 2: {
				// Borrar numero
				System.out.print("¿Que posicion quieres borrar? ");
				int pos = entrada.nextInt();
				intList.remove(pos);
				break;
			}
			case 3: {
				// sustituir uno por otro
				System.out.println("Introduce posicion que quieres y el numero que quieres añadir");
				int posq = entrada.nextInt();
				int annadir = entrada.nextInt();
				intList.set(posq, annadir);
				break;
			}
			case 4: {
				// mostrar tamanio array
				int tamanyo = intList.size();
				System.out.println(tamanyo + " tamaño ");
				break;
			}
			case 5: {
				// mostrar true si esta vacio
				boolean estaVacio = intList.isEmpty();
				System.out.println(estaVacio);
				break;
			}
			case 6: {
				// vaciar la lista
				intList.clear();
				break;
			}
			case 7: {
				// buscar un elemento en la lista
				System.out.print("Inserte el elemento a buscar");
				int buscar = entrada.nextInt();
				
				if(intList.contains(buscar)) {
					int position = intList.indexOf(intList);
					System.out.println("El elemento "+buscar+" Esta en la posicion "+position);
				}else {
					System.out.println("El elemento "+buscar+" no se enceuntra en la lista");
				}
				break;
			}
			case 8: {
				intList.trimToSize();
				for (Integer integer : intList) {
					System.out.print(integer+" ");
				}
				
			}
			case 9: {
				System.out.println("Hasta pronto");
				salida = true;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}

		} while (!salida);

	}
}
