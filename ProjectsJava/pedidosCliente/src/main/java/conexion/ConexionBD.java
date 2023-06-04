package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	private static Connection conexion=null;
	private static final String url = "jdbc:mysql://localhost:3306/classicmodels";
	private static final String user = "santiago";
	private static final String password = "123456";
	
	public static Connection getConexion() {
		
		if(conexion == null) {
			try {
				conexion = DriverManager.getConnection(url,user,password);
				
			} catch (SQLException e) {
				
				System.err.println("Problemas al conectar con la BD");
			}
		}
		
		return conexion;
	}
	
	public static void closeConexion() throws SQLException {
		conexion.close();
	}
}
