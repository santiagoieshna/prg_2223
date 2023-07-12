package arrays;
public class salir_break {
public static void main(String[] args) {

	System.out.println("Empezamos...");
	for(int i = 1; i <= 10; i++) {
		System.out.println("Vuelta: " + i);
		salir:
		if(i==8) {
			
			break salir;
		}
		
		System.out.println("Vuelta terminada " + i);
		
		}
	System.out.println("Terminado");
	
	
	
	
	
	
	
	
	

	}

}
