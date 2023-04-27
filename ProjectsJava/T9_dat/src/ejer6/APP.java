package ejer6;

import java.util.ArrayList;
import java.util.List;


public class APP {
public static void main(String[] args) {
		String archivoTxt = "res/Datos_Alumnos.txt";
		String archivoDat = "res/Alumnos.dat";
		GestionAlumnos gest = new GestionAlumnos(archivoTxt);
		gest.printAllAlumnos();
//		GestionAlumnos.crearDat(alumnos);
		gest.crearArchivoDat( archivoDat);
		
		
	}
}
