package ejer_Empleados_Propuesto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


/**
 * 
 * @author xtalo
 *
 *  Ejercicio Propuesto, tabla empleados de la bd classicmodels
 *  
 *  1) Dar alta alos empleados
 *  2) Modificar correo de empleado (pedir id)
 *     mostrar correo actual, pedir nuevo y actualizar
 *  3) Eliminar empleado (Pedir id)
 *     mostrar sus datos, pedir confirmacion para eliminar
 *  4) Mostrar nombres de todos los empleados.
 *  5) Pedir un nombre departamento y guardar en un fichero .txt
 *     los empleados de ese dpto.
 *     Cada registro será una linea del archivo, termina en ';'
 *
 */
public class GestionEmpleados implements GestionEmpleadable {
	private List<Empleado> empleados;
	private Connection conexion;
	private Statement st;
	private PreparedStatement sentencia;
	
	public GestionEmpleados( Connection conexion) {
		super();
		this.empleados = new ArrayList<>();
		try {
			this.conexion = conexion;
			this.st = conexion.createStatement();
			cargarEmpleados();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public boolean updateGmail(String newGmail, Empleado empleado) {
		boolean respuesta = false;
		String query = "Update empleados SET email=? where numeroempleado=?";
		try {
			
			sentencia = getConexion().prepareStatement(query);
			sentencia.setString(1, newGmail);
			sentencia.setString(2, empleado.getNumeroEmpleado());
			sentencia.executeUpdate();
			sentencia.close();
			respuesta=true;
			cargarEmpleados();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("\nError no contemplado en actualizar Email");
		}
		return respuesta;
	}

	@Override
	public boolean deleteEmpleado(String id) {
		boolean respuesta = false;
		Empleado empleado = getEmpleado(id);
		if(empleado != null) {
			if(confirmarEliminarEmpleado(empleado)) {
				if(deleteItemByID(empleado)) {
					respuesta = true;
				}
			}
		}
		return respuesta;
	}


	private boolean deleteItemByID(Empleado empleado) {
		boolean respuesta = false;
		String query = "Delete from empleados where numeroEmpleado=?";
		try {
			sentencia = getConexion().prepareStatement(query);
			sentencia.setString(1, empleado.getNumeroEmpleado());
			sentencia.executeUpdate();
			sentencia.close();
			respuesta = true;
			EliminarEmpleadoList(empleado);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return respuesta;
	}


	private void EliminarEmpleadoList(Empleado empleado) {
		Iterator empleadosIterator= this.empleados.iterator();
		while(empleadosIterator.hasNext()) {
			Empleado empleadoActual = (Empleado) empleadosIterator.next();
			if (empleadoActual.getNumeroEmpleado().equals(empleado.getNumeroEmpleado())) {
				empleadosIterator.remove();
			}
		}
		
	}


	private boolean confirmarEliminarEmpleado(Empleado empleado) {
		String eliminar="";
		System.out.println("Datos de "+empleado.getNumeroEmpleado());
		System.out.println(empleado.toString());
		System.out.println("\nQuieres eliminar este empleado (s/n)");
		eliminar = new Scanner(System.in).next();
		if (eliminar.equalsIgnoreCase("s") || eliminar.equalsIgnoreCase("si")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean showAllEmpleados() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveEmpleadosDept(String numDepartamento) {
		boolean respuesta = false;
		List<Empleado> EmpleadosDepartamento = empleadosPorDepartamento(numDepartamento);
		if(crearFicheroDepartamento(EmpleadosDepartamento, numDepartamento)) {
			respuesta=true;
		}
		
		return respuesta;
	}

	private boolean crearFicheroDepartamento(List<Empleado> empleadosDepartamento, String numDepartamento) {
		boolean respuesta = false;
		String nombreArchivo = "res/Departamento"+numDepartamento+".txt";
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));
			
			for (Empleado empleado : empleadosDepartamento) {
				StringBuilder formatEmpleado = new StringBuilder();
				formatEmpleado.append(empleado.getNumeroEmpleado()+":");
				formatEmpleado.append(empleado.getApellido()+":");
				formatEmpleado.append(empleado.getNombre()+":");
				formatEmpleado.append(empleado.getExtension()+":");
				formatEmpleado.append(empleado.getEmail()+":");
				formatEmpleado.append(empleado.getCodigoOficina()+":");
				formatEmpleado.append(empleado.getJefedirecto()+":");
				formatEmpleado.append(empleado.getPuestoTrabajo()+";");
				escritor.write(formatEmpleado.toString());
				escritor.newLine();
			}
			escritor.close();
			respuesta = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}


	private List<Empleado> empleadosPorDepartamento(String numDepartamento) {
		List<Empleado> EmpleadosDepartamento = new ArrayList<>();
		String query = "SELECT * FROM empleados WHERE codigoOficina=?";
		try {
			sentencia = getConexion().prepareStatement(query);
			sentencia.setString(1, numDepartamento);
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				Empleado empleado = new Empleado(rs.getString("numeroEmpleado"));
				empleado.setApellido(rs.getString("apellido"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setExtension(rs.getString("extension"));
				empleado.setEmail(rs.getString("email"));
				empleado.setCodigoOficina(rs.getString("codigoOficina"));
				empleado.setJefedirecto(rs.getString("jefeDirecto"));
				empleado.setPuestoTrabajo(rs.getString("puestoTrabajo"));
				//Aniadimos a la Lista
				EmpleadosDepartamento.add(empleado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return EmpleadosDepartamento;
	}


	@Override
	public boolean cargarEmpleados() {
		boolean respuesta=false;
		empleados=new ArrayList<>();
		String query = "Select * from empleados";
		ResultSet rs;
		
		try {
			rs = st.executeQuery(query);
			while(rs.next()) {
				Empleado empleado= new Empleado(rs.getString("numeroEmpleado"));
				empleado.setApellido(rs.getString("apellido"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setExtension(rs.getString("extension"));
				empleado.setEmail(rs.getString("email"));
				empleado.setCodigoOficina(rs.getString("codigoOficina"));
				empleado.setJefedirecto(rs.getString("jefeDirecto"));
				empleado.setPuestoTrabajo(rs.getString("puestoTrabajo"));
				//Aniadimos a la Lista
				empleados.add(empleado);
			}
			respuesta=true;
		} catch (SQLException e) {
			respuesta=false;			
			e.printStackTrace();
		}catch (Exception e) {
			respuesta=false;			
			e.printStackTrace();
		}
		return respuesta;
	}
	

	public Connection getConexion() {
		return conexion;
	}


	public void setConexion(Connection conexion) {
		this.conexion = conexion;
		try {
			this.st = conexion.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public PreparedStatement getSentencia() {
		return sentencia;
	}


	@Override
	public Empleado getEmpleado(String idEmpleado) {
		for (Empleado empleado : empleados) {
			if(empleado.getNumeroEmpleado().equals(idEmpleado)) {
				return empleado;
			}
		}
		return null;
	}


	@Override
	public void printAllEmpleados() {
		
		for (Empleado empleado : empleados) {
			System.out.println(empleado.toString());
		}
		
	}


	public void printNames() {
		for (Empleado empleado : empleados) {
			System.out.println(empleado.getNombre()+" "+empleado.getApellido());
		}
		
	}
	
	public boolean createEmpleado() {
		boolean respuesta=false;
		String query = "Insert into empleados (numeroEmpleado, apellido, nombre, extension, email,"
						+"codigoOficina, puestoTrabajo) Values (?,?,?,?,?,?,?)";
		Empleado employer = pedirDatosEmpleado();
		try {
			sentencia = this.getConexion().prepareStatement(query);
			sentencia.setString(1, employer.getNumeroEmpleado());
			sentencia.setString(2, employer.getApellido());
			sentencia.setString(3, employer.getNombre());
			sentencia.setString(4, employer.getExtension());
			sentencia.setString(5, employer.getEmail());
			sentencia.setString(6, employer.getCodigoOficina());
			sentencia.setString(7, employer.getPuestoTrabajo());
			sentencia.executeUpdate();
			sentencia.close();
			respuesta=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
		
	}


	private Empleado pedirDatosEmpleado() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserte el codigo de empleado: ");
		Empleado empleado = new Empleado(sc.nextLine());
		System.out.print("Inserte el nombre: ");
		empleado.setNombre(sc.nextLine());
		System.out.print("Inserte el apellido: ");
		empleado.setApellido(sc.nextLine());
		System.out.print("Inserte la extension: ");
		empleado.setExtension(sc.next());
		System.out.print("Inserte el codigo de oficina: ");
		empleado.setCodigoOficina(sc.next());
		System.out.print("Inserte el puesto de trabajo: ");
		sc.nextLine();
		empleado.setPuestoTrabajo(sc.nextLine());
		System.out.print("Inserte el Email: ");
		empleado.setEmail(sc.next());
		return empleado;
	}


	
}
