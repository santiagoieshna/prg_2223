package Diccionarios;

public class Gigante implements SevenDeadlySins{
	private String nombre;
	private String raza;
	private Integer edad;
	
	private String equipo;
	private Boolean vivo;
	private Integer vecesEntrenadas;
	
	
	public Gigante(String nombre, String raza, Integer edad,
			String equipo) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.equipo = equipo;
		this.vivo = true;
		this.vecesEntrenadas = 0;
	}
	@Override
	public String getRaza() {
		return this.raza;
	}
	@Override
	public String getEquipo() {
		return this.equipo;
	}
	@Override
	public Integer getPoderMagico() {
		return Integer.valueOf(String.valueOf((this.vecesEntrenadas*5+this.edad*0.5)));
	}
	@Override
	public Integer getEdad() {
		return this.edad;
	}
	
	@Override
	public String toString() {
		return "Gigante [nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", equipo=" + equipo + ", vivo="
				+ vivo + ", vecesEntrenadas=" + vecesEntrenadas + "]";
	}
		
	
}
