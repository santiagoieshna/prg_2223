package Ejercicio_5_6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class GestionAlumnoTest {

	@Test
	void testGetRandomAlumno() {
		
		GestionAlumno gestor = new GestionAlumno();
		
		int numExpediente = 4;
		Alumno alumno = gestor.getRandomAlumno(numExpediente);
		String ExpedienteExpected = String.valueOf(numExpediente); 
		
		assertTrue(alumno != null); // que hay "algo" 
		assertEquals(alumno.getNumeroExpediente(), ExpedienteExpected);
		assertTrue(alumno.getNotas1()>0);
		assertTrue(alumno.getNotas2()>0);
//		System.out.println(alumno.toString());
	}
	
	@Test
	void testLlenarArray() {
		GestionAlumno Aula = new GestionAlumno();
		
		Alumno[] alumnosVacio = Aula.getAlumnos();
		
		for (int i = 0; i < alumnosVacio.length; i++) {
			assertFalse(alumnosVacio[i]!=null); // Tiene que dar falso
		}
		
		Aula.llenarArray(); // Aqui se llenaria el array
	
		Alumno[] alumnos = Aula.getAlumnos();
		
		for (int i = 0; i < alumnos.length; i++) {
			assertTrue(alumnos[i]!=null);
		}
	}
	@Test
	void testFindByExpediente() {
		GestionAlumno aula = new GestionAlumno();
		aula.llenarArray();
		
		String expedienteExpected = "19";
		
		Alumno alumno = aula.getAlumnoByExpediente(expedienteExpected);
		
		assertTrue(alumno != null);
		assertEquals(alumno.getNumeroExpediente(), expedienteExpected);
		
	}
	
	

}
