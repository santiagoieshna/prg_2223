package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import dao.ClienteDAO;
import model.Cliente;

public class GestionClientes {
	private ArrayList<Cliente> clientes;
	private ClienteDAO ClienteRepository;

	public GestionClientes() {
		super();

		ClienteRepository = new ClienteDAO();

		clientes = ClienteRepository.cargarClientes();

	}

	public void printTodosClientes() {
		for (Cliente cliente : this.clientes) {
			System.out.println(cliente.toString());
		}
	}

	public void printListClientes(ArrayList<Cliente> clientesCiudad) {
		for (Cliente cliente : clientesCiudad) {
			System.out.println(cliente.toString());
		}
	}

	public Cliente getCliente(String id) {
		for (Cliente cliente : this.clientes) {
			if (cliente.getNumeroCliente().equals(id)) {
				return cliente;
			}
		}
		return null;
	}

	public void cargarClientes() throws SQLException {
		clientes = ClienteRepository.cargarClientes();
	}

	public ArrayList<Cliente> clienteByCiudad(String ciudad) {
		ArrayList<Cliente> clientePorCiudad = new ArrayList<Cliente>();

		for (Cliente cliente : this.clientes) {
			if (cliente.getCiudad().equalsIgnoreCase(ciudad))
				clientePorCiudad.add(cliente);
		}

		return clientePorCiudad;
	}

	public void guardarCliente(Cliente cliente) {
		Set<String> paises = fillPaises();

		if (paises.contains(cliente.getPais()))
			ClienteRepository.guardarCliente(cliente);
		else
			System.err.println("No se pudo guardar el cliente: El pais no existe en la tabla de datos");
	}

	private Set<String> fillPaises() {
		Set<String> paises = new HashSet<String>();
		for (Cliente cliente : this.clientes) {
			paises.add(cliente.getPais());
		}
		return paises;
	}

}
