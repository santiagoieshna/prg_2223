package entrenando;

public abstract class Persona {
	private String id;
	private String nombre;

	public Persona(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Persona() {
		super();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	

}
