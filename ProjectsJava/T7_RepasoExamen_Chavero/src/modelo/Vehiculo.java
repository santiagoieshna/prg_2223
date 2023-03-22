package modelo;

public abstract class Vehiculo {

	private String matricula;
	private String modelo;
	private int ruedas;
	
	public Vehiculo(String matricula, String modelo, int ruedas) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.ruedas = ruedas;
	}

	
	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getRuedas() {
		return ruedas;
	}


	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}


	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", modelo=" + modelo + ", ruedas=" + ruedas + "]";
	}
	
	
}
