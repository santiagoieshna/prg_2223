package controller;

import java.util.ArrayList;

import dao.PedidoDAO;
import model.DetallePedido;
import model.Pedido;

public class GestionPedidos {

	private ArrayList<Pedido> pedidos;
	private PedidoDAO pedidoRepository;
	private GestionDetallesPedidos gestLineas;

	public GestionPedidos() {
		super();
		this.pedidoRepository = new PedidoDAO();
		this.pedidos = pedidoRepository.cargarPedidos();
		this.gestLineas = new GestionDetallesPedidos();
		// Cargamos las lineas de cada pedido
		cargarLineas();
	}

	private void cargarLineas() {
		for (Pedido pedido : this.pedidos) {
			pedido.setLineas(gestLineas.getLineasByID(pedido.getNumeroPedido()));
		}
	}

	public void printPedidos() {
		for (Pedido pedido : this.pedidos) {
			System.out.println(pedido);
		}
	}

	public ArrayList<Pedido> getPedidos() {
		return this.pedidos;
	}

	public Pedido getPedidoById(String id) {
		for (Pedido pedido : this.pedidos) {
			if (pedido.getNumeroPedido().equals(id))
				return pedido;
		}
		return null;
	}

	public void printLineasPedidoByID(String id) {
		Pedido pedido = getPedidoById(id);
		
		if(pedido != null) {	
		for (DetallePedido linea : pedido.getLineas()) {
			System.out.println(linea.toString());
		}
	}
	}

	/**
	 * Metodo que genera una Lista de todos los pedidos de un cliente
	 * 
	 * @param idCliente
	 * @return
	 */
	public ArrayList<Pedido> getPedidosByCliente(String idCliente) {
		ArrayList<Pedido> pedidosCliente = new ArrayList<Pedido>();

		for (Pedido pedido : this.pedidos) {
			if (pedido.getNumeroCliente().equals(idCliente))
				pedidosCliente.add(pedido);
		}

		return pedidosCliente;
	}

	/**
	 * Metodo que devuelve importe total de Todos los Pedidos de un cliente
	 * 
	 * @param idCliente String
	 * @return Float del importe total
	 */
	public Float importeTotalPedidosCliente(String idCliente) {
		Float importe = 0F;

		for (Pedido pedido : this.pedidos) {
			if (pedido.getNumeroCliente().equals(idCliente)) {
				importe += gestLineas.getImporteLineasPedido(pedido);
			}
		}
		return importe;
	}
	
	public Float getImportePedido(String idPedido) {
		return gestLineas.getImporteLineasPedido(getPedidoById(idPedido));
	}
	
	public DetallePedido[] getLineasPedido(String idPedido) {
		return getPedidoById(idPedido).getLineas();
	}

	public boolean printPedidosCliente(String idCliente) {
		boolean respuesta = false;
		ArrayList<Pedido> pedidosCliente = getPedidosByCliente(idCliente);
		if (pedidosCliente.size() != 0) {
			System.out.println("ID PEDIDOS de Cleinte " + idCliente);
			
			for (Pedido pedido : pedidosCliente) {
				System.out.println(pedido.getNumeroPedido());
			}
			respuesta = true;
		}
		return respuesta;
	}

}
