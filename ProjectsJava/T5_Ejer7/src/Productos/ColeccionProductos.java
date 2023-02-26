package Productos;
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
	private int buscarProducto(int id) {
		for(int i=0 ; i<productos.length;i++) {
			if(productos[i].getIdproducto()==id) {
				return i;
			}	
		}
		return -1;
	}
	
	public void consultarProductosPorPaisOrigen(String country) {
		
		
	}
	
	
	
}
