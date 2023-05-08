package ejer6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


import alumno.Alumno;



public class GestionAlumnos {
	private List<Alumno> alumnos;
	
	/**
	 * @param alumnos
	 */
	public GestionAlumnos(List<Alumno> alumnos) {
		super();
		this.alumnos = alumnos;
	}
	
	public GestionAlumnos(String fichero) {
		alumnos = new ArrayList<>();
		cargarAlumnos(fichero);
	}
	
	public Double[] getNotasID(String codigo, ArrayList<Alumno> alumnos) {
		
		return null;
	}
	
	
	public void mostrarNotas(String codigo) {
		Alumno alum= buscarAlumno(codigo);
		System.out.println(alum.notasToString());
	}

	private Alumno buscarAlumno(String codigo) {
		Alumno alum = null;
//		alumnos.forEach(alumno-> {
//			if(alumno.getCodigo().equals(codigo))
//				alum=alumno;
//		});
		for (Alumno alumno : alumnos) {
			if(alumno.getCodigo().equals(codigo))
				alum=alumno;
		}
		return alum;
	}

	private  void cargarAlumnos( String archivo) {
		
		FileReader fr = null;
		BufferedReader lector = null;
		List<String> datosAlumnos = new ArrayList<>();
		try {
			fr = new FileReader(archivo);
			lector = new BufferedReader(fr);
			
			leerFichero(datosAlumnos,lector);//Por referencia
			fr.close();
			lector.close();
			formatearDatos(datosAlumnos);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void formatearDatos( List<String> datosAlumnos) {
		
		datosAlumnos.forEach(dato ->{
			String[] campos = dato.split(";");
			String codigo = campos[0];
			String nombre = campos[1];
			
			Double[] notas= new Double[10];
			String[] notasString = Arrays.copyOfRange(campos, 2, campos.length);
			
			for (int i = 0; i < notasString.length; i++) {
				notas[i]= Double.parseDouble(notasString[i]);
			}
			
			// MANERA DE OBRERO
//			for (int i = 2; i < campos.length; i++) {
//				notas[i-2]=Double.valueOf(campos[i]);
//			}
			this.alumnos.add(new Alumno(codigo, nombre, notas));
		});
		
	}
	
	public void crearArchivoDat( String nombreArchivo) {
		ObjectOutputStream ow =null;
		try {
			ow = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
			
//			alumnos.forEach(alumno->{
//				try {
//					ow.writeObject(alumno);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			});
			for (Alumno alumno : this.alumnos) {
				ow.writeObject(alumno);
			}
			ow.close();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}	
	}

	private void leerFichero(List<String> datos, BufferedReader pw) throws IOException {
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

	public void printAllAlumnos() {
		this.alumnos.forEach(alumno-> System.out.println(alumno.toString()));
	}

	public Alumno getAlumno(StringBuilder codigoAlumno) {
		for (Alumno alumno : alumnos) {
			if(alumno.getCodigo().equals(codigoAlumno.toString()))
				return alumno;
		}
		return null;
	}

	public void imprimirAlumnos() {
		System.out.println("  Codigo\t\tNombre\t\tNota Media");
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.getCodigo()+" - "+alumno.getNombre()+" - "+alumno.getNotaMedia());
		}
		
	}
	

}
