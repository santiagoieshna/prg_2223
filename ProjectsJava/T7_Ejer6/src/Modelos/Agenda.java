package Modelos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Agenda implements GestionAgenda{
	
//	ArrayList<Contacto> contactoAgenda;
	Set<Contacto> agenda;
	
	
	public Agenda() {
	super();
	this.agenda = new HashSet<Contacto>();
	}
	

	@Override
	public boolean addContacto(String nombre) {
		if(nombre!=null) {
			return this.agenda.add(new Contacto(nombre));
		}
		return false;	
	}
	
	@Override
	public void guardarTelefono(String nombre, String telefono) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarCorreo(String nombre, String telefono) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarTelefono(String nombre, String telefono) {
		
		Iterator contactos = agenda.iterator();
		while(contactos.hasNext()){
			Contacto contacto = (Contacto) contactos.next();
			if(contacto.getNombre().equals(nombre)) {
				
				int telefonoPos = contacto.getTelefono().indexOf(telefono);
				
				if(telefonoPos!=-1) {
					contacto.getTelefono().remove(telefonoPos);
				}
			}
		}
		
	}

	@Override
	public void borrarEmail(String nombre, String email) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteContacto(String nombre) {
		Iterator contactos = agenda.iterator();
		
		while (contactos.hasNext()) {
			Contacto contacto= (Contacto) contactos.next();
			
			if(contacto.getNombre().equalsIgnoreCase(nombre)) {
				contactos.remove();
			}
		}
		
	}

	@Override
	public ArrayList<String> buscarTelefono(String nombre) {
		for (Contacto contacto : agenda) {
			
			if(contacto.getNombre().equalsIgnoreCase(nombre)) {
				return contacto.getTelefono();
			}
			
		}
		return null;
	}

	@Override
	public ArrayList<String> buscarEmail(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public void mostarContactos() {
		agenda.forEach(contacto ->{
			System.out.println(contacto.toString());
		});
	}
}
