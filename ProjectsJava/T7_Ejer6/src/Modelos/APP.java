package Modelos;

public class APP {
	public static void main(String[] args) {
		
		Agenda agenda=new Agenda();
		
		agenda.addContacto("manolo");
		agenda.addContacto("juan");
		agenda.addContacto("maria");
		agenda.addContacto("maria");
		agenda.addContacto("manolo");
		
		agenda.mostarContactos();
//		switch (key) {
//		case value: {
//			
//			yield type;
//		}
//		default:
//			throw new IllegalArgumentException("Unexpected value: " + key);
//		}
		
	}
}
