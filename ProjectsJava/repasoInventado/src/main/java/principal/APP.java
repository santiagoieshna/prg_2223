package principal;

import java.io.IOException;

import controller.GestionClientes;

public class APP {
	public static void main(String[] args) {
		GestionClientes gest = new GestionClientes();
//		gest.pdfByCiudad("Madrid");
		try {
			gest.saveClienteDat();
			gest.loadClienteDat();
			gest.mostrarDat();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
