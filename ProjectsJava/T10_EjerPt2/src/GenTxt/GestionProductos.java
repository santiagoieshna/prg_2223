package GenTxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import producto.Producto;

public class GestionProductos implements Gestionable {
	private List<Producto> listProductos;
	private Connection conexion;
	private BufferedWriter escritor;

	/**
	 * @param listProductos
	 * @throws SQLException
	 */
	public GestionProductos(Connection conexion) throws SQLException {
		super();
		this.conexion = conexion;
		listProductos = new ArrayList<Producto>();
		getAllProductos();
	}

	@Override
	public boolean getAllProductos() {
		boolean respuesta = false;
		String query = "Select * from productos";
		try {
			PreparedStatement ejecutor = this.conexion.prepareStatement(query);
			ResultSet rs = ejecutor.executeQuery();
			respuesta = true;
			while (rs.next()) {
				Producto producto = new Producto(rs.getString("codigoProducto"));
				producto.setNombreProducto("nombreProducto");
				producto.setCateogriaProducto("categoriaProducto");
				producto.setEscala("escala");
				producto.setUnidadesStock(Short.parseShort(rs.getString("unidadesStock")));
				producto.setPrecioCompra(Float.parseFloat(rs.getString("precioCompra")));
				producto.setPrecioVenta(Float.parseFloat(rs.getString("precioVenta")));
			}
		} catch (SQLException e) {
			respuesta = false;
		} catch (Exception e) {
			respuesta = false;
		}

		return respuesta;
	}

	@Override
	public BufferedWriter openFile(String fileName) throws IOException {
		this.escritor = new BufferedWriter(new FileWriter(fileName));
		return escritor;
	}

	@Override
	public boolean writeFile(String[] productosFormateados) {
		boolean respuesta = false;
		try {
			for (String string : productosFormateados) {
				this.escritor.write(string);
				this.escritor.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				escritor.close();
				respuesta = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return respuesta;
	}

	@Override
	public ArrayList<String> readFile(String fileName) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(fileName));	
		ArrayList<String> productos= new ArrayList<String>();
		String producto;
		
		while((producto=lector.readLine())!=null) {
			productos.add(producto);
		}
		lector.close();
		
		return productos;	
	}

	@Override
	public void printLines(ArrayList<String> fichero) {
		
		
	}

}

