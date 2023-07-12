package principal;

import modelo.Empleado;
import modelo.GestionEmpleados;

public class App {

	public static void main(String[] args) {
		GestionEmpleados gest = new GestionEmpleados();
//		int opcion=0;
//		boolean salida = true;
//		String menu = "1- AddEmpleado\n2- GetEmpleado";
		
		gest.addEmpleado(new Empleado("Jaime", "Ingles","Jaime@gmail.com"));
		gest.addEmpleado(new Empleado("Lorena", "Ingles","Lorena@gmail.com"));
		gest.addEmpleado(new Empleado("Juan", "Ingles","Juan@gmail.com"));
		gest.addEmpleado(new Empleado("Jose", "Frances"));
		gest.addEmpleado(new Empleado("Jaime", "Frances"));
		gest.addEmpleado(new Empleado("Mario", "Indio"));
		//Devolvera True
		System.out.println(gest.addEmpleado(new Empleado("Mario", "Ingles")));
		
		
		// Obetener empleado
		// Recordar que el ID se autoincrementa, empezando desde 1.
		Empleado emp1 =gest.getEmpleado(1);
		System.out.println(emp1.toString());
		
		//Empleado 1
		gest.addTrabajo( "Auxiliar",1);
		gest.addTrabajo( "Enfermero",1);
		gest.addTrabajo( "Tecnico",1);
		gest.addTrabajo( "Conserje",1);
		gest.addTrabajo( "Bombero",1);
		gest.addTrabajo( "Auxiliar",1); //No contara, porque es un Set el atributo trabajo
		System.out.println(emp1.toString());
		//Empleado 2
		gest.addTrabajo( "Auxiliar",2);
		gest.addTrabajo( "Administrativo",2);
		gest.addTrabajo( "Tecnico",2);
		gest.addTrabajo( "Conserje",2);
		gest.addTrabajo( "Presidente",2);
		//Empleado 3
		gest.addTrabajo( "Auxiliar",3);
		gest.addTrabajo( "Carpintero",3);
		gest.addTrabajo( "Tecnico",3);
		gest.addTrabajo( "rapero",3);
		gest.addTrabajo( "Bombero",3);
		
		
		System.out.println("Auxiliar: "+gest.getNumeroEmpleados("auxiliar"));
		System.out.println("Carpintero: "+gest.getNumeroEmpleados("carpintero"));
		System.out.println("Conserje: "+gest.getNumeroEmpleados("conserje"));

		
		System.out.println(gest.getMapaIdioma());
		


	}
}
