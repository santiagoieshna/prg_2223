package pdfreport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import envglobales.FontStyleReport;

public class PdfReport {
	private Document documento;
	private FileOutputStream fos;
	private String nombreFichero;
	private PdfPTable tablaCustom;
	
	public PdfReport(String nombreFichero) throws FileNotFoundException, DocumentException {
		super();
		this.documento = new Document(PageSize.A4, 35, 30, 50, 50);
		
		this.nombreFichero = nombreFichero;
//		String ruta = System.getProperty("user.home");
		String ruta = "";
		
		this.fos = new FileOutputStream(ruta+nombreFichero);
		// Metoddo ded Clase que nos dice donde se creara y que se creara.
		PdfWriter.getInstance(documento, fos);
		
	}
	
	public void abrirDocumento() {
		this.documento.open();
	}
	public void cerrarDocumento() {
		this.documento.close();
	}
	
	public void agregarTitulo(String texto) throws DocumentException {
		
		PdfPTable tabla = new PdfPTable(1);
		
		PdfPCell celda = new PdfPCell(new Phrase(texto, FontStyleReport.CHAPTER_FONT));
		celda.setColspan(5); // Darle mas grosor a la celda ?
		celda.setBorderColor(BaseColor.WHITE);
		tabla.addCell(celda);
		documento.add(tabla);
	}
	
	public void agregarParrafo(String texto) throws DocumentException {
		Paragraph parrafo = new Paragraph();
		parrafo.add(new Phrase(texto, FontStyleReport.PARAGRPH_FONT));
		documento.add(parrafo);
		
	}
	
	public void agregarSaltoLinea() throws DocumentException {
		Paragraph saltoLinea = new Paragraph();
		saltoLinea.add(new Phrase(Chunk.NEWLINE));
		saltoLinea.add(new Phrase(Chunk.NEWLINE));
		documento.add(saltoLinea);
	}
	
	public void abrirTabla(int numColumns) {
		if(this.tablaCustom == null)
		 this.tablaCustom = new PdfPTable(numColumns);
		
	}
	
	public void addCellToTabla(String texto) {
		this.tablaCustom.addCell(texto);
	}
	
	public void insertarTabla() throws DocumentException {
		this.documento.add(this.tablaCustom);
		this.tablaCustom = null;
	}
	
	public void borrarTabla() {
		this.tablaCustom = null;
	}
	
	public String getNombreFichero() {
		return nombreFichero;
	}

	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}
	
	
	
	
	
}
