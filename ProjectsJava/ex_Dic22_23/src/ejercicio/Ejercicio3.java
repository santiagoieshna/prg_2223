package ejercicio;

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		// Codigo de examen
		String[] jugadores = { "Stephen Curry", "Lebron James", "Damian Lillard", "James Harden", "Devin Booker",
                "Anthony Davis", "Kawhi Leonard", "Luka Doncic", "Kevin Durant", "Giannis Antetokounmpo" };
		
		String[] temporadas = { "2017/2018", "2018/2019", "2019/2020", "2020/2021" };
		
        double[][] mediaPuntosTemporada = new double[4][10];
        

        for (int i = 0; i < mediaPuntosTemporada.length; i++) {
            for (int j = 0; j < mediaPuntosTemporada[i].length; j++) {
                mediaPuntosTemporada[i][j] = Math.random() * 30; // ppp
            }
        }
        // --- Codigo de examen-----
        
        Scanner entrada = new Scanner(System.in);
        String nombre;
        String temporada;
        int posicionTemporada;
        int posicionJugador;
        //1) ptos de un jugador en una temporada
        System.out.println("introduce nombre jugador: ");
        nombre = entrada.nextLine();
        posicionJugador = findJugador(nombre, jugadores);
        
        
        // Verificar si existe jugador
        if( posicionJugador != -1) {	
        	System.out.println("introduce una temporada: ");
        	temporada = entrada.nextLine();
        	posicionTemporada = findTemporada(temporada, temporadas);
        	
        	// Verifficar si existe temporada
        	if( posicionTemporada != -1) {
        		System.out.println( mediaPuntosTemporada[posicionTemporada][posicionJugador]);
        	}else {
        	
        		System.out.println("No existe la temporada");
        	}
        }else {
        	System.out.println("No existe el jugador");
        }
        
        // Media ptos temporada
        System.out.println("Calcular media, inserte temporada: ");
        temporada = entrada.nextLine();
        posicionTemporada= findTemporada(temporada, temporadas);
        float media;
        if(posicionTemporada != -1) {
        	media = calcularMedia(posicionTemporada, mediaPuntosTemporada);
        	System.out.println("media: "+media);
        }
        
        
	}

	private static float calcularMedia(int posicionTemporada, double[][] mediaPuntosTemporada) {
		float sum=0;
		for (int i = 0; i < mediaPuntosTemporada[0].length; i++) {
			
			sum += mediaPuntosTemporada[posicionTemporada][i];
		}
		return sum/mediaPuntosTemporada[0].length;
	}

	/**
	 * Metodo que devuelve la poscion de temporadas si existe el String insertado
	 * @param temporada
	 * @param temporadas
	 * @return
	 */
	private static int findTemporada(String temporada, String[] temporadas) {
		
		for (int i = 0; i < temporadas.length; i++) {
			if(temporadas[i].equals(temporada)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Metodo que devuelve la poscion de jugadores si existe el String insertado
	 * @param nombre
	 * @param jugadores
	 * @return
	 */
	private static int findJugador(String nombre, String[] jugadores) {
		
		for (int i = 0; i < jugadores.length; i++) {
			
			if(jugadores[i].equals(nombre)) {
				return i;
			}
		}
		
		return -1;
	}
	
	
}
