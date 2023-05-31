package GenTxt;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import conectar.ConectarBD;

public class App {

	public static void main(String[] args) {
		/**
		 * Dise�a una aplicaci�n Java que genere un archivo de texto con los productos
		 * de una categor�a concreta de la base de datos �classicModels�. Cada registro
		 * de la tabla debe corresponderse con una l�nea del archivo. Utiliza el punto y
		 * coma (;) como separador de columnas en el archivo. Usa solo los campos
		 * c�digo, nombre, categor�a, precio de venta y de compra. El archivo tendr� el
		 * nombre Productos_Categoria_XXXX.txt, donde XXXX ser� la categor�a elegida.
		 */
		
		String bd,user, password;
		Properties acceso = new Properties();
		GestionProductos gest;
		
		bd = "classicmodels";
		user = "santiago";
		password= "123456";
		acceso.put("user", user);
		acceso.put("password", password);
		
		try {
			gest = new GestionProductos(ConectarBD.getConexion(password, acceso));
			System.out.println("Conexion a la Bd success");
		} catch (SQLException e) {
			System.out.println("Failed Conexion a BD");
			e.printStackTrace();
		}
		
		
		
	}

}
