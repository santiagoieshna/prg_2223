package modelo;

public class Coche extends Vehiculo{


	private int puertas;
	private boolean alquilado;
	
	/**
	 * 
	 * @param matricula
	 * @param modelo
	 * @param ruedas
	 * @param puertas
	 * @param alquilado
	 */
	public Coche(String matricula, String modelo, int ruedas, int puertas, boolean alquilado) {
		super(matricula, modelo, ruedas);
		this.puertas= puertas;
		this.alquilado=alquilado;
	}


	public int getPuertas() {
		return puertas;
	}


	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}


	public boolean isAlquilado() {
		return alquilado;
	}


	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}


	@Override
	public String toString() {
		
		return "Coche [puertas=" + puertas + ", alquilado=" + alquilado + ",\n toString()=" + super.toString() + "]";
	}
	
	
}
