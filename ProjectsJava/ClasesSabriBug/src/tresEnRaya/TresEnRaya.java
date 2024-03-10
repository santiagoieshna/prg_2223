package tresEnRaya;

import java.util.Scanner;

public class TresEnRaya {

	public static void main(String[] args) {
		int turnoJugador = 1;
		int turnoNumero = 0;
		char[][] matriz = new char[3][3];

		matriz = llenarMatriz();

		boolean finPartida = false;
		boolean hayGanador = false;

		Scanner entrada = new Scanner(System.in);
		int fila = 0;
		int columna = 0;

		imrpimirTablero(matriz);

		// ! para dar lo contrario
		while (!finPartida && !hayGanador) {

			System.out.println("Jugador actual: " + turnoJugador);
			do {

				System.out.println("Inserte valores entre el 1 y el 3:");
				System.out.println("¿Que fila?");
				fila = entrada.nextInt();
				System.out.println("¿Que columna?");
				columna = entrada.nextInt();
				if (fila < 1 || fila > 3 || columna < 1 || columna > 3) {
					System.out.println("Valores incorrectos, intentelo de nuevo");
				}
			} while (fila < 1 || fila > 3 || columna < 1 || columna > 3);
			// Para ajustarlo con el ejemplo del enunciado, me tenia confundida.
			fila = fila - 1;
			columna = columna - 1;

			if (casillaLibre(matriz, fila, columna)) {
				matriz[fila][columna] = ponerFicha(turnoJugador);

				if (turnoJugador == 1) {

					if (matriz[0][0] == 'X' && matriz[0][1] == 'X' && matriz[0][2] == 'X') { // Fila 1
						hayGanador = true;
					} else if (matriz[1][0] == 'X' && matriz[1][1] == 'X' && matriz[1][2] == 'X') { // Fila 2
						hayGanador = true;
					} else if (matriz[2][0] == 'X' && matriz[2][1] == 'X' && matriz[2][2] == 'X') { // Fila 3
						hayGanador = true;
					} else if (matriz[0][0] == 'X' && matriz[1][0] == 'X' && matriz[2][0] == 'X') { // Columna 1
						hayGanador = true;
					} else if (matriz[0][1] == 'X' && matriz[1][1] == 'X' && matriz[2][1] == 'X') { // Columna 2
						hayGanador = true;
					} else if (matriz[0][2] == 'X' && matriz[1][2] == 'X' && matriz[2][2] == 'X') { // Columna 3
						hayGanador = true;
					} else if (matriz[0][0] == 'X' && matriz[1][1] == 'X' && matriz[2][2] == 'X') { // Diagonal
						hayGanador = true;
					}
				} else {
					if (matriz[0][0] == 'O' && matriz[0][1] == 'O' && matriz[0][2] == 'O') { // Fila 1
						hayGanador = true;
					} else if (matriz[1][0] == 'O' && matriz[1][1] == 'O' && matriz[1][2] == 'O') { // Fila 2
						hayGanador = true;
					} else if (matriz[2][0] == 'O' && matriz[2][1] == 'O' && matriz[2][2] == 'O') { // Fila 3
						hayGanador = true;
					} else if (matriz[0][0] == 'O' && matriz[1][0] == 'O' && matriz[2][0] == 'O') { // Columna 1
						hayGanador = true;
					} else if (matriz[0][1] == 'O' && matriz[1][1] == 'O' && matriz[2][1] == 'O') { // Columna 2
						hayGanador = true;
					} else if (matriz[0][2] == 'O' && matriz[1][2] == 'O' && matriz[2][2] == 'O') { // Columna 3
						hayGanador = true;
					} else if (matriz[0][0] == 'O' && matriz[1][1] == 'O' && matriz[2][2] == 'O') { // Diagonal
						hayGanador = true;
					}
				}

				if (!hayGanador) {
					turnoJugador = cambioDeTurno(turnoJugador);
					turnoNumero++;
					if (turnoNumero == 9) { // 9 es el numero de casillas totales
						finPartida = true;
					}
				}

			} else {
				System.out.println("");
				System.out.println("Casilla ocupada, intentelo de nuevo");
			}
			imrpimirTablero(matriz);
		}

		if (hayGanador) {

			System.out.println("Jugador " + turnoJugador + " gana!");
		} else {
			System.out.println("No hubo ganador");
		}

	}

	private static char ponerFicha(int turnoJugador) {
		if (turnoJugador == 1) {
			return 'X';
		}
		return 'O';
	}

	private static void imrpimirTablero(char[][] matriz) {
		System.out.println(" _ _ _"); // techo
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("|");
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + "|");
			}
			System.out.println(); // Salto de linea para la siguiente fila
		}
	}

	private static int cambioDeTurno(int turnoJugador) {
		if (turnoJugador == 1) {
			return 2;
		}
		return 1;
	}

	private static char[][] llenarMatriz() {
		char[][] matriz = new char[3][3];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = '_';
			}
		}
		return matriz;
	}

	private static boolean casillaLibre(char[][] matriz, int fila, int columna) {
		if (matriz[fila][columna] == '_') {
			return true;
		}
		return false;
	}

}
