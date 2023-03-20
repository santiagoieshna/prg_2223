package principal;

import java.util.ArrayList;

import modelo.Coche;
import modelo.GestionVehiculos;

public class Main {

	public static void main(String[] args) {
		
		GestionVehiculos gest = new GestionVehiculos();
		Coche coche1 = new Coche("AB1234CD", "Ford Fiesta", 4, 5, false);
		Coche coche2 = new Coche("BC2345DE", "Volkswagen Golf", 4, 8, true);
		Coche coche3 = new Coche("CD3456EF", "Toyota Corolla", 4, 9, false);
		Coche coche4 = new Coche("DE4567FG", "Honda Civic", 4, 5, true);
		Coche coche5 = new Coche("EF5678GH", "Chevrolet Cruze", 4, 4, false);
		Coche coche6 = new Coche("FG6789HI", "Kia Forte", 4, 4, true);
		Coche coche7 = new Coche("GH7890IJ", "Mazda 3", 4, 4, false);
		Coche coche8 = new Coche("HI8901JK", "Subaru Impreza", 4, 35, true);
		Coche coche9 = new Coche("IJ9012KL", "Audi A4", 4, 4, false);
		Coche coche10 = new Coche("KL0123LM", "BMW 3 Series", 4, 1, true);
		Coche coche11 = new Coche("LM1234MN", "Mercedes-Benz C-Class", 4, -5, false);
		Coche coche12 = new Coche("MN2345NO", "Lexus IS", 4, 0, true);
		Coche coche13 = new Coche("NO3456OP", "Tesla Model 3", 4, 9, false);
		Coche coche14 = new Coche("OP4567PQ", "Nissan Leaf", 4, 12, true);
		Coche coche15 = new Coche("PQ5678QR", "Hyundai Ioniq", 4, 5,true);
		
		gest.addCoche(coche1);
		gest.addCoche(coche2);
		gest.addCoche(coche3);
		gest.addCoche(coche4);
		gest.addCoche(coche5);
		gest.addCoche(coche6);
		gest.addCoche(coche7);
		gest.addCoche(coche8);
		gest.addCoche(coche9);
		gest.addCoche(coche10);
		gest.addCoche(coche11);
		gest.addCoche(coche12);
		gest.addCoche(coche13);
		gest.addCoche(coche14);
		gest.addCoche(coche15);
		
		gest.sortCochesListj();
		System.out.println(gest.toString());
//		ArrayList<Coche> alquilados = gest.showCochesAlquilados();
//		System.out.println(alquilados);

		
	}

}
