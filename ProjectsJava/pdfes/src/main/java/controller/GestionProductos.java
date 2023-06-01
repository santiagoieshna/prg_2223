package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.Producto;

public class GestionProductos {
	private ProductosRepository productoStorage;
	private Connection conexion;
	private List<Producto> pdfProducto;

	public GestionProductos(Connection conexion) throws Exception {
		super();

		this.conexion = conexion;
		productoStorage = new ProductosRepository();
		if (!loadProductos()) {
			throw new Exception();
		}

	}

	private boolean loadProductos() {
		boolean respuesta = false;
		productoStorage = new ProductosRepository();
		String query = "Select * from productos";
		try {
			PreparedStatement sentencia = getConexion().prepareStatement(query);
			ResultSet response = sentencia.executeQuery();
			while (response.next()) {

				Producto producto = new Producto(response.getString("codigoProducto"));
				producto.setNombreProducto(response.getString("nombreProducto"));
				producto.setCategoriaProducto(response.getString("categoriaProducto"));
				producto.setEscala(response.getString("escala"));
				producto.setVendedor(response.getString("vendedor"));
				producto.setDescripcion(response.getString("descripcion"));
				producto.setUnidadesStock(response.getShort("unidadesStock"));
				producto.setPrecioCompra(response.getFloat("precioCompra"));
				producto.setPrecioVenta(response.getFloat("precioVenta"));
				this.productoStorage.addProdcuto(producto);
			}
			respuesta = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	public boolean selectInventadaJiJiJaJaGallinaTuerta(Float precioMin, Float precioMax) {
		boolean respuesta = false;
		String query = "Select * from productos where  precioVenta > ? AND precioVenta < ?";
		pdfProducto = new ArrayList<Producto>();
		try {
			PreparedStatement sentencia = getConexion().prepareStatement(query);
			sentencia.setFloat(1, precioMin);
			sentencia.setFloat(2, precioMax);
			ResultSet response = sentencia.executeQuery();
			while (response.next()) {
				Producto producto = new Producto(response.getString("codigoProducto"));
				producto.setNombreProducto(response.getString("nombreProducto"));
				producto.setCategoriaProducto(response.getString("categoriaProducto"));
				producto.setEscala(response.getString("escala"));
				producto.setVendedor(response.getString("vendedor"));
				producto.setDescripcion(response.getString("descripcion"));
				producto.setUnidadesStock(response.getShort("unidadesStock"));
				producto.setPrecioCompra(response.getFloat("precioCompra"));
				producto.setPrecioVenta(response.getFloat("precioVenta"));
				pdfProducto.add(producto);
			}

			respuesta = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;
	}

	public void crearPdf() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));

			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//			Chunk chunk = new Chunk("Hello World", font);
			PdfPTable table = new PdfPTable(3);
			
//		addTableHeader(table);
//		addRows(table);
//		addCustomRows(table);
			
			for (Producto producto : pdfProducto) {
				table.addCell(new Phrase(producto.getNombreProducto(), font));
				table.addCell(new Phrase(producto.getPrecioCompra().toString(), font));
				table.addCell(new Phrase(producto.getPrecioVenta().toString(), font));
			}

			document.add(table);
//			document.add(chunk);
			document.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			document.close();
		}
	}

	public ProductosRepository getProductoStorage() {
		return productoStorage;
	}

	public void setProductoStorage(ProductosRepository productoStorage) {
		this.productoStorage = productoStorage;
	}

	public Connection getConexion() {
		return conexion;
	}

}
