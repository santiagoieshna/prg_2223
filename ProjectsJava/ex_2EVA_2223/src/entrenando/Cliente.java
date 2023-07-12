package entrenando;

public class Cliente extends Persona implements humano{
	private String direccion;
	private String telefono;

	public Cliente() {
		super();
	}

	public Cliente(String direccion, String telefono, String id, String nombre) {
		super(id , nombre);
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String obetenerId() {
		
		return super.getId();
	}

	@Override
	public String obtenerNombre() {
		return super.getNombre();
	}


}
