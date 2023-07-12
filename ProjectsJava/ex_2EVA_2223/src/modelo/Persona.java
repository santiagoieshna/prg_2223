package modelo;

public abstract class Persona {

	private int id;
	private String nombre;
	private static int contId=0;
	
	public Persona( String nombre) {
		super();
		this.nombre = nombre;
		incremtarCont();
		this.id = contId;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	private static void incremtarCont() {
		contId ++;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
