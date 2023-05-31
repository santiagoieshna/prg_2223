package ejer_Empleados_Propuesto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.Query;
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
		this.conexion = conexion;
		try {
			this.st = conexion.createStatement();
			cargarEmpleados();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public boolean updateGmail(String newGmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmpleado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean showAllEmpleados() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveEmpleadosDept() {
		// TODO Auto-generated method stub
		return false;
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


	public PreparedStatement getpSt() {
		return sentencia;
	}


	public List<Empleado> getEmpleados() {
		return empleados;
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
			// TODO Auto-generated catch block
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
		empleado.setPuestoTrabajo(sc.nextLine());
		System.out.print("Inserte el Email: ");
		empleado.setEmail(sc.next());
		return empleado;
	}


	
}
