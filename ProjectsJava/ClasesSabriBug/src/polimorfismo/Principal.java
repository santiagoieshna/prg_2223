package polimorfismo;

public class Principal {
	public static void main(String[] args) {
		Persona personaUno = new Ingeniero("Pedro", "1234567", "Aeronautico");
		
		System.out.println(personaUno.correr());
//		System.out.println(personaUno.calcular());
		System.out.println(((Ingeniero)personaUno).calcular());
	}
}
