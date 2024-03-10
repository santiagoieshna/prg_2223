package polimorfismo;

public class Deportista extends Persona {

	private String equipo;
	
	
	public Deportista(String nombre, String dni, String equipo) {
		super(nombre, dni);
		this.equipo = equipo;
	}


	@Override
	public String correr() {
		
		return "Corro Rapido";
	}

}
