package solucion2;

import java.util.List;
import java.util.Map;

public class Diccionario {
	private String idioma;
	private Map<String, List<String>> terminos;
	
	public Diccionario() {
		super();
		
	}
	public Diccionario(String idioma, Map<String, List<String>> terminos) {
		super();
		this.idioma = idioma;
		this.terminos = terminos;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public Map<String, List<String>> getTerminos() {
		return terminos;
	}
	public void setTerminos(Map<String, List<String>> terminos) {
		this.terminos = terminos;
	}
	
	
}
