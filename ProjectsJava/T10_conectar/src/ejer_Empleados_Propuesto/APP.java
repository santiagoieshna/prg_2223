package ejer_Empleados_Propuesto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import conector.ConectarBD;

public class APP {
	public static void main(String[] args) {
//		Connection conexion;
//		Properties acceso=new Properties();
//		String url, user,password;
//		Empleado empleado;
//		int opcionUsuario=10;
//		//Credenciales
//		url="jdbc:mysql://localhost/classicmodels";
//		user="santiago";
//		password="123456";
//		//Ponemos acceso
//		acceso.put("user", user);
//		acceso.put("password",password);
//		
//		
//		try {
//			conexion=ConectarBD.getConexion(url, acceso);
//			//Menu
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
		for (int i = 1; i <= 5; i++) {
			System.out.print(i+", "+(100-i)+", ");
		}
		
	}
}
