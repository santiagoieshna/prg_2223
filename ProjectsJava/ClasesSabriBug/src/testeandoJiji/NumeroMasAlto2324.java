package testeandoJiji;

import java.util.Random;
import java.util.Scanner;

public class NumeroMasAlto2324 {

	public static void main(String[] args) {

		int minimoValorPosible = 1;
		int maximoValorPosible = 101;
		
		int secreto = generarAleatorio(minimoValorPosible, maximoValorPosible);
		
		int maximoFallosPermitidos = 5;
		int fallosCometidos = 0;
		int comparacion;
		boolean fallosMaximosAlcanzados = false;
		
		do {
			int valor = pedirNumero();
			
			comparacion = compararValores(valor, secreto);
			
			if (comparacion != 0) {
				
				fallosCometidos = incrementarFallos(fallosCometidos);
				
				fallosMaximosAlcanzados = comprobarLimiteFallos(fallosCometidos, maximoFallosPermitidos);
				
			}
			
		} while (comparacion != 0 && !fallosMaximosAlcanzados);
		
		if (comparacion == 0) {
			
			felicitar();
			
		} else {
			
			lamentar();
		}
	}

	/**
	 * Comunica al jugador que lamenta que haya perdido
	 */
	public static void lamentar() {
		
		System.out.println("Has fallado hdp... has desonrado a tu padre");

	}

	/**
	 * comunica al jugador que le felicita por ganar
	 */
	public static void felicitar() {
		
		System.out.println("Lo has hecho bien but mejora puto");

	}

	/**
	 * Comprueba se se han alcanzado los maximos fallos permitidos
	 * 
	 * @param fallos                 los fallos que ha cometido actualmente
	 * @param maximoFallosPermitidos la cantidad maxima de fallos permitida
	 * @return true si la cantidad de fallos es menor que el maximoFallosPermitidos
	 *         y false en caso contrario
	 */
	public static boolean comprobarLimiteFallos(int fallos, int maximoFallosPermitidos) {
		// TODO Auto-generated method stub
		
		return false;
	}

	/**
	 * Incrementa en una unidad la cantidad de fallos actual
	 * 
	 * @param fallos cantidad de fallos , numero entero positivo
	 * @return nueva cantidad de fallos, fallos anteriores mas una unidad
	 * 			si se introduce un numero entero negativo devolvera -1
	 */
	public static int incrementarFallos(int fallos) {
	
		// 1 - No veo logica
		// 2 - Me da igual lo que haya aqui
		
		if( fallos < 0) {
			return -1;
		}
		
		return fallos+1;
	}

	/**
	 * Compara la diferencia entre valor y secreto
	 * 
	 * @param valor   primer numero a comparar
	 * @param secreto segundo numero a comparar
	 * @return 0 si son iguales, una cantidad positiva si valor>secreto o una
	 *         cantidad negativa si secreto>valor
	 */
	
	public static int compararValores(int valor, int secreto) {
		
		int valorPositivo = 3;
		
		if(valor > secreto) {
			
			return valorPositivo;
			
		}else if(valor < secreto) {
			
			return valorPositivo * (-1);
				
		}else {
			
			return valorPositivo - valorPositivo;
		}
	}

	/**
	 * genera un numero aleatorio
	 * 
	 * @param min el numero mas bajo que puede salir
	 * @param max el mayor numero que puede salir
	 * @return un numero aleatorio entre min y max, max>=retorno>=min
	 */
	public static int generarAleatorio(int min, int max) {
		// TODO
		Random random = new Random();
		return random.nextInt(min, max);

	}

	/**
	 * Solicita al jugador un valor
	 * 
	 * @return el valor entero solicitado al jugador
	 */
	public static int pedirNumero() {
		
		Scanner entrada = new Scanner(System.in);
		int numero = 0;
		
		System.out.println("Introduce un numero: ");
		numero = entrada.nextInt();
		
		return numero;

	}

}
