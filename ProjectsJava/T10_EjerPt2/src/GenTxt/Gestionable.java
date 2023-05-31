package GenTxt;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public interface Gestionable {
	
	public boolean getAllProductos() ;
	public BufferedWriter openFile(String fileName) throws IOException ;
	public boolean writeFile(String[] productosFormateados);
	public ArrayList<String> readFile(String Filename)  throws IOException;
	public void printLines(ArrayList<String> fichero);
	
}