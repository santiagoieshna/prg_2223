package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionBD;
import model.Cliente;

public class ClienteDAO {
	private final String ALL_CLIENTES= "SELECT * FROM clientes";
	private final String SAVE_CLIENTE= "INSERT INTO CLIENTES (numeroCliente, nombre, nombreContacto,"
										+ " apellidoContacto,telefono, direccionLinea1,ciudad, pais)"
										+ "VALUES (?,?,?,?,?,?,?,?)";
	private final String UPDATE_CLIENTE= "UPDATE clientes SET nombre=?, nombreContacto=?, apellidoContacto=?,"
										+ "telefono=?, direccionLinea1=?,ciudad=?,pais=? WHERE numeroCliente=?";
	private static Connection conexion;
	
	
	
	public ClienteDAO() {
		super();
		this.conexion = ConexionBD.getConexion();
	}
	
	public ArrayList<Cliente> cargarClientes() {
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		PreparedStatement sentencia;
		try {
		sentencia = conexion.prepareStatement(ALL_CLIENTES);
		ResultSet response = sentencia.executeQuery();
		
			while(response.next()) {
				clientes.add(addCliente(response));
			}
			response.close();
			sentencia.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	private Cliente addCliente(ResultSet response) throws SQLException {
		Cliente cliente = new Cliente();
		
		cliente.setNumeroCliente(response.getString("numeroCliente"));
		cliente.setNombre(response.getString("nombre"));
		cliente.setNombreContacto(response.getString("nombreContacto"));
		cliente.setApellidoContacto(response.getString("apellidoContacto"));
		cliente.setTelefono(response.getString("telefono"));
		cliente.setDireccionLinea1(response.getString("direccionLinea1"));
		cliente.setDireccionlinea2(response.getString("direccionLinea2"));
		cliente.setCiudad(response.getString("ciudad"));
		cliente.setEstado(response.getString("estado"));
		cliente.setCpostal(response.getString("cpostal"));
		cliente.setPais(response.getString("pais"));
		cliente.setEmpleadoGestorVentas(response.getString("empleadoGestorVentas"));
		cliente.setLimiteCredito(response.getFloat("limiteCredito"));
		
		return cliente;
	}

	public void guardarCliente(Cliente cliente) {
		
		try {
			if(cliente == null) {
				throw new Exception("Cliente es Null");
			}
			
			PreparedStatement sentencia = conexion.prepareStatement(SAVE_CLIENTE);
			sentencia.setString(1, cliente.getNumeroCliente());
			sentencia.setString(2, cliente.getNombre());
			sentencia.setString(3, cliente.getNombreContacto());
			sentencia.setString(4, cliente.getApellidoContacto());
			sentencia.setString(5, cliente.getTelefono());
			sentencia.setString(6, cliente.getDireccionLinea1());
			sentencia.setString(7, cliente.getCiudad());
			sentencia.setString(8, cliente.getPais());
			if(sentencia.executeUpdate()==1) {
				System.out.println("Cliente guardado");
			}else {
				System.err.println("No se pudo guardar el cliente");
			}
			//Importante cerrarlo....
			sentencia.close();
			
		}catch (SQLException e) {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void actualizarCliente(Cliente cliente) {
		
		try {
			if(cliente == null) {
				throw new Exception("Cliente es Null");
			}
			
			PreparedStatement sentencia = conexion.prepareStatement(UPDATE_CLIENTE);
			sentencia.setString(1, cliente.getNombre());
			sentencia.setString(2, cliente.getNombreContacto());
			sentencia.setString(3, cliente.getApellidoContacto());
			sentencia.setString(4, cliente.getTelefono());
			sentencia.setString(5, cliente.getDireccionLinea1());
			sentencia.setString(6, cliente.getCiudad());
			sentencia.setString(7, cliente.getPais());
			sentencia.setString(8, cliente.getNumeroCliente());
			if(sentencia.executeUpdate()==1) {
				System.out.println("Cliente guardado");
			}else {
				System.err.println("No se pudo guardar el cliente");
			}
			//Importante cerrarlo....
			sentencia.close();
			
		}catch (SQLException e) {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
