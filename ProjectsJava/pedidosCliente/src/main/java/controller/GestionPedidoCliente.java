package controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.Cliente;
import model.DetallePedido;
import model.Pedido;

public class GestionPedidoCliente {
	private GestionClientes gestClientes;
	private GestionPedidos gestPedidos;
	private GestionProductos gestProductos;

	public GestionPedidoCliente() {
		super();

		gestClientes = new GestionClientes();
		gestPedidos = new GestionPedidos();
		gestProductos = new GestionProductos();

	}

	public void mostrarClientesCiudad(String Ciudad) {

		gestClientes.printListClientes(gestClientes.clienteByCiudad(Ciudad));
	}

	public void mostarTodosClientes() {
		gestClientes.printTodosClientes();
	}

	public void mostrarTodosPedidos() {
		gestPedidos.printPedidos();
	}

	public void mostrarLineasPedido(String idPedido) {
		gestPedidos.printLineasPedidoByID(idPedido);
	}

	public void addCliente(Cliente cliente) {
		gestClientes.guardarCliente(cliente);

	}

	/*
	 * Metodo que crea un archivo txt Return True si se genera False si ha ocurrido
	 * cualquier error en la creacion
	 */
	public boolean txtClientePedidoImporte() {
		boolean respuesta = false;
		String fileName = "res/ClientesPedidos.txt";
		String separador = ";";
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter(fileName));
			ArrayList<Cliente> clientes = gestClientes.getClientes();

			for (Cliente cliente : clientes) {
				escritor.write(cliente.getNumeroCliente() + separador);
				escritor.write(cliente.getNombre() + separador);
				escritor.write(gestPedidos.getPedidosByCliente(cliente.getNumeroCliente()).size() + separador);
				escritor.write(gestPedidos.importeTotalPedidosCliente(cliente.getNumeroCliente()).toString());
				escritor.newLine();
			}
			escritor.close();
			respuesta = true;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error no contemplado");
		}
		return respuesta;
	}

	public boolean mostrarPedidosCliente(String idCliente) {
		return gestPedidos.printPedidosCliente(idCliente);
	}

	public boolean pdfReportFactura(String idPedido, String idCliente) {
		boolean respuesta = false;
		Pedido pedido = gestPedidos.getPedidoById(idPedido);
		Cliente cliente = gestClientes.getCliente(idCliente);
		String nombreFichero = "res/Factura_" + idPedido + ".pdf";

		// Creacion PDF
		Document documento = new Document();
		try {
			PdfWriter.getInstance(documento, new FileOutputStream(nombreFichero));
			documento.open();
			
			// Tabla titulo
			PdfPTable tabla = new PdfPTable(6);
			
			// Cabecera Factura
			PdfPCell celda = new PdfPCell(new Phrase("Factura"));
			celda.setColspan(6);
			celda.setHorizontalAlignment(celda.ALIGN_CENTER);
			tabla.addCell(celda);
			
			tabla.addCell(new PdfPCell(new Phrase("ID")));
			tabla.addCell(new PdfPCell(new Phrase(pedido.getNumeroPedido())));
			tabla.addCell(new PdfPCell(new Phrase("Fecha de pedido")));
			tabla.addCell(new PdfPCell(new Phrase(pedido.getFechaPedido())));
			tabla.addCell(new PdfPCell(new Phrase("Fecha de entrega")));
			tabla.addCell(new PdfPCell(new Phrase(pedido.getFechaEntrega())));

			// Cabecera Cliente
			celda = new PdfPCell(new Phrase("Cliente"));
			celda.setColspan(6);
			celda.setHorizontalAlignment(celda.ALIGN_CENTER);
			tabla.addCell(celda);
			
			tabla.addCell(new PdfPCell(new Phrase("Nombre")));
			tabla.addCell(new PdfPCell(new Phrase(cliente.getNombre())));
			tabla.addCell(new PdfPCell(new Phrase("Ciudad")));
			tabla.addCell(new PdfPCell(new Phrase(cliente.getCiudad())));
			tabla.addCell(new PdfPCell(new Phrase("Direccion")));
			tabla.addCell(new PdfPCell(new Phrase(cliente.getDireccionLinea1())));
			
			

			documento.add(tabla);

			Phrase saltoLinea = new Phrase(new Chunk(Chunk.NEWLINE));
			documento.add(saltoLinea);
			
			//Tabla de las lineas del Pedido
			tabla = new PdfPTable(3);
			tabla.addCell(new PdfPCell(new Phrase("Producto")));
			tabla.addCell(new PdfPCell(new Phrase("Cantidad")));
			tabla.addCell(new PdfPCell(new Phrase("Precio Und.")));

			for (DetallePedido linea : pedido.getLineas()) {
				tabla.addCell(new PdfPCell(new Phrase(linea.getCodigoProducto())));
				tabla.addCell(new PdfPCell(new Phrase(linea.getCantidadPedida().toString())));
				tabla.addCell(new PdfPCell(new Phrase(linea.getPrecioUnidad().toString())));
			}
			
			celda = new PdfPCell(new Phrase("Total"));
			celda.setColspan(2);
			celda.setHorizontalAlignment(celda.ALIGN_RIGHT);
			tabla.addCell(celda);
			tabla.addCell(new Phrase(gestPedidos.getImportePedido(idPedido).toString()));
			
			documento.add(tabla);
			
			documento.close();
			respuesta = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	public void mostrarFactura(String idPedido) {
		gestPedidos.printLineasPedidoByID(idPedido);
		System.out.println("Importe Total: " + gestPedidos.getImportePedido(idPedido));
	}

}
