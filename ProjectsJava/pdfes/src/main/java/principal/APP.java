package principal;

import conexion.Conexion;
import controller.GestionProductos;

public class APP {
 public static void main(String[] args) {
	 GestionProductos gest=null;
	try {
		
		gest = new GestionProductos( Conexion.getConexion());
//		gest.getProductoStorage().printProductos();
		gest.selectInventadaJiJiJaJaGallinaTuerta(50f, 150f);
		gest.crearPdf();
	} catch (Exception e) {
		System.out.println("No se pudo cargar los productos");
		e.printStackTrace();
	}
	
	
}
}
