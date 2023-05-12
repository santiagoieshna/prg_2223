package ejercicio3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import conector.ConectarBD;

public class APP_Ej3 {
	public static void main(String[] args) {
		String url, nombre, pass;
		Properties acceso = new Properties(2);
		Connection con;
		Statement ejecutorSentencia;
		ResultSet respuesta;
		GestionProductos gest;
		url = "jdbc:mysql://localhost:3306/classicmodels";
		nombre = "santiago";
		pass = "123456";
		acceso.put("user", nombre);
		acceso.put("password", pass);

		Producto nuevoProducto = crearProducto();
		try {
			gest = new GestionProductos(ConectarBD.getConexion(url, acceso));
			boolean okey = gest.cargarProductos();
			System.out.println(okey);
			gest.showAllProdcutos();
			okey = gest.addProductos(nuevoProducto);
			System.out.println(okey);
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Producto crearProducto() {
		System.out.println("codigo");
		StringBuilder codigoProducto=new StringBuilder("9991");
		StringBuilder nombreProducto=new StringBuilder("Prueba Producto");
		StringBuilder cateogriaProducto=new StringBuilder("Prueba001");
		StringBuilder escala=new StringBuilder("escalita");
		StringBuilder vendedor=new StringBuilder("Antonio Sanchez");
		StringBuilder descripcion=new StringBuilder("Describir");
		Short unidadesStock=50;
		Float precioCompra=100f;
		Float precioVenta=200f;
		Producto productoNuevo = new Producto(codigoProducto,nombreProducto,cateogriaProducto,escala,
								vendedor,descripcion,unidadesStock,precioCompra,precioVenta);
		//Meter Por teclado
//		System.out.print("codigo: ");
//		Scanner sc=new Scanner(System.in);
//		StringBuilder codigoProducto=new StringBuilder(sc.nextLine());
//		System.out.print("nombre: ");
//		StringBuilder nombreProducto=new StringBuilder(sc.nextLine());
//		System.out.print("categoria: ");
//		StringBuilder cateogriaProducto=new StringBuilder(sc.nextLine());
//		System.out.print("escala: ");
//		StringBuilder escala=new StringBuilder(sc.nextLine());
//		System.out.print("vendeor: ");
//		StringBuilder vendedor=new StringBuilder(sc.nextLine());
//		System.out.print("descripcion: ");
//		StringBuilder descripcion=new StringBuilder(sc.nextLine());
//		System.out.print("Unds. Stock: ");
//		Short unidadesStock=Short.parseShort(sc.nextLine());
//		System.out.print("Precio de Compra: ");
//		Float precioCompra=Float.parseFloat(sc.nextLine());
//		System.out.print("Precio de Venta: ");
//		Float precioVenta=Float.parseFloat(sc.nextLine());
//		Producto productoNuevo = new Producto(codigoProducto,nombreProducto,cateogriaProducto,escala,
//				vendedor,descripcion,unidadesStock,precioCompra,precioVenta);
		
		return productoNuevo;
	}
}
