package Ejercicio2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import conector.ConectarBD;
import util.UtilesBD;

public class InsertarFilas {
	/*
	 * DiseÃ±a un proyecto Java que permita insertar filas en la tabla
	 * â€œcategoriasproductosâ€�. Los datos se solicitarÃ¡n al usuario.
	 * 
	 */
	public static void main(String[] args) {
		String url, nombre, pass;
		Properties acceso = new Properties(2);
		Connection con;
		Statement ejecutorSentencia;
		ResultSet respuesta;
		ResultSetMetaData metaData;
		StringBuilder sentencia= new StringBuilder();
		
		
		url = "jdbc:mysql://localhost:3306/classicmodels";
		nombre = "santiago";
		pass="123456";
		acceso.put("user", nombre);
		acceso.put("password", pass);
		
		try {
			con= ConectarBD.getConexion(url, acceso);
			ejecutorSentencia = con.createStatement();
			String categoria = crearSentencia(sentencia);
			int numero = ejecutorSentencia.executeUpdate(sentencia.toString());
			System.out.println(numero);
			respuesta= ejecutorSentencia.executeQuery("Select * from categoriasproductos where categoria ='"+categoria+"'");
			metaData = respuesta.getMetaData();
			UtilesBD.printRes(respuesta, metaData);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error no trackeado: "+e.getMessage());
		}
		
		
	}
	/*
	 * Modifica la Query por referencia y devuelve la clave primaria que sera el primer
	 * elemento insertado pro teclado
	 */
	public static String crearSentencia(StringBuilder sentencia) {
		String[] campos= {"categoria","descripcion","imgen"};
		ArrayList<String> values= new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < campos.length; i++) {
			System.out.print("inserte "+campos[i]+": ");
			values.add(sc.nextLine());
		}
		sentencia.append("insert into categoriasproductos (categoria, descripcion, imagen)"+
					" Values ('"+values.get(0)+"','"+values.get(1)+"','"+values.get(2)+"')");
		return values.get(0);
	}
}
