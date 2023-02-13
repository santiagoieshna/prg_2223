package alumno;

import java.util.Scanner;

public class mainalumno {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		alumno estudiante = new alumno("Sabrina","Peralta", 18);
		
		System.out.println("Hola me llamo "+estudiante.getNombre()+" "+estudiante.getApellido());
		System.out.println("Y tengo "+estudiante.getEdad());
		
		alumno estudiante2 = new alumno("Santi","Miguez",28);
		System.out.println("Hola me llamo "+estudiante2.getNombre()+" "+estudiante2.getApellido());
		System.out.println("Y tengo "+estudiante2.getEdad());
	}

}
