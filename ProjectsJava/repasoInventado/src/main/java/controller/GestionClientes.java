package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

import model.Cliente;
import pdfreport.PdfReport;
import repository.ClienteRepository;

public class GestionClientes {
	private ArrayList<Cliente> clientes;
	private ArrayList<Cliente> clienteFromDat;
	
	public GestionClientes() {
		super();
		this.clienteFromDat= new ArrayList<Cliente>();
		this.clientes = ClienteRepository.getClientes();
	}
	
	public void pdfByCiudad(String ciudad) {
//		ciudad= "Madrid";
		try {
			String nombreFichero =ciudad+".pdf";
			PdfReport reporte = new PdfReport(nombreFichero);
			
			reporte.abrirDocumento();
			reporte.agregarTitulo("Clientes por ciudad");
			reporte.agregarParrafo("Mi padre me pega");
			reporte.agregarSaltoLinea();
			
			reporte.abrirTabla(5);
			
			reporte.addCellToTabla("Codigo");
			reporte.addCellToTabla("Nombre");
			reporte.addCellToTabla("Telefono");
			reporte.addCellToTabla("Pais");
			reporte.addCellToTabla("Ciudad");
			
			for (Cliente cliente : clientes) {
				if(cliente.getCiudad().equalsIgnoreCase(ciudad)) {
					reporte.addCellToTabla(cliente.getNumeroCliente());
					reporte.addCellToTabla(cliente.getNombre());
					reporte.addCellToTabla(cliente.getTelefono());
					reporte.addCellToTabla(cliente.getPais());
					reporte.addCellToTabla(cliente.getCiudad());
				}
			}
			reporte.insertarTabla();
			reporte.cerrarDocumento();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveClienteDat() throws IOException {
		ObjectOutputStream mierda = new ObjectOutputStream(new FileOutputStream("Clientes.dat"));
		for (Cliente cliente : clientes) {
			mierda.writeObject(cliente);
		}
		// IMPORTANTE!!!!!!!!!!!!!!!!!!!
		mierda.close();
	}
	
	public void loadClienteDat() {
		
		ObjectInputStream papel;
		try {
			papel = new ObjectInputStream(new FileInputStream("Clientes.dat"));
			
			Cliente cliente = new Cliente();
			
			while((cliente = (Cliente) papel.readObject())!=null) {
				clienteFromDat.add(cliente);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("El archivo No existe o esta usado por otro programa");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Error en castear la Clase");
	
		}
		
	}

	public void mostrarDat() {
		for (Cliente cliente : clienteFromDat) {
			System.out.println(cliente.toString());
		}
	}
	
	
}
