package controller;

import java.util.ArrayList;

import dao.DetallePedidoDAO;
import model.DetallePedido;
import model.Pedido;
import model.Producto;

public class GestionDetallesPedidos {
	ArrayList<DetallePedido> lineas;
	private DetallePedidoDAO lineasRepository;
	
	public GestionDetallesPedidos() {
		super();
		lineasRepository = new DetallePedidoDAO();
		lineas = lineasRepository.cargarDetallesPedidos();
	}
	
	public ArrayList<DetallePedido> getLineas(){
		return lineas;
	}
	
	public DetallePedido[] getLineasByID(String id){
		
		ArrayList<DetallePedido> lineasFiltradas= getListFilter(id); 	
	
		return getlineasPedido(lineasFiltradas);
	}


	private ArrayList<DetallePedido> getListFilter(String id) {
		ArrayList<DetallePedido> lineasFiltradas= new ArrayList<DetallePedido>();
		
		for (DetallePedido linea : lineas) {
			if( linea.getNumeroPedido().equals(id) )
				lineasFiltradas.add(linea);
		}
		return lineasFiltradas;
	}
	
	/**
	 * Metodo que devuelve un array DetallePedido, con sus lineas (NumeroLineas) ordenadas
	 * @param lineasFiltradas
	 * @return
	 */
	private DetallePedido[] getlineasPedido(ArrayList<DetallePedido> lineasFiltradas) {
		DetallePedido[] lineasPedido = new DetallePedido[lineasFiltradas.size()];
		
		for (DetallePedido linea : lineasFiltradas) {
			lineasPedido[linea.getNumeroLineaPedido()-1]=linea;
		}
		
		return lineasPedido;
	}
	
	// No implementado, la idea es ver cuando se ha ganado por producto con este array
	private DetallePedido[] getLineasProducto(ArrayList<DetallePedido> lineasFiltradas) {
		// TODO Metodo que guardara en un array todas las lineas que hay de un producto
		// producto identidicado por su id (codigoProdcuto)
		DetallePedido[] lineasProdcuto = new DetallePedido[lineasFiltradas.size()];
		
		return lineasProdcuto;
	}
	
	
}
