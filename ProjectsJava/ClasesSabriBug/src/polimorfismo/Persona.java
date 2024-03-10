package polimorfismo;

public abstract class Persona {

	private String nombre;
	private String dni;
	
	public Persona(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	};
	
	public abstract String correr();


	
}
