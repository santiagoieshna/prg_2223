package ejer6;

import java.util.ArrayList;
import java.util.List;

import alumno.Alumno;

public class APP {
public static void main(String[] args) {
		
		List<Alumno> alumnos = new ArrayList<>();
		GestionAlumnos.cargarAlumnos(alumnos);
		alumnos.forEach(alumno-> System.out.println(alumno.toString()));
//		GestionAlumnos.crearDat(alumnos);
		
		
	}
}
