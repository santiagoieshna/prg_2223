package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion_bd.ConectarBD;
import model.Cliente;

public class ClienteRepository {
	private static final String CLIENTES_ByCiudad = "select numeroCliente, nombre, telefono, ciudad, pais from clientes where ciudad=?";
	private static final String CLIENTES_TOOS = "select numeroCliente, nombre, telefono, ciudad, pais from clientes ";
	private static Connection conexion;

	public static ArrayList<Cliente> getClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();

		conexion = ConectarBD.getConexion();
		
		try {
			
			PreparedStatement sentencia = conexion.prepareStatement(CLIENTES_TOOS);
			ResultSet respuesta = sentencia.executeQuery();
			while(respuesta.next()) {
				
				clientes.add(addCliente(respuesta));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (ArrayList<Cliente>) clientes;
	}

	
	private static Cliente addCliente(ResultSet respuesta) throws SQLException {
		Cliente cliente = new Cliente();
		
		cliente.setNumeroCliente(respuesta.getString("numerocliente"));
		cliente.setNombre(respuesta.getString("nombre"));
		cliente.setTelefono(respuesta.getString("telefono"));
		cliente.setPais(respuesta.getString("pais")); 
		cliente.setCiudad(respuesta.getString("ciudad")); 
		return cliente;
	}
	
	public static ArrayList<Cliente> getClientesByCiudad(String ciudad) {
		List<Cliente> clientes = new ArrayList<Cliente>();

		conexion = ConectarBD.getConexion();
		
		try {
			
			PreparedStatement sentencia = conexion.prepareStatement(CLIENTES_ByCiudad);
			sentencia.setString(1, ciudad);
			ResultSet respuesta = sentencia.executeQuery();
			while(respuesta.next()) {
				
				clientes.add(addCliente(respuesta));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (ArrayList<Cliente>) clientes;
	}

}
