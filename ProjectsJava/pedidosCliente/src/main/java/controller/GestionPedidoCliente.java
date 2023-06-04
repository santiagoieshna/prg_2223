package controller;

import java.util.ArrayList;

public class GestionPedidoCliente {
	private GestionClientes gestClientes;
	private GestionPedidos gestPedidoss;
	private GestionProductos gestProductos;
	
	public GestionPedidoCliente() {
		super();
		
		gestClientes = new GestionClientes();
		gestPedidoss= new GestionPedidos();
		gestProductos = new GestionProductos();
		
	}
	
	public void mostrarClientesCiudad(String Ciudad) {
		
		gestClientes.printListClientes(gestClientes.clienteByCiudad(Ciudad));
	}
	
	public void mostarTodosClientes() {
		gestClientes.printTodosClientes();
	}
	
}
