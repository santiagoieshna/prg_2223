package conexion_bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import envglobales.MyProperties;

public class ConectarBD {
	private static Connection conexion=null;
	
	public static Connection getConexion() {
		if(conexion==null) {
			try {
				conexion = DriverManager.getConnection(MyProperties.FINAL_URL, MyProperties.FINAL_ACCESO);
				System.out.println("Base de datos conectada");
			} catch (SQLException e) {
				System.err.println("No se pudo conectar la Base de Datos");
			
			}
		}
		return conexion;
	}
}
