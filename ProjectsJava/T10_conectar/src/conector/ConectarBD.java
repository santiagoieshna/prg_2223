package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class ConectarBD {

		private static Connection con = null;
		
		public static Connection getConexion() throws SQLException {
			if (con == null) {
			con =
			DriverManager.getConnection("jdbc:mysql://localhost/classicmodels",
			"santiago", "123456");
			}
			return con;
		}
		
		public static Connection getConexion(String user, String pass, String url) throws SQLException {
			if (con == null) {
				con =
						DriverManager.getConnection(url,
								user, pass);
			}
			return con;
		}
		
		public static Connection getConexion(String url, Properties propertie) throws SQLException {
			if (con == null) {
				con =
						DriverManager.getConnection(url,
								propertie);
			}
			return con;
		}
		
		
		
	

}


