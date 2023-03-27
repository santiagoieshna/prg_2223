package errores;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionCero {

	public static void main(String[] args) {
		
		int numerador;
		int denominador;
		float  division=0;
		
		try {
			Scanner sc  = new  Scanner(System.in);
			System.out.println("numerador");
			numerador = sc.nextInt();
			System.out.println("denominador");
			denominador= sc.nextInt();
			
			division =  numerador / denominador;
			
		}catch ( ArithmeticException e) {
			System.out.println("has divido entre zero");
			System.out.println("ha ocurrido un "+e);
			
		}catch ( InputMismatchException e) {
		System.out.println("has divido entre zero");
		System.out.println("ha ocurrido un "+e);
		
		}
		catch (Exception e) {
		System.out.println("ha ocurrido un "+e.getMessage());
		System.out.println("ha ocurrido un "+e);
		
		}
		finally {
			System.out.println(division);
		}
	}

}
