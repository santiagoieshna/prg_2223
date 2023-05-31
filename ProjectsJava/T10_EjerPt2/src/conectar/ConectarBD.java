package conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConectarBD {
	static private Connection conexion;
//	private Properties acceso;
	
	public static Connection getConexion(String baseDatos, Properties acceso) throws SQLException {
		if(conexion==null) {
			String url= "jdbc:mysql://localhost"+baseDatos;
			conexion= DriverManager.getConnection(url,acceso);
		}
		return conexion;
	}
	public static Connection getConexion( String url ,String user, String password) throws SQLException {
		if(conexion==null) {
			conexion= DriverManager.getConnection(url,user, password);
		}
		return conexion;
	}
}
