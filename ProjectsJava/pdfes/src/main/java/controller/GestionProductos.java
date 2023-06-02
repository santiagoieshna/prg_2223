package controller;

import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
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
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import glbalENV.FontsStyles;
import glbalENV.FontsStyles.*;
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
				this.productoStorage.addProdcuto(getProducto(response));
			}
			
			respuesta = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return respuesta;
	}

	private Producto getProducto(ResultSet response) 
			throws SQLException, UnsupportedEncodingException {
		Producto producto = new Producto(response.getString("codigoProducto"));
		producto.setNombreProducto(response.getString("nombreProducto"));
		producto.setCategoriaProducto(response.getString("categoriaProducto"));
		producto.setEscala(response.getString("escala"));
		producto.setVendedor(response.getString("vendedor"));
		producto.setDescripcion(response.getString("descripcion"));
		producto.setUnidadesStock(response.getShort("unidadesStock"));
		producto.setPrecioCompra(response.getFloat("precioCompra"));
		producto.setPrecioVenta(response.getFloat("precioVenta"));
		return producto;
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
				
				pdfProducto.add(getProducto(response));
			}

			respuesta = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	public void crearPdf() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("res/reportesPdf//ProductosPrecioVenta.pdf"));

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
	
	public void pdfVersionDos() {
		String nombreFichero= "ProductosVenta.pdf";
		String rutaFichero= "res/reportesPdf/"+nombreFichero;
		
		// Paso 1 : Crear de un Objeto DOCUMENT
		Document documento = new Document();
		
		try {
			/* Paso 2: Crear el Escritor (que es el archivo como tal, pero el es el que crea 
			 * 							  y escribe el fichero .pdf)
			*/
			PdfWriter writer = PdfWriter.getInstance(documento, 
					new FileOutputStream(rutaFichero));
			
			// Paso 3: Abrimos el documento
			documento.open();
			
			// Todo lo demas a partir de ahora es el añadir cosas al documento
			// Todo lo necesario para crearlo ya esta preparado. IMPORTANTE cerrar 
			// documento.close() al acabar
			
			// ------- Poner cosas que se necesiten ------------
			Phrase p = new Phrase("Hola Hola",FontsStyles.BLUEFONT);
			documento.add(p);
			
			
			// ULTIMO Paso IMPORTANTE: Cerrar el documento.
			documento.close();
			
			mensajePdfSuccess(true, nombreFichero);
		} catch (FileNotFoundException e) {
			mensajePdfSuccess(false, nombreFichero);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	private void mensajePdfSuccess(boolean estado, String nombreFichero ) {
		
		if(estado)
			System.out.println("Pdf creado con exito");
		else
			System.err.println("No se pudo crear el pdf, problemas comunes:"+
								"\n1) Si el fichero '"+nombreFichero+" ya existia,"+
								" asegurese de que no este abierto por otro programa"+
								"\n2) La ruta elegida no exsite");
		
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
