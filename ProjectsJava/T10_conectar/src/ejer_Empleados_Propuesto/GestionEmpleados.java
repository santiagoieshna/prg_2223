package ejer_Empleados_Propuesto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestionEmpleados implements GestionEmpleadable {
	private List<Empleado> empleados;
	private Connection conexion;
	private Statement st;
	private PreparedStatement pSt;
	
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
		return pSt;
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
	
	public boolean createEmpleado(Empleado employer) {
		
		
		return false;
		
	}

	
}
