package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionBD;
import controller.GestionDetallesPedidos;
import model.Pedido;

public class PedidoDAO {
	private static Connection conexion;
	private final String ALL_PEDIDOS = "SELECT * from pedidos";
	private final String SAVE_PEDIDOS = "INSERT INTO pedidos (numeroPedido, fechaPedido, fechaEntrega,"
										+ "estado,comentarios, numeroCliente) VALUES (?,?,?,?,?,?)";
	private final String UPDATE_PEDIDOS= "UPDATE pedidos SET fechaPedido=?, fechaEntrega=?,estado=?,"
										+ "comentarios=?,numeroCliente=? WHERE numeroPedido=?";
	GestionDetallesPedidos gestLineas;
	
	public PedidoDAO() {
		super();
		
		this.conexion = ConexionBD.getConexion();
		gestLineas = new GestionDetallesPedidos();
	}
	
	public ArrayList<Pedido> cargarPedidos(){
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		
		PreparedStatement sentencia;
		ResultSet rs ;
		try {
			sentencia = conexion.prepareStatement(ALL_PEDIDOS);
			rs = sentencia.executeQuery();
			
			while(rs.next()) {
				pedidos.add(addPedido(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		return pedidos;
	}

	private Pedido addPedido(ResultSet rs) throws SQLException {
		Pedido pedido = new Pedido();
		
		pedido.setNumeroPedido(rs.getString("numeroPedido"));
		pedido.setFechaPedido(rs.getString("fechaPedido"));
		pedido.setFechaEntrega(rs.getString("fechaEntrega"));
		pedido.setEstado(rs.getString("estado"));
		pedido.setComentarios(rs.getString("comentarios"));
		pedido.setNumeroCliente(rs.getString("numeroCliente"));
		
		pedido.setLineas(gestLineas.getLineasByID(pedido.getNumeroPedido()));
		
		return pedido;
	}
	
	
	
	
	
}
