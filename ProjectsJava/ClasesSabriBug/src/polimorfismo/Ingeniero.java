package polimorfismo;

public class Ingeniero extends Persona {

	private String titulo;
	
	
	public Ingeniero(String nombre, String dni,String titulo) {
		super(nombre, dni);
		this.titulo = titulo;
	}

	public String calcular() {
		return "Calculo";
	}
	
	@Override
	public String correr() {
		return "Corro Lento";
	}

	
	
}
