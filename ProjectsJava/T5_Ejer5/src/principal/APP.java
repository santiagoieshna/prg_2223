package principal;
import vehiculo.*;
public class APP {

	public static void main(String[] args) {
		
		Vehiculo [] vehiculos = new Vehiculo[10];
		
		vehiculos[0] = new Turismo("1200-BMC","Seat", "Ibiza",23,true,5,true);
		vehiculos[1] = new Furgoneta("2208-ABA","Renault", "Toledo",23,true,45,45);
		vehiculos[2] = new Turismo("3456-CRM","Citroen", "C2",23,true,5,true);
		vehiculos[3] = new Furgoneta("1200-VMC","Mercedes", "Sprinter",23,true,49,72);
		vehiculos[4] = new Turismo("1205-AMA","Citroen", "C3",23,true,5,false);
		vehiculos[7] = new Turismo("1222-KCC","Seat", "Toledo",23,true,5,true);
		
		
		for (Vehiculo vehiculo : vehiculos) {
			showVehiculosType(vehiculo);
		}
		
	}
	public static void showVehiculosType(Vehiculo car) {
		if(car instanceof Turismo ) {
			System.out.println(car.toString()); 
		}else if(car instanceof Furgoneta) {
			System.out.println(car.toString());
		}
	}

}
