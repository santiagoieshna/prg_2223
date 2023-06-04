package controller;

import java.util.ArrayList;

import model.Cliente;

public class GestionPedidoCliente {
	private GestionClientes gestClientes;
	private GestionPedidos gestPedidos;
	private GestionProductos gestProductos;
	
	public GestionPedidoCliente() {
		super();
		
		gestClientes = new GestionClientes();
		gestPedidos= new GestionPedidos();
		gestProductos = new GestionProductos();
		
	}
	
	public void mostrarClientesCiudad(String Ciudad) {
		
		gestClientes.printListClientes(gestClientes.clienteByCiudad(Ciudad));
	}
	
	public void mostarTodosClientes() {
		gestClientes.printTodosClientes();
	}
	
	public void mostrarTodosPedidos() {
		gestPedidos.printPedidos();
	}
	
	public void mostrarLineasPedido(String idPedido) {
		gestPedidos.printLineasPedidoByID(idPedido);
	}

	public void addCliente(Cliente cliente) {
		gestClientes.guardarCliente(cliente);
		
	}
	
}
