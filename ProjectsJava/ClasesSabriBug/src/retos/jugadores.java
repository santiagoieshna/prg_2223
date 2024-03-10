package retos;

import java.util.Iterator;
import java.util.Scanner;

public class jugadores {

	public static void main(String[] args) {

		String[] jugadores = { "Stephen Curry", "Lebron James", "Damian Lillard", "James Harden", "Devin Booker",
				"Anthony Davis", "Kawhi Leonard", "Luka Doncic", "Kevin Durant", "Giannis Antetokounmpo" };

		String[] temporadas = { "2017/2018", "2018/2019", "2019/2020", "2020/2021" };

		double[][] mediaPuntosTemporada = new double[4][10];

		for (int i = 0; i < mediaPuntosTemporada.length; i++) {
			for (int j = 0; j < mediaPuntosTemporada[i].length; j++) {
				mediaPuntosTemporada[i][j] = Math.random() * 30; // ppp
			}
		}

		Scanner entrada = new Scanner(System.in);

		System.out.print("Introduce el jugador: ");
		String jugador = entrada.nextLine();

		int posicioni = buscador(jugador, jugadores);
		
		if(posicioni != -3) {
			
			
			System.out.print("Introduce la temporada: ");
			String temporada = entrada.nextLine();
			
			int posicionj = buscador(temporada, temporadas);
			
			if(posicionj != -3) {
				
				
				System.out.println(mediaPuntosTemporada[posicioni][posicionj]);
				
			}else {
				
				System.out.println("La temporada no existe");
				
			}
			
			
		} else {
			
			System.out.println("El jugador no existe");
			
		}

		
		
		

	}

	public static int buscador(String dato, String[] array) {

		int posicion = 0;
		for (int i = 0; i < array.length; i++) {

			if (dato.equalsIgnoreCase(array[i])) {

				posicion = i;
				return posicion;

			} else {

				posicion = -3;
			}
		}

		return posicion;

	}
}
