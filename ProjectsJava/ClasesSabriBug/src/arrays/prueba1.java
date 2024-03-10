package arrays;

import java.util.Scanner;

public class prueba1 {
	public static void main(String[] args) {
		String a = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un numero:");
		
		a = sc.next();
		for (int i = 0; i < a.length(); i++) {
			System.out.println(a.charAt(i));
		}
		
		
		
//		int num= sc.nextInt();
//		int longitud;
//		
//		while(num != 0) {
//			//Averiguar la longitud del numero
//			a= ""+num; 
//			longitud= (int) Math.pow(10, a.length())/10;
//			
//			int numeroAux = num /longitud;
//			
//			num = num - numeroAux* longitud;
//			System.out.println(numeroAux);
//		}
	}
	
	
	
	
}
