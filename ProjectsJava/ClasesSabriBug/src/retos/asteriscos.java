package retos;

import java.util.Scanner;

public class asteriscos {
	/*
	 * 	|				**
	 * 	|			   ****
	 *  |			 ********
	 *  |        ****************
	 *  |********************************
	 *  
	 *  |********************************
	 *  |        ****************
	 *  |			 ********
	 *  |			   ****
	 *  |				**
	 */

	public static void main(String[] args) {
		
		int numeroMax = 32;
		int anterior = 0;
//		Scanner sc = new Scanner(System.in);
		
		int asteriscos = 32;
		
		while(asteriscos >= 2) {
			
			for (int j = 0; j < numeroMax; j++) {
				if(j <(anterior/4) || j> (2*numeroMax/4)) {	
					System.out.print(" ");
				}else {
				System.out.print("*");
				}
			}
			
			System.out.println();
			anterior += asteriscos;
			asteriscos /=2;
		}
		
	}
}
