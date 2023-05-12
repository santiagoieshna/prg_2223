package ejercicio3;

import java.sql.Connection;
import java.sql.SQLException;

public interface Gestionable {
		
	public void setConexion(Connection conexion) throws SQLException;
	public boolean cargarProductos();
	public boolean addProductos(Producto producto);
	public Producto addProductos();
	public void showProducto(Producto producto);
	public void showProducto(String id_producto);
	public void showAllProdcutos();
	public Producto getProducto(String id_producto);
	public boolean deleteProducto(Producto producto);
	public boolean updatePriceSell();
	public boolean updatePriceSellFacil();
	public boolean updatePriceSell(Float porcentaje);
	public boolean vaciarLista();
	
}
