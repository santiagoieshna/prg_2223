package FOR_ANIDADOS;
public class _250numeros_primos {
public static void main(String[] args) {

		int contador250 = 0;
		int numero_a_Estudiar = 1;
		int contador = 0;
		while (contador250 <= 250) {

			contador = 0;

			for (int divisor = 1; divisor <= numero_a_Estudiar; divisor++) {

				if (numero_a_Estudiar % divisor == 0) {

					contador++;
				}
			}

			if (contador == 2) {

				contador250++;
				System.out.println(numero_a_Estudiar);
			}
			numero_a_Estudiar++;
		}
	}
}
