package programa;

public class Programa {
	
	private String nombre;
	private String version;
	private String funcion;
	private String anyoLanzamiento;
	private String empresaDev;
	private String licencia;
	private double precio;
	
	public Programa() {
		this.nombre = "";
		this.version = "";
		this.funcion = "";
		this.anyoLanzamiento = "";
		this.empresaDev="";
		this.licencia = "";
		this.precio = 0.0;
	}
	
	
	public Programa(String nombre, String version, String funcion, String anyoLanzamiento, String empresaDev,
			String licencia, double precio) {
		super();
		this.nombre = nombre;
		this.version = version;
		this.funcion = funcion;
		this.anyoLanzamiento = anyoLanzamiento;
		this.empresaDev = empresaDev;
		this.licencia = licencia;
		this.precio = precio;
	}
	
	
	
	public Programa (Programa s) {
		super();
		this.nombre = s.getNombre();
		this.version = s.getVersion();
		this.funcion = s.getFuncion();
		this.anyoLanzamiento = s.getAnyoLanzamiento();
		this.empresaDev = s.getAnyoLanzamiento();
		this.licencia = s.getLicencia();
		this.precio = s.getPrecio();
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getFuncion() {
		return funcion;
	}
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	public String getAnyoLanzamiento() {
		return anyoLanzamiento;
	}
	public void setAnyoLanzamiento(String anyoLanzamiento) {
		this.anyoLanzamiento = anyoLanzamiento;
	}
	public String getEmpresaDev() {
		return empresaDev;
	}
	public void setEmpresaDev(String empresaDev) {
		this.empresaDev = empresaDev;
	}
	public String getLicencia() {
		return licencia;
	}
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
	
	
}
