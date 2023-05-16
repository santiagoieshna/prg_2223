package ejercicio3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
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
	
	public boolean isEmpty() {
		return productos.isEmpty();
	}

	@Override
	public void setConexion(Connection conexion) throws SQLException {
		this.conexion=conexion;
		st = conexion.createStatement();
		productos=new HashSet<>();// Lo reseteo ?¿?
	}

	@Override
	public boolean cargarProductos() {
		this.productos=new HashSet<>();//Reseteamos HasSet
		StringBuilder query = new StringBuilder();
		query.append("SELECT * FROM productos");
		try {
			ResultSet rs = st.executeQuery(query.toString());
			
			while(rs.next()) {
				//Cargo un producto
				Producto p = new Producto(rs.getString("codigoProducto"));
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
		System.out.println(productos.contains(producto)); 
//		System.out.println(producto.toString()); 
		boolean resp = true;
		
		String query="INSERT INTO productos (codigoProducto,nombreProducto, categoriaProducto,escala,"
				+" vendedor,descripcion,unidadesStock,precioCompra,precioVenta) VALUES ('"
				+producto.getCodigoProducto().toString()+"','"+producto.getNombreProducto().toString()
				+"','"+producto.getCateogriaProducto().toString()+"','"+producto.getEscala().toString()+"','"
				+producto.getVendedor().toString()+"','"+producto.getDescripcion().toString()+"',"+producto
				.getUnidadesStock().toString()+","+producto.getPrecioCompra().toString()+","
				+producto.getPrecioVenta().toString()+")";

//		String query = "Insert into productos (codigoProducto,nombreProducto, categoriaProducto,escala,"
//				+ "vendedor,descripcion,unidadesStock,precioCompra,precioVenta) values ('999911','Licuadora' ,'Motorcycles', 'escaladora','Angel Acedo Requejo',"
//				+"'descripcion prueba', 123, 12.45, 13.45)";
		if(resp) {
			int rs;
			try {
				rs = st.executeUpdate(query);
				
				resp= (rs!=0 && productos.add(producto));
				
			} catch (SQLException e) {
				resp=false;
				System.out.println("Error de SQL en AddProducto");
				e.printStackTrace();
			}catch (Exception e) {
				resp=false;
				System.out.println("Error INESPERADO en AddProducto");
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
	public void showProducto(String id_producto) {
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
	public Producto getProducto(String id_producto) {
//		Iterator<Producto> it = productos.iterator();
//		while(it.hasNext()) {
//			Producto producto= it.next();
//			if(producto.getCodigoProducto().equals(id_producto)) {
//				return producto;
//			}
//		}
		for (Producto producto : productos) {
			if(producto.getCodigoProducto().equals(id_producto)) {
				return producto;
			}
		}
		return null;
	}

	@Override
	public boolean deleteProducto(Producto producto) {
		int resp=0;
		Iterator<Producto> iterator= productos.iterator();
		while(iterator.hasNext()) {
			Producto productoActual = iterator.next();
			if(producto.getCodigoProducto().equals(productoActual.getCodigoProducto())) {
				try {
				resp= st.executeUpdate("DELETE from productos where codigoProducto ='"+producto.getCodigoProducto()+"'");
				if(resp!=0) {
					iterator.remove();
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return resp!=0;
	}

	@Override
	public boolean updatePriceSell() {
		
		
		boolean resp = true;
		for (Producto producto : productos) {
			//Seteamos el nuevo precio
			producto.setPrecioVenta((float) (producto.getPrecioVenta()*(1+0.05)));
			//Creamos la consulta
			String query="UPDATE productos SET precioVenta = ("+producto.getPrecioVenta().toString()+") Where codigoProducto ='"
			+producto.getCodigoProducto().toString()+"'";
			
	//		String query = "Insert into productos (codigoProducto,nombreProducto, categoriaProducto,escala,"
	//				+ "vendedor,descripcion,unidadesStock,precioCompra,precioVenta) values ('999911','Licuadora' ,'Motorcycles', 'escaladora','Angel Acedo Requejo',"
	//				+"'descripcion prueba', 123, 12.45, 13.45)";
			if(resp) {
				int rs;
				try {
					// Ejecutamos el update, rs es una int que dara != 0 si salio bien
					rs = st.executeUpdate(query);
					
					resp= rs!=0 ;
					
				} catch (SQLException e) {
					resp=false;
					e.printStackTrace();
				}catch (Exception e) {
					resp=false;
					e.printStackTrace();
				}
			}
		}
		return resp;
	}

	@Override
	public boolean updatePriceSell(Float porcentaje) {
		// Con prepareStatement
		PreparedStatement pS;
		int respuesta=0;
		String query="UPDATE productos SET precioVenta = ?";
		porcentaje /= 100;
		String nuevoPorcentaje= "(precioVenta*(1+"+porcentaje.toString()+"))";
		//Pasar por producto tutto

		try {
			pS = this.conexion.prepareStatement(query);
			//Add values
			pS.setString(1, nuevoPorcentaje);
			//Obtenemos T o F si se modificó.
			respuesta= pS.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta!=0;
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
	@Override
	public boolean updatePriceSellFacil() {
		int resp;
		try {
			resp = st.executeUpdate("UPDATE productos SET precioVenta= (precioVenta*(1+0.05))");
		} catch (SQLException e) {
			resp=0;
			e.printStackTrace();
		}
		return resp!=0;
	}
	public void desconectar() {
		try {
			this.conexion.close();
			System.out.println("Bd desconectada");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("No se pudo desconectar la bd");
			e.printStackTrace();
		}
		
	}
	
	

}
