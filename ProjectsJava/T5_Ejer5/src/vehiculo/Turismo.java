package vehiculo;

public class Turismo extends Vehiculo {

	private int puertas;
	private boolean automatico;
	
	public Turismo(String matricula, String marca, String modelo, double tarifa, boolean disponible, int puertas,
			boolean automatico) {
		super(matricula, marca, modelo, tarifa, disponible);
		this.puertas = puertas;
		this.automatico = automatico;
	}

	public Turismo(String matricula, String marca, String modelo, double tarifa, boolean disponible) {
		super(matricula, marca, modelo, tarifa, disponible);
		
	}

//	public Turismo() {
//		DUDAS, No puedo crear un constructor vacio porque el padre no tiene constructor vacio ¿?
//	}
	
	public int getPuertas() {
		return puertas;
	}


	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public boolean isAutomatico() {
		return automatico;
	}

	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}
	
	@Override
	public String toString() {
		return "Turismo [puertas=" + puertas + ", automatico=" + automatico + "]";
	}
	
	
}
