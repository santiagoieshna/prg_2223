package principal;

import java.util.Scanner;

import controller.GestionPedidoCliente;
import model.Cliente;

public class APP {

	
	public static void main(String[] args) {
		Integer opcionUsuario = 0;
		Scanner sc = new Scanner(System.in);
		GestionPedidoCliente gest = new GestionPedidoCliente();
//		
		
		System.out.println("-------- ------------- ----------- -------------");
//		gest.mostrarTodosPedidos();
		System.out.println("-------- ----------------- --------------  -----------------");
//		gest.mostrarLineasPedido("10100");
		
		String fakeId="1";
		do {
			mostrarMenu();
			opcionUsuario= sc.nextInt();
			Cliente cliente = new Cliente();
			
			switch (opcionUsuario) {
			case 1:
				gest.mostarTodosClientes();
				break;
			case 2:
				System.out.println("Inserte Ciudad");
				String ciudad = sc.next();
				gest.mostrarClientesCiudad(ciudad);
				break;
			case 3:
				cliente = fakeCliente(fakeId);
				gest.addCliente(cliente);
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				System.out.println("\nSaliendo del Sistema..");
				break;

			default:
				System.out.println();
				break;
			}
			System.out.println();
			Integer incrementId= Integer.parseInt(fakeId)+1;
			fakeId= incrementId.toString();
		}while(opcionUsuario != 6);
		
	}

	private static Cliente fakeCliente(String id) {
		Cliente cliente= new Cliente();
		cliente.setNumeroCliente(id);
		cliente.setNombre("Harnina");
		cliente.setNombreContacto("David");
		cliente.setApellidoContacto("Sanchez");
		cliente.setCiudad("Madrid");
		// PAIS
		cliente.setPais("Spains2");
		cliente.setTelefono("666123456");
		cliente.setCpostal("06200");
		cliente.setDireccionLinea1("Avd la Paz");
		
		return cliente;
	}

	private static void mostrarMenu() {
		String menu = "*******  MENU  ********"
				+ "\n\n1) Mostrar Todos los Clientes"
				+ "\n2) Clientes de una Ciudad"
				+ "\n3) Agregar Cliente"
				+ "\n4) Crear ClientesPedidos.txt"
				+ "\n5) Ver una Factura"
				+ "\n6) Salir";
		System.out.println(menu);
	}
	
	
}
