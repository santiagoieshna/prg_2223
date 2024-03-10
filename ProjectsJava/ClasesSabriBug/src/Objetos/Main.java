package Objetos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Cuadrado cuadrado= new Cuadrado();
		// new es el operador que contruye la clase
		
		Scanner entrada = new Scanner(System.in);
		
		String nombre ="Jose Antonio";
		String dni ="234234524G";
		String titulo ="Matematicas";
		String especialidad ="Programacion Computacional";
		
		Maestro profeUno = new Maestro(nombre,dni,  titulo, especialidad);
		System.out.println(profeUno.getNombre());
		
		
	}

}
