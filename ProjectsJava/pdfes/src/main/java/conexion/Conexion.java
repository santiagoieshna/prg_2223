package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import glbalENV.MyProperties;
public class Conexion {
	private static Connection con=null;
	public static Connection getConexion() {
		if(con == null) {
			try {
				con = DriverManager.getConnection(MyProperties.FINAL_URL, MyProperties.FINAL_ACCESO);
				System.out.println("BD conectada");
				
			} catch (SQLException e) {
				
				System.out.println("No se pudo conectar a la BD");
				e.printStackTrace();
			}
			
		}
		return con;
	}
}
