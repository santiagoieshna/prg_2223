package escribirDespues;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Ejer5 {
	public static void main(String[] args) {
		String archivo = "frase.txt";
		List<String> cadenas = new ArrayList<>();
		FileWriter fw =null;
		PrintWriter pw = null;
		cadenas.add("Dios le da pan al que le faltan dientes.");
		cadenas.add("Con paciencia y con saliba el elefante se la metio a la hormiga.");
		
		try {
			//constructor con true como segundo parametro
			fw = new FileWriter(archivo, true);
			pw = new PrintWriter(new BufferedWriter(fw));
			for (String frase : cadenas) {
				pw.println(frase);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// No entra en este dominio
//		cadenas.forEach(frase -> pw.println(frase));
		
		
		
	}
	
	
}
