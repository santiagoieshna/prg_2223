package ejer_Empleados_Propuesto;

import java.sql.SQLException;

public interface GestionEmpleadable {
	public boolean updateGmail(String newGmail, Empleado empleado);
	public boolean deleteEmpleado(String id);
	public boolean showAllEmpleados();
	/*
	 * Pedir un nombre de dpto y guarda en un fichero .txt
	 * los empleados de ese departamento.
	 * Cada registro es una linea y sus campos terminan en ';'
	 * Return True si se guardo el archivo, false si no se pudo
	 */
	public boolean saveEmpleadosDept(String numDepartamento);
	public boolean cargarEmpleados();
	public Empleado getEmpleado(String idEmpleado);
	public void printAllEmpleados();
	public boolean createEmpleado();
	
}
