package ejercicio3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestionProductos implements Gestionable{
	private Set<Producto> productos;
	private Connection conexion;
	private Statement st;
	
	
	public GestionProductos() {
		super();
		productos=new HashSet<>();
	}
	public GestionProductos(Connection conexion) {
		try {
			this.conexion = conexion;
			st = conexion.createStatement();
			productos=new HashSet<>();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cargarProductos();
	}

	@Override
	public void setConexion(Connection conexion) throws SQLException {
		this.conexion=conexion;
		st = conexion.createStatement();
		productos=new HashSet<>();// Lo reseteo ?¿?
	}

	@Override
	public boolean cargarProductos() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT * FROM productos");
		try {
			ResultSet rs = st.executeQuery(query.toString());
			
			while(rs.next()) {
				//Cargo un producto
				Producto p = new Producto(new StringBuilder(rs.getString("codigoProducto")));
				p.setNombreProducto(new StringBuilder(rs.getString("nombreProducto")));
				p.setCateogriaProducto(new StringBuilder(rs.getString("categoriaProducto")));
				p.setEscala(new StringBuilder(rs.getString("escala")));
				p.setVendedor(new StringBuilder(rs.getString("vendedor")));
				p.setDescripcion(new StringBuilder(rs.getString("descripcion")));
				p.setUnidadesStock(Short.parseShort(rs.getString("unidadesStock")));
				p.setPrecioCompra(Float.parseFloat(rs.getString("precioCompra")));
				p.setPrecioVenta(Float.parseFloat(rs.getString("precioVenta")));
				//Lo guardo en mi lista
				productos.add(p);
			}
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addProductos(Producto producto) {
		boolean resp = productos.contains(producto);
		String query="INSERT INTO productos (codigoProducto,nombreProducto, categoriaProducto,escala"
				+" vendedor,descripcion,unidadesStock,precioCompra,precioVenta) VALUES ('"
				+producto.getCodigoProducto().toString()+"','"+producto.getNombreProducto().toString()
				+"','"+producto.getCateogriaProducto().toString()+"','"+producto.getEscala().toString()+"','"
				+producto.getVendedor()+"','"+producto.getDescripcion().toString()+"','"+producto
				.getUnidadesStock().toString()+"','"+producto.getPrecioCompra().toString()+"','"
				+producto.getPrecioVenta().toString()+"')";
		if(resp) {
			int rs;
			try {
				rs = st.executeUpdate(query);
				
				resp= (rs!=0 && productos.add(producto));
				
			} catch (SQLException e) {
				resp=false;
				e.printStackTrace();
			}catch (Exception e) {
				resp=false;
				e.printStackTrace();
			}
		}
		return resp;
	}

	@Override
	public void showProducto(Producto producto) {
		System.out.println(producto.toString());
	}

	@Override
	public void showProducto(StringBuilder id_producto) {
		System.out.println(getProducto(id_producto).toString());
	}

	@Override
	public void showAllProdcutos() {
		for (Producto productoo : productos) {
			System.out.println(productoo.toString());
		}
//		for (int i = 0; i < productos.size(); i++) {
//			System.out.println(productos.get(i));
//		}
		
	}

	@Override
	public Producto getProducto(StringBuilder id_producto) {
		
		return null;
	}

	@Override
	public boolean deleteProducto(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePriceSell() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePriceSell(Float porcentje) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean vaciarLista() {
		try {
			productos=new HashSet<>();
			return true;
		}catch (Exception e) {
			return false;			
		}
	}
	@Override
	public Producto addProductos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
