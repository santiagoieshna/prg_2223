package Modelos;

import java.util.ArrayList;

public interface GestionAgenda {

	
	public void guardarTelefono(String nombre, String telefono);
	public void guardarCorreo(String nombre, String telefono);
	
	public void borrarTelefono(String nombre, String telefono);
	public void borrarEmail(String nombre, String email);
	
	public boolean addContacto(String nombre);
	public void deleteContacto(String nombre);
	
	public ArrayList<String> buscarTelefono(String nombre);
	public ArrayList<String> buscarEmail(String nombre);
	
	
}
