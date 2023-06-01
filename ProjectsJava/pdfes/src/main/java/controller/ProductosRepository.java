package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Producto;

public class ProductosRepository {
	private List<Producto> listProductos;

	public ProductosRepository() {
		this.listProductos= new ArrayList<Producto>();
	}
	
	public ProductosRepository(List<Producto> listProductos) {
		super();
		this.listProductos = listProductos;
	}


	public List<Producto> getListProductos() {
		return listProductos;
	}

	public void setListProductos(List<Producto> listProductos) {
		this.listProductos = listProductos;
	}
	
	public void printProductos() {
		for (Producto producto : listProductos) {
			System.out.println(producto.toString());
		}
	}
	
	public Producto getProducto(String id) {
		for (Producto producto : listProductos) {
			if(producto.getCodigoProducto().equals(id)) {
				return producto;
			}
		}
		return null;
	}
	
	public boolean deleteProducto(String id) {
		boolean respuesta= false;
		Iterator iterator = listProductos.iterator();
		while(iterator.hasNext()) {
			Producto producto = (Producto) iterator.next();
			if(producto.getCodigoProducto().equals(id)) {
				iterator.remove();
				return true;
			}
		}
		return respuesta;
	}

	public void addProdcuto(Producto producto) {
		this.listProductos.add(producto);
		
	}
}
