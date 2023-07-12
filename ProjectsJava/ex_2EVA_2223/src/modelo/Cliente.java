package modelo;

public class Cliente extends Persona implements humano{

	
	private String direccion;
	private String telefono;
	
	public Cliente( String nombre, String direccion, String telefono) {
		super( nombre);
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	
	@Override
	public int getId() {
		
		return super.getId();
	}

	@Override
	public String getNombre() {
		
		return super.getNombre();
	}
	

}
