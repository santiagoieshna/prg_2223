package ejer6;

import java.util.Scanner;
import alumno.Alumno;

public class APP {
	public static void main(String[] args) {
		
		String archivoTxt = "res/Datos_Alumnos.txt";
		String archivoDat = "res/Alumnos.dat";
		GestionAlumnos gest = new GestionAlumnos(archivoTxt);
		int opcion = 0;
		Scanner consola = new Scanner(System.in);
		StringBuilder codigoAlumno = new StringBuilder();
		Alumno alumno;
//		gest.printAllAlumnos();
//		GestionAlumnos.crearDat(alumnos);

		do {
			menuEnunciado();
			opcion=consola.nextInt();
			codigoAlumno.setLength(0); // Borramos StringBuilder
			alumno = null; //Borramos alumno

			switch (opcion) {
			case 1: {
//				insertCodigo( codigoAlumno);
//				System.out.println(gest.getAlumno(codigoAlumno).notasToString());
				codigoAlumno.append("9457570");
				alumno = buscarAlumno(gest, codigoAlumno);
				System.out.println(alumno.notasToString());
				break;
			}
			case 2: {
				insertCodigo( codigoAlumno);
				alumno = buscarAlumno(gest, codigoAlumno);
				System.out.println(alumno.getNotaMedia());
				break;
			}
			case 3: {
				insertCodigo( codigoAlumno);
				alumno = buscarAlumno(gest, codigoAlumno);
				System.out.println(alumno.notaMasAlta());
				break;
			}
			case 4: {
				gest.imprimirAlumnos();
				break;
			}
			case 5: {
				gest.crearArchivoDat(archivoDat);
				break;
			}case 6: {
				System.out.println();
				System.out.println("Saliendo del sistema..");
				break;
			}
			default:
				System.out.println(" Te equivocastes");
			}
			System.out.println();

		} while (opcion != 6);

	}

	private static Alumno buscarAlumno(GestionAlumnos gest, StringBuilder codigoAlumno) {
		Alumno alumno=null;
		try {
		alumno = gest.getAlumno(codigoAlumno);
		}catch (NullPointerException e) {
			System.out.println("El alumno no existe");
		}catch (Exception e) {
			System.out.println("Ha ocurrido otro problema inesperado");
		}
		return alumno;
	}

	private static void insertCodigo(StringBuilder codigoAlumno) {
		Scanner consola = new Scanner(System.in);
		System.out.println("Introduzca el codigo del alumno");
		codigoAlumno.append(consola.nextLine());
		System.out.println();
	}

	private static void menuEnunciado() {
		StringBuilder enunciado = new StringBuilder();
		enunciado.append("Elija una Opcion:\n");
		enunciado.append("1) Obtener notas de un alumno mediante codigo\n");
		enunciado.append("2) Obtener nota media de un alumno mediante codigo\n");
		enunciado.append("3) Obtener la mejor nota de un alumno mediante su codigo\n");
		enunciado.append("4) Mostar todos los alumnos y sus notas medias\n");
		enunciado.append("5) Guardar Alumnos en un fichero .dat\n");
		enunciado.append("6) Salir\n");
		System.out.println(enunciado);

	}

}
