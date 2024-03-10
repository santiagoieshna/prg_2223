package solucionesSanti;

import java.util.Scanner;

public class Descuentos {

	public static void main(String[] args) {
		
		double monto;
		double montofinal;
		double descuento=0;
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Introduce el monto: ");
		monto = entrada.nextDouble();
		
		if(monto < 500) {
			descuento = 0;
			
		}else {
			
			if( monto>= 500 && monto<=1000) {
				descuento = 0.05;
				
			}else {
				if(monto>1000 && monto<=7000) {
					descuento=0.11;
				}else {
					if(monto>7000 && monto<=15000) {
						descuento=0.18;
					}else {
						descuento=0.25;
					}
				}
			}
			
			
		}
		
		montofinal = monto - (monto*descuento);
		System.out.println("El monto final es de: "+ montofinal+" €");
		System.out.println("Con un desceunto de: "+ descuento*monto+" €");
		
	}
	
	
	
	
}
