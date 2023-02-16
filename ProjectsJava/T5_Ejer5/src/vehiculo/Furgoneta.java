package vehiculo;

public class Furgoneta extends Vehiculo {

	private int capacidad;
	private int cargaMax;
	
	public Furgoneta(String matricula, String marca, String modelo, double tarifa, boolean disponible, int capacidad,
			int cargaMax) {
		super(matricula, marca, modelo, tarifa, disponible);
		this.capacidad = capacidad;
		this.cargaMax = cargaMax;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCargaMax() {
		return cargaMax;
	}

	public void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	@Override
	public String toString() {
		return "Furgoneta [capacidad=" + capacidad + ", cargaMax=" + cargaMax + "]";
	}
	
	
}
