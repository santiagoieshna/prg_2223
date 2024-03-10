package retos;

public class metodoporindersacion {

	public static void main(String[] args) {

		int[] array = { 5, 4, 389, 564, 21 };
		int aux = 0;

		for (int i = 0; i < array.length; i++) {

			for (int j = i + 1; j < array.length; j++) {

				if (array[i] < array[j]) {

					aux = array[i];
					array[i] = array[j];
					array[j] = aux;

				}
			}
		}
		
		printArray(array);

	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print("[" + array[i] + "]");
		}
	}
}
