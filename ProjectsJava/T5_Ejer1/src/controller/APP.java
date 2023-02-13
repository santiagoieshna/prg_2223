package controller;

import java.time.LocalDate;

import modelo.Cliente;
import modelo.Vehiculo;
import modelo.VehiculoCleinte;

public class APP {

	public static void main(String[] args) {
		
		Cliente cli1 = new Cliente(123456,"Rangel");
		Vehiculo vhe1 = new Vehiculo("00000 KBY", "BMX", "Duster", 35.60, true);
		VehiculoCleinte vc1 = new VehiculoCleinte(cli1, vhe1, LocalDate.of(2023, 1, 12), 6);
		
		VehiculoCleinte vc2 = new VehiculoCleinte(
						new Cliente(23452123, "David Fueguito"),
						new Vehiculo("5445 FYA", "Renault", "Clio", 23.65, false),
						LocalDate.of(2023, 1, 12), 6);
		
	}

}
