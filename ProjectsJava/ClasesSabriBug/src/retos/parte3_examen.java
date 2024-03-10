package retos;

public class parte3_examen {

	public static void main(String[] args) {
	
		
		int paga=0;
		int dineroAhorrado=0;
		int dia= 0;
		int paga1Dia=0;
		int paga2Dias=0;
		int objetivoParaAhorrar=0;
		
		objetivoParaAhorrar = 10; // Centimos
		
		// ------------ DIA 1 ---------
		
		dia = 1;
		
		paga = 1;
		
		dineroAhorrado = dineroAhorrado + paga;
		
		paga1Dia = paga ;
		
		// ----------- DIA 2 -----------
		
		dia = 2;
		
		paga = 1;
		
		dineroAhorrado = dineroAhorrado + paga;
		
		paga2Dias = paga1Dia;
		
		paga1Dia = paga;
		
		// ----------- DIA 3 ----------
		
		
		dia ++;
		
		paga = paga2Dias*2 + paga1Dia; 
		
		dineroAhorrado = dineroAhorrado + paga;
		
		paga2Dias = paga1Dia;
		
		paga1Dia = paga;
		
		
		// ----------------------------------
		
		// Llegue a mi Goal 
		
		System.out.println("Dia: "+dia);
		System.out.println("Ahorro: "+dineroAhorrado);
		
	}

}
