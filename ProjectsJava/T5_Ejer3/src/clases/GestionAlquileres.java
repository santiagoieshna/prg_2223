package clases;

import java.time.LocalDate;
import java.util.Iterator;

public class GestionAlquileres {
	private VehiculoAlquilado [] alquilados = new VehiculoAlquilado[7];

	public GestionAlquileres() {
		alquilados[0] = new VehiculoAlquilado(new Cliente(1, "Ana" ,"Robles Paz"), 
				new Vehiculo("1200-BMC", "Seat", "Ibiza",20, true),
				LocalDate.now(), 5);
		alquilados[1] = new VehiculoAlquilado(new Cliente(2, "Luis" ,"Santo Paz"), 
				new Vehiculo("1111-BMC", "Renault", "Clio",25, true),
				LocalDate.now(), 1);
		alquilados[2] = new VehiculoAlquilado(new Cliente(3, "Gema" ,"D�az Paz"), 
				new Vehiculo("1233-BMC", "Seat", "Ibiza",20, true),
				LocalDate.now(), 9);
		alquilados[3] = new VehiculoAlquilado(new Cliente(4, "Tom�s" ,"Sanz Eno"), 
				new Vehiculo("1290-BMC", "Volvo", "XC90", 120, true),
				LocalDate.now(), 11);
		alquilados[4] = new VehiculoAlquilado(new Cliente(5, "Eva" ,"Cansino Roble"), 
				new Vehiculo("9090-BMC", "Volkswagen", "Golf", 34, true),
				LocalDate.now(), 10);
		alquilados[5] = new VehiculoAlquilado(new Cliente(5, "Eva" ,"Cansino Roble"), 
				new Vehiculo("9091-BMC", "Volkswagen", "Passat", 54, true),
				LocalDate.of(2021, 1, 14), 10);
		alquilados[6] = new VehiculoAlquilado(new Cliente(5, "Eva" ,"Cansino Roble"), 
				new Vehiculo("1200-BMC", "Seat", "Ibiza",20, true),
				LocalDate.of(2021, 01, 1), 10);
	}
	
	/**
	 * Metodo que busca un cliente por la matricula de un vehiculo
	 * @param matricula
	 * @return El objeto cliente si la matricula coincide
	 * 			objeto cliente NULL si la matricula no coincide
	 */
	public Cliente getClienteAlquiler(String matricula) {
		Cliente client = null;
		for (VehiculoAlquilado alquilado : alquilados) {
			if(alquilado.getVehiculo().getMatricula().equals(matricula)) {
				client = alquilado.getCliente();
			}
		}
		return client;
	}
	
	public int contarAlquileresCliente(int idCliente) {
		int cont = 0;
		for (VehiculoAlquilado alquiler:this.alquilados) {
			if(alquiler.getCliente().getId() == idCliente) {
				cont ++;
			}
		}
		return cont;
	}
	
	public double sumaImporteTodosAlquileres() {
		double suma=0;
		for(VehiculoAlquilado alquilado : this.alquilados) {
			suma+=alquilado.getVehiculo().getTarifa();
		}
		return suma;
	}
	
	
	public void mostrarAlquileresMatricula(String matricula) {
		for (VehiculoAlquilado alquilado : alquilados) {
			if(alquilado.getVehiculo().getMatricula().equals(matricula)) {
				System.out.println(alquilado.getVehiculo().toString());
				System.out.println(alquilado.getCliente().toString());
			}
		}
	}
	
}
