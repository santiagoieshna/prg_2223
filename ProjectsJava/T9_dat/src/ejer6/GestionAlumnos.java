package ejer6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import alumno.Alumno;



public class GestionAlumnos {
//	private List<Alumno> alumnos;
	
	public static Double[] getNotasID(String codigo, ArrayList<Alumno> alumnos) {
		
		return null;
	}
	
	public static void crearDat(List<Alumno> alumnos) {
		
		
	}

	public static void cargarAlumnos(List<Alumno> alumnos) {
		String archivo = "res/Datos_Alumnos.txt";
		FileReader fr = null;
		BufferedReader lector = null;
		List<String> datosAlumnos = new ArrayList<>();
		try {
			fr = new FileReader(archivo);
			lector = new BufferedReader(fr);
			
			leerFichero(datosAlumnos,lector);//Por referencia
			fr.close();
			lector.close();
			formatearDatos(alumnos,datosAlumnos);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void formatearDatos(List<Alumno> alumnos, List<String> datosAlumnos) {
		
		datosAlumnos.forEach(dato ->{
			String[] campos = dato.split(";");
			String codigo = campos[0];
			String nombre = campos[1];
			Double[] notas= new Double[10];
			for (int i = 2; i < campos.length; i++) {
				notas[i-2]=Double.valueOf(campos[i]);
			}
			alumnos.add(new Alumno(codigo, nombre, notas));
		});
		
	}

	private static void leerFichero(List<String> datos, BufferedReader pw) throws IOException {
		String linea;
//		datos.forEach(dato -> {
//			try {
//				pw.readLine();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
		while((linea=pw.readLine())!=null) {
			datos.add(linea);
		}
	}

}
