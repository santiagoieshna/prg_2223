package ejercicio3;

import java.sql.Connection;
import java.sql.SQLException;

public interface Gestionable {
		
	public void setConexion(Connection conexion) throws SQLException;
	public boolean cargarProductos();
	public boolean addProductos(Producto producto);
	public void showProducto(Producto producto);
	public void showProducto(StringBuilder id_producto);
	public void showAllProdcutos();
	public Producto getProducto(StringBuilder id_producto);
	public boolean deleteProducto(Producto producto);
	public boolean updatePriceSell();
	public boolean updatePriceSell(Float porcentje);
	public boolean vaciarLista();
	
}
