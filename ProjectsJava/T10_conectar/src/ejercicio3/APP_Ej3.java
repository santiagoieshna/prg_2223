package ejercicio3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import conector.ConectarBD;

public class APP_Ej3 {
	public static void main(String[] args) {
		String url, nombre, pass;
		Properties acceso = new Properties(2);
		Connection con;
		Statement ejecutorSentencia;
		ResultSet respuesta;
		GestionProductos gest;
		url = "jdbc:mysql://localhost:3306/classicmodels";
		nombre = "santiago";
		pass = "123456";
		acceso.put("user", nombre);
		acceso.put("password", pass);
		
		
		try {
			gest=new GestionProductos(ConectarBD.getConexion(url, acceso));
			boolean okey = gest.cargarProductos();
			System.out.println(okey);
			gest.showAllProdcutos();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
