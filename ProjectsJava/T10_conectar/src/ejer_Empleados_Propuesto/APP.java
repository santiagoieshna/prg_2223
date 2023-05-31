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
				
				// MENU
				switch (opcionUsuario) {
				case 1: {
					gest.printAllEmpleados();
					break;
				}
				case 2: {
					
					
					if (gest.createEmpleado()){
						System.out.println("Dado de alta correctamente");
					}else {
						System.out.println("No se pudo dar de Alta");
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
					gest.cargarEmpleados();
					break;
				}
				case 7: {
					System.out.println("Saliendo del sistema..");
					break;
				}
				default:
					System.out.println("Animo!");
				}
			} while (opcionUsuario != 7);
			

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	static public void menuOpciones() {
		System.out.println("\n***Menu****\n" + "1) Ver empleados\n" + "2) Dar Alta Empleados\n" + "3) Eliminar empleado\n"
				+ "4) Mostrar nombres\n" + "5) nombre departamento\n" + "6) Cargar Empleados de BD"+"7) Salir");
	}

	
}
