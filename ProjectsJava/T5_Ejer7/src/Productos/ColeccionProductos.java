package Productos;
import java.util.Iterator;

import Productos.*;
public class ColeccionProductos {

	private Productos[] productos;
	
	/**
	 * 
	 * @param id
	 * @param temperatura
	 */
	public boolean modificarTemperaturaCongelacion(int id, double temperatura) {
		int indice = buscarProducto(id);
		boolean respuesta= false;
		if(id!=-1){
			Congelados item = (Congelados)productos[indice];
			item.setTempRecomendada(temperatura);
			respuesta =true;
		}
		return respuesta;
	}
	
	/**
	 * Devuelve el indice del array productos por su id
	 * @param id
	 * @return -1 si no existe en el array
	 * 			el indice si existe
	 */
	public int buscarProducto(int id) {
		for(int i=0 ; i<productos.length;i++) {
			if(productos[i].getIdproducto()==id) {
				return i;
			}	
		}
		return -1;
	}
	
	/**
	 * 
	 * @param pais
	 * @return
	 */
	public Productos[] consultarProductosCaducados(String pais){
		Productos[] listaProductos=null;
		int size = getSize(pais);
		crearArray(size, listaProductos, pais);
		return listaProductos;
	}
	
	public Productos[] consultarProductosCaducados() {
		Productos[] arrayPro = null;
		
		return arrayPro;
	}
	
	/**
	 * Crea un array de Productos
	 * @param size
	 * @param listaProductos
	 * @param pais
	 */
	private void crearArray(int size, Productos[] listaProductos , String pais) {
		Productos[] frescosLista = new Productos[size];
		int cont = 0;
		for (int i = 0; i < productos.length; i++) {
			if(productos[i] instanceof Frescos) {
				Frescos fresh = (Frescos) productos[i];
				if(fresh.getPaisOrigen().equals(pais)) {
					frescosLista[cont] = productos[i];
					cont ++;
				}
			}
		}
	}

	/**
	 * Devuelve el numero de coincidencias con respecto a al parametro pais
	 * @param pais
	 * @return
	 */
	private int getSize(String pais) {
		int cont=0;
		
		for (Productos producto : productos) {
			if(producto instanceof Frescos) {
				producto = (Frescos) producto;
				if(((Frescos) producto).getPaisOrigen().equals(pais)) {
					cont ++;
				}
			}
		}
		return cont;
	}

	/**
	 * Devuelve el numero de coincidencias con respecto a al parametro pais
	 * @param pais
	 * @return
	 */
	private int getSizeTraditional(String pais) {
		int cont=0;
		for (int i = 0; i < productos.length; i++) {
			if(productos[i] instanceof Frescos) {
				Frescos pFresh = (Frescos) productos[i];
				if(pFresh.getPaisOrigen().equals(pais)) {
					cont ++;
				}
			}
		}
		return cont;
	}
	
}
