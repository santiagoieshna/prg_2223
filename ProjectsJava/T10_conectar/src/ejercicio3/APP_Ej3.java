package ejercicio3;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import conector.ConectarBD;

public class APP_Ej3 {
	public static void main(String[] args) {
		Scanner scaner=new Scanner(System.in);
		String url, nombre, pass;
		Properties acceso = new Properties(2);//Datos de autentificacion para conectar la BD
		Connection con;//Conexion de la BD, Se la pasaremos al GestionProductos
		GestionProductos gest;// Controller de productos de la BD
		Integer opcionMenu = 0;//Opcion delmenu elegida por usuario
		boolean okey=false;// Testigo de las operaciones
		
		url = "jdbc:mysql://localhost:3306/classicmodels";
		nombre = "santiago";
		pass = "123456";
		acceso.put("user", nombre);
		acceso.put("password", pass);

		try {
			gest = new GestionProductos(ConectarBD.getConexion(url, acceso));
			
			// MENU
			do {
				enunciadoMenu();
				opcionMenu= scaner.nextInt();
				Producto producto=null;
				switch (opcionMenu) {
				case 1: {
					okey = gest.cargarProductos();
					if(okey)
						System.out.println("Cargado correctamente");
					else
						System.out.println("Ocurrio un problema al cargar");
					break;
				}
				case 2: {
					if(!gest.isEmpty())// se cargara por defecto.. asique no hace falta
						gest.showAllProdcutos();
					else
						System.out.println("no hay datos cargados...");
					break;
				}
				case 3: {
					System.out.print("Introduzca el id del producto: ");
					producto= gest.getProducto(scaner.next());
					if(producto!=null) {
						gest.showProducto(producto);		
					}else {
						System.out.println("El producto con esa ID no existe");
					}
					break;
				}
				case 4: {
					producto = crearProducto();
					if(gest.addProductos(producto)) {
						System.out.println("Producto registrdo correctmente");
					}else {
						System.out.println("no se puedo introducir el Producto");
					}
					break;
				}
				case 5: {
					if(gest.updatePriceSell()) {
						System.out.println("Precio Venta modificado correctamente");
					}else {
						System.out.println("no se pudo modificar los precios de venta");
					}
					break;
				}
				case 6: {
					if(gest.updatePriceSellFacil()) {
						gest.cargarProductos();//El metodo no modifica el HasSet
						System.out.println("Precio actualizado");
					}else {
						System.out.println("no se pudo modificar los precios de venta");
					}
					break;
				}
				case 7: {
					System.out.println("Inserte el porcentaje: ");
					if(gest.updatePriceSell(scaner.nextFloat())) {
						System.out.println("Precio Venta modificado correctamente");
					}else {
						System.out.println("no se pudo modificar los precios de venta");
					}
					break;
				}
				case 8: {
					//Obtener Prodcuto
					System.out.print("Introduzca el id del producto: ");
					producto= gest.getProducto(scaner.next());
					if(producto!=null) {
						//Eliminar Prodcuto
						if(gest.deleteProducto(producto)) {
							System.out.println("Producto borrado correctamente");
						}else {
							System.out.println("No se pudo borrar el producto");
						}
					}else {
						System.out.println("El producto con esa ID no existe");
					}
					break;
				}
				case 9: {
					// No funciona
					System.out.print("\033[H\033[2J");
					System.out.flush();//Limpiar consola
					break;
				}
				case 10: {
					gest.desconectar();
					System.out.println("Saliendo del Programa...");
					break;
				}
				default:
					throw new IllegalArgumentException("Valor inesperado: " + opcionMenu);
				}
			} while (opcionMenu != 10);
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void enunciadoMenu() {
		System.out.println();
		StringBuilder enunciado = new StringBuilder("*********OPCIONES**********\n\n");
		enunciado.append("1) Cargar Productos\n");
		enunciado.append("2) Mostrar todos los Productos\n");
		enunciado.append("3) Mostrar un Producto por ID\n");
		enunciado.append("4) Add un Producto\n");
		enunciado.append("5) Modificar el precio de todos al 5%\n");
		enunciado.append("6) Modificar el precio de todos al 5% (Version Chavero)\n");
		enunciado.append("7) Modificar el precio de todos al % que insertes\n");
		enunciado.append("8) Eliminar Prodcuto por ID\n");
		enunciado.append("9) Limpiar consola\n");
		enunciado.append("10) Salir");
		System.out.println(enunciado);
		

	}

	public static Producto crearProducto() {
//		System.out.println("codigo");
//		StringBuilder codigoProducto = new StringBuilder("9_9118");
//		StringBuilder nombreProducto = new StringBuilder("Prueba Producto");
		StringBuilder cateogriaProducto = new StringBuilder("Motorcycles");
		StringBuilder escala = new StringBuilder("escalita");
		StringBuilder vendedor = new StringBuilder("Antonio Sanchez");
		StringBuilder descripcion = new StringBuilder("Describir");
		Short unidadesStock = 50;
//		Float precioCompra = 100f;
//		Float precioVenta = 200f;
//		Producto productoNuevo = new Producto(codigoProducto, nombreProducto, cateogriaProducto, escala, vendedor,
//				descripcion, unidadesStock, precioCompra, precioVenta);
		// Meter Por teclado
		System.out.print("codigo: ");
		Scanner sc=new Scanner(System.in);
		String codigoProducto=sc.nextLine();
		System.out.print("nombre: ");
		StringBuilder nombreProducto=new StringBuilder(sc.nextLine());
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
		System.out.print("Precio de Compra: ");
		Float precioCompra=Float.parseFloat(sc.nextLine());
		System.out.print("Precio de Venta: ");
		Float precioVenta=Float.parseFloat(sc.nextLine());
		Producto productoNuevo = new Producto(codigoProducto,nombreProducto,cateogriaProducto,escala,
				vendedor,descripcion,unidadesStock,precioCompra,precioVenta);
		System.out.println();
		return productoNuevo;
	}
}
