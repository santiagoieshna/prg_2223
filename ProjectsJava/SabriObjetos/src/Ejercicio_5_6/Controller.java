package Ejercicio_5_6;

public class Controller {
	
	
	
	
	
	public static void main(String[] args) {
		GestionAlumno gestor = new GestionAlumno();
		gestor.llenarArray();
		
//		gestor.showNotaMedia();
		
		 Alumno alumno = gestor.getAlumnoByExpediente("19");
		
		System.out.println(alumno.toString());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void getNumAlumnos(Alumno[] alumnos) {
		int contador= 0;
		for (int i = 0; i < alumnos.length; i++) {
			if(alumnos[i]!=null) {
				contador++;
			}
//			System.out.println(alumnos[i].toString()+"\n");
		}
		System.out.println(contador);
	}
	
}
