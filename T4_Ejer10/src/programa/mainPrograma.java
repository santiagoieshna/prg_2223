package programa;
import programa.GestionPrograma;

public class mainPrograma {

	public static void main(String[] args) {
		
		String nombre ="Felipe";
		String version ="3.2";
		String funcion = "Ofimatica";
		String anyoLanzamiento = "2003";
		String licencia = "Apache 4.5";
		String empresaDev= "Ubisoft";
		double prize = 45;
		
		Programa prg = new Programa(nombre, version, funcion, anyoLanzamiento,empresaDev,licencia,prize);
		
		GestionPrograma.addPrograma(prg);
		System.out.println("Hola");
		GestionPrograma.filterLicencia(licencia);
		GestionPrograma.showContador();

	}

}
