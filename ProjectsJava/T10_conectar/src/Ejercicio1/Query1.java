package Ejercicio1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import conector.ConectarBD;

public class Query1 {
	/*
	 * Diseña un proyecto Java que obtenga un listado de clientes de una localidad
	 * que será pasada como parámetro. Debes mostrar las columnas número de cliente,
	 * nombre, teléfono y ciudad.
	 * 
	 */
	public static void main(String[] args) {
		String url,ciudad;
		Properties propiedades;
		Connection conexion;
		Statement st;
		ResultSet rs;
		ResultSetMetaData rsmd;
		Scanner consola = new Scanner(System.in);
		
		url = "jdbc:mysql://localhost/classicmodels";
		
		propiedades= new  Properties();
		propiedades.put("user", "santiago");
		propiedades.put("password", "123456");
		
		System.out.print("Ciudad: ");
		ciudad= consola.nextLine();
		System.out.println();
		
		
		try {
		conexion = ConectarBD.getConexion(url, propiedades);
		st = conexion.createStatement(); 
		
		// Query
		rs = st.executeQuery("SELECT numerocliente, nombre, telefono, ciudad FROM clientes WHERE ciudad ='"+ciudad+"'");
		rsmd = rs.getMetaData();
		
		ConectarBD.printRes(rs, rsmd);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
