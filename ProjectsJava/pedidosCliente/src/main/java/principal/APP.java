package principal;

import controller.GestionPedidoCliente;

public class APP {

	
	public static void main(String[] args) {
		
		GestionPedidoCliente gest = new GestionPedidoCliente();
//		gest.mostarTodosClientes();
		gest.mostrarClientesCiudad("Madrid");
	}
	
	
}
