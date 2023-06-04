package controller;

import java.util.ArrayList;

import dao.PedidoDAO;
import model.DetallePedido;
import model.Pedido;

public class GestionPedidos {

	private ArrayList<Pedido> pedidos;
	private PedidoDAO pedidoRepository;
	
	
	public GestionPedidos() {
		super();
		this.pedidoRepository = new PedidoDAO();
		this.pedidos = pedidoRepository.cargarPedidos();
	}

	public void printPedidos() {
		for (Pedido pedido : pedidos) {
			System.out.println(pedido);
		}
	}
	
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public Pedido getPedidoById(String id) {
		for (Pedido pedido : pedidos) {
			if(pedido.getNumeroPedido().equals(id))
				return pedido;
		}
		return null;
	}
	
	public void printLineasPedidoByID(String id) {
		Pedido pedido = getPedidoByID(id);
		for (DetallePedido linea : pedido.getLineas()) {
			System.out.println(linea.toString());
		}
	}
	public Pedido getPedidoByID(String id) {
		for (Pedido pedido : pedidos) {
			if(pedido.getNumeroPedido().equals(id))
				return pedido;
		}
		return null;
	}
	
}
