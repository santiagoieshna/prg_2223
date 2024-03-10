package Ejercicio_5_6;

import java.time.LocalDate;
import java.util.Random;

public class GestionAlumno {

	private Alumno[] alumnos;

	public GestionAlumno() {
		this.alumnos =  new Alumno[25];
	}
	
	public void showNotaMedia() {
		for (int i = 0; i < alumnos.length; i++) {
			System.out.print(alumnos[i].getNombre() + " "+ alumnos[i].getApellido()+", ");
			System.out.println("Nota Media: "+alumnos[i].getNotaMedia());
		}
	}
	
	public Alumno getAlumnoByExpediente(String expediente) {
		for (int i = 0; i < alumnos.length; i++) {
			if(alumnos[i].getNumeroExpediente().equals(expediente)) {
				return alumnos[i];
			}
		}
		return null;
	}
	
	public void llenarArray() {
		for (int i = 0; i < alumnos.length; i++) {
			alumnos[i] = getRandomAlumno(i+1);
		}	
	}

	// Object Mother -> AlumnoObjectMother o AlumnoOM
	public Alumno getRandomAlumno(int numExpediente) {
		
		String numeroExpediente = String.valueOf(numExpediente);
		
		String[] nombres = {"Ratona","Sabrina", "Samara", "Samantha", "Lira", "Dickson","Carolina"};
		String[] apellidos = {"Peralta", "Cristobal", "Vasquez", "Egipto"};
		
		LocalDate fecha = genFechaRandom();
		
		String[] cursos = {"1 DAM", "2 DAM", "3 DAM", "Contabilidad", "ADE"};
		
		int nota1 = new Random().nextInt(10)+1;
		int nota2 = new Random().nextInt(10)+1;

		String nombre = nombres[ genRandom(nombres.length) ];
		String apellido = apellidos[genRandom(apellidos.length)];
		String curso = cursos[genRandom(cursos.length)];
		
		return new Alumno(numeroExpediente, nombre, apellido, fecha, curso, nota1, nota2);
	}

	/**
	 * Retona numero random segun el maximo.
	 * @param maximo es exclusivo
	 * @return
	 */
	public int genRandom(int maximo) {
		return new Random().nextInt(maximo);
	}


	private LocalDate genFechaRandom() {
		
		int mes = new Random().nextInt(12)+1;
		int dia;
		int year = new Random().nextInt(25)+1990;
		if(mes == 2) {
			dia = new Random().nextInt(28)+1;
		}else {
			dia = new Random().nextInt(30)+1;
		}
	
		return LocalDate.of(year, mes, dia);
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}
	
 	
	
	
}
