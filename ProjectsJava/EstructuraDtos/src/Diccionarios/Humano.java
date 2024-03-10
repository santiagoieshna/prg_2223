package Diccionarios;

public class Humano implements SevenDeadlySins{
	private String nombre;
	private String raza;
	private Integer edad;
	private Integer poderMagico;
	private String equipo;
	private Boolean vivo;

	public Humano(String nombre, String raza, Integer edad, Integer poderMagico, String equipo) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.poderMagico = poderMagico;
		this.equipo = equipo;
		this.vivo = true;
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
		return this.poderMagico;
	}

	@Override
	public Integer getEdad() {
		return this.edad;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Boolean getVivo() {
		return vivo;
	}

	@Override
	public String toString() {
		return "Humano [nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", poderMagico=" + poderMagico
				+ ", equipo=" + equipo + ", vivo=" + vivo + "]";
	}
	

}
