package retos;

public class metodoBurbuja {

	public static void main(String[] args) {
		
		
		int [] array = {5,6,2,1,8,9,3};	
		int mayor = 0;
		
		for (int i = 1; i < array.length; i++) {
			
			for (int j = 0; j < array.length-1; j++) {
				
				
				if(array[j] > array[j+1]) {
					
					mayor = array[j];
					array[j] = array[j+1];
					array[j+1] = mayor;
					
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
