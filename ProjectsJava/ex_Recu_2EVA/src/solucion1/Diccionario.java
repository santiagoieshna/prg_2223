package solucion1;

import java.util.Objects;
import java.util.Set;

public class Diccionario {

	private String idioma;
	private Set<Termino> terminos;

//	private Map<String, List<String>> hola;
	public Diccionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diccionario(String idioma, Set<Termino> terminos) {
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

	public Set<Termino> getTerminos() {
		return terminos;
	}

	public void setTerminos(Set<Termino> terminos) {
		this.terminos = terminos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idioma, terminos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diccionario other = (Diccionario) obj;
		return Objects.equals(idioma, other.idioma);
	}

}
