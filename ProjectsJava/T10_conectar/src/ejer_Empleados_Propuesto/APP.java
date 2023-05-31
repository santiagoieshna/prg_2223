package ejer_Empleados_Propuesto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import conector.ConectarBD;

public class APP {
	public static void main(String[] args) {
		Connection conexion;
		Scanner sc = new Scanner(System.in);
		Properties acceso = new Properties();
		String url, user, password;
		Empleado empleado;
		GestionEmpleados gest;
		int opcionUsuario = 10;
		// Credenciales
		url = "jdbc:mysql://localhost/classicmodels";
		user = "santiago";
		password = "123456";
		// Ponemos acceso
		acceso.put("user", user);
		acceso.put("password", password);

		try {
			conexion = ConectarBD.getConexion(url, acceso);
			// Menu
			gest = new GestionEmpleados(conexion);

			do {
				menuOpciones();
				opcionUsuario= sc.nextInt();
				Empleado employer = null;
				switch (opcionUsuario) {
				case 1: {
					gest.printAllEmpleados();
					break;
				}
				case 2: {
					employer= new Empleado(pedirCodigo());
					
					if (gest.createEmpleado(employer)){
						System.out.println("Dado de alta correctamente");
					}else {
						System.out.println("No se pude dar de Alta");
					}
					break;
				}
				case 3: {

					break;
				}
				case 4: {
					gest.printNames();
					break;
				}
				case 5: {

					break;
				}
				case 6: {

					break;
				}
				default:
					System.out.println("Animo!");
				}
			} while (opcionUsuario != 6);
			

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	static public void menuOpciones() {
		System.out.println("\n***Menu****\n" + "1) Ver empleados\n" + "2) Dar Alta Empleados\n" + "3) Eliminar empleado\n"
				+ "4) Mostrar nombres\n" + "5) nombre departamento\n" + "6) Salir");
	}
	
	static public String pedirCodigo() {
		System.out.print("Inserte el codigo de empleado: ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
}
