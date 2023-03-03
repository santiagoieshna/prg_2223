package controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

import Productos.*;


public class PalabraObjectMother {

//	Productos item1 = new Congelados("1", "Frutos secos", LocalDate.of(2018, 10, 30), "CON-01", -1.50);
	Productos[] listaP;

	public PalabraObjectMother(int numeroProductos) {
		listaP=new Productos[numeroProductos];
		
		for (int i = 0; i < listaP.length; i++) {
			String id= "0000" + i;
			String descripcion = "Producto-" + i;
			
			int anyo = new Random().nextInt(4)+2020;
			int mes = new Random().nextInt(11)+1;
			int dia = new Random().nextInt(28)+1;
			LocalDate fechaC = LocalDate.of(anyo, mes, dia);
			String lote = String.valueOf(123422*i);
			
			int tipo = (int) (Math.random()*3);
			
			switch (tipo) {
				case 0: 
				//Congelado
				double tempC = -5.0 * i;
				listaP[i] = new Congelados( id, descripcion, fechaC, lote,tempC);
				break;
				
				case 1:
				//Refrigerado
				String codigo = "ABC-"+i;
				listaP[i] = new Refrigerados( id, descripcion, fechaC, lote,codigo);
				break;
				
				case 2:
				//Fresco
				LocalDate fechaE = LocalDate.now();
				fechaE.minusDays(5);
				String [] paises = {"España", "Italia", "Marruecos", "Argelia", "Francia"};
				String paisO = paises[(int)(Math.random()*5)];
				listaP[i] = new Frescos( id, descripcion, fechaC, lote, fechaE, paisO);
			}
		}
	}

	public Productos[] getListaP() {
		return listaP;
	}

	@Override
	public String toString() {
		return  Arrays.toString(listaP);
	}
	
	
	
	
}

