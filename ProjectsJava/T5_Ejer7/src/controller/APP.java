package controller;
import java.time.LocalDate;
import java.util.Scanner;

import Productos.*;

public class APP {

	public static void main(String[] args) {
		
//		Productos item1 = new Congelados("1","Frutos secos",LocalDate.of(2018,10,30),"CON-01",-1.50);
		String menu="1) Ver Lista de productos\n2) Moificar Temperatura de Congelacion\n3) Consultar "+
				"productos por pais de origen\n4) Consultar Productos caducados\n5) Obtener producto del tipo"
				+ "\n6) Salir";
		
		
		ColeccionProductos coleccion = new ColeccionProductos(new PalabraObjectMother(20).getListaP());
		int opcion=0;
		String id,pais;
		Double temp;
		Scanner sc = new Scanner(System.in);
//		System.out.println(new PalabraObjectMother(10).toString());
//		System.out.println(productos[1].toString());
			
		do {
			System.out.println(menu);
			opcion = sc.nextInt();
			System.out.println();
			switch (opcion) {
			case 1:
				coleccion.showListaProductos();
				break;
			case 2:
				
				System.out.println("Introduzca el id del producto");
				id = sc.next();
				temp = sc.nextDouble();
				if(coleccion.modificarTemperaturaCongelacion(id, temp)) {
					System.out.println("Moificada con exito!");
				}else {
					System.out.println("No se puedo moificar");
				}
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				System.out.println("Hasta Otra");
				break;

			default:
				break;
			}
			
		}while(opcion!=6);
		
	}

}
