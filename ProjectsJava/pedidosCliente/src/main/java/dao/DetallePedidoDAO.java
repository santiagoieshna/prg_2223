package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionBD;
import model.DetallePedido;

public class DetallePedidoDAO {
	private Connection conexion;

	private final String ALL_DETALLESPEDIDOS = "SELECT * FROM detallespedidos";
	
	private final String GET_BY_ID_DETALLEPEDIDO = "SELECT * from detallespedidos WHERE numeroPedido=?";
	
	public DetallePedidoDAO() {
		super();
		conexion = ConexionBD.getConexion();
	}
	
	public ArrayList<DetallePedido> cargarDetallesPedidos() {
		ArrayList<DetallePedido> detallespedidos = new ArrayList<DetallePedido>();
		PreparedStatement sentencia;
		ResultSet rs;
		
		try {
			sentencia = this.conexion.prepareStatement(ALL_DETALLESPEDIDOS);
			rs = sentencia.executeQuery();
			while(rs.next()) {
				detallespedidos.add(addDetallePedido(rs));
			}
			sentencia.close();
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return detallespedidos;
	}
	
	private DetallePedido addDetallePedido(ResultSet rs) throws SQLException {
		DetallePedido detallePedido = new DetallePedido();
		
		detallePedido.setNumeroPedido(rs.getString("numeroPedido"));
		detallePedido.setCodigoProducto(rs.getString("codigoProducto"));
		detallePedido.setCantidadPedida(rs.getInt("cantidadPedida"));
		detallePedido.setPrecioUnidad(rs.getFloat("preciounidad"));
		detallePedido.setNumeroLineaPedido(rs.getShort("numeroLineaPedido"));
		
		return detallePedido;
	}

	public ArrayList<DetallePedido> getOneById(String id) {
		ArrayList<DetallePedido> detallespedidos = new ArrayList<DetallePedido>();
		PreparedStatement sentencia;
		ResultSet rs;
		
		try {
			sentencia = conexion.prepareStatement(GET_BY_ID_DETALLEPEDIDO);
			sentencia.setString(1, id);
			rs=sentencia.executeQuery();
			while(rs.next()) {
				detallespedidos.add(addDetallePedido(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detallespedidos;
	}
	
	
	
}
