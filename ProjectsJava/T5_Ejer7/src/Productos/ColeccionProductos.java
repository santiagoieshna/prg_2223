package Productos;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;

import Productos.*;

public class ColeccionProductos {

	private Productos[] productos;

	public ColeccionProductos(Productos[] productos) {
		super();
		this.productos = productos;
	}

	/**
	 * 
	 * @param id
	 * @param temperatura
	 */
	public boolean modificarTemperaturaCongelacion(String id, double temperatura) {
		int indice = buscarProducto(id);
		boolean respuesta = false;
		if (indice != -1 && (productos[indice] instanceof Congelados)) {
			Congelados item = (Congelados) productos[indice];
//			(Congelados) productos[indice].set
			item.setTempRecomendada(temperatura);
			respuesta = true;
		}
		return respuesta;
	}

	/**
	 * 
	 * @param pais
	 * @return
	 */
	public Productos[] consultarProductosPorPaisOrigen(String pais) {
		Productos[] listaProductos = null;
		int size = getSize(pais);
		listaProductos = crearArray(size, pais);
		return listaProductos;
	}

	public Productos[] consultarProductosCaducados() {
		Productos[] arrayPro = null;
		LocalDate hoy = LocalDate.now();
		int size = getSize(hoy);

		if (size != 0) {
			arrayPro = new Productos[size];
			createArrayCaducados(arrayPro, size, hoy);

		}

		return arrayPro;
	}

	/**
	 * obtenerProductosDelTipo. Recibe como parámetro un tipo de producto (fresco,
	 * congelado o refrigerado) y devuelve un array con los productos de ese tipo.
	 * En el main crea un menú de opciones citadas y prográmalo. 
	 * @param tipo String que indica el tipo de producto a buscar
	 * @return lista de los productos del tipo pedido
	 * 			null si no encuentra ningun tipo o si el tipo no coincide
	 */
	public void obtenerProductosDelTipo(String tipo) {
		
		
	}

	/**
	 * Crea un aaray de los productos caducados
	 * 
	 * @param arrayPro
	 * @param size
	 * @param hoy
	 */
	private void createArrayCaducados(Productos[] arrayPro, int size, LocalDate hoy) {
		for (int i = 0; i < productos.length; i++) {
			if (productos[i].getFechaCaducidad().isBefore(hoy)) {
				arrayPro[i] = productos[i];
			}
		}
	}

	/**
	 * Devuelve el indice del array productos por su id
	 * 
	 * @param id
	 * @return -1 si no existe en el array el indice si existe
	 */
	public int buscarProducto(String id) {
		for (int i = 0; i < productos.length; i++) {
			if (productos[i].getIdproducto() == id) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Devuelve un array de Productos que coincidan con el pais de Origen
	 * 
	 * @param size
	 * @param pais
	 * @return array de Productos[] del pais de origen Null si size = 0
	 * 
	 */
	private Productos[] crearArray(int size, String pais) {
		Productos[] frescosLista = null;
		if (size != 0) {
			frescosLista = new Productos[size];
			int cont = 0;
			for (int i = 0; i < productos.length; i++) {
				if (productos[i] instanceof Frescos) {
					Frescos fresh = (Frescos) productos[i];
					if (fresh.getPaisOrigen().equals(pais)) {
						frescosLista[cont] = productos[i];
						cont++;
					}

				}
			}
		}
		return frescosLista;
	}

	/**
	 * Devuelve el numero de coincidencias con respecto a al parametro pais
	 * 
	 * @param pais
	 * @return
	 */
	private int getSize(String pais) {
		int cont = 0;

		for (Productos producto : productos) {
			if (producto instanceof Frescos) {
				producto = (Frescos) producto;
				if (((Frescos) producto).getPaisOrigen().equals(pais)) {
					cont++;
				}
			}
		}
		return cont;
	}

	private int getSize(LocalDate hoy) {
		int cont = 0;

		for (Productos producto : productos) {
			if (producto.getFechaCaducidad().isBefore(hoy)) {
				cont++;
			}
		}
		return 0;
	}

	/**
	 * Devuelve el numero de coincidencias con respecto a al parametro pais
	 * 
	 * @param pais
	 * @return
	 */
	private int getSizeTraditional(String pais) {
		int cont = 0;
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] instanceof Frescos) {
				Frescos pFresh = (Frescos) productos[i];
				if (pFresh.getPaisOrigen().equals(pais)) {
					cont++;
				}
			}
		}
		return cont;
	}

	public void showListaProductos() {
		for (Productos productos2 : productos) {
			System.out.println(productos2.toString() + "\n");

		}
	}

	public void showListaProductos(Productos[] listaPro) {
		for (Productos productos2 : listaPro) {
			System.out.println(productos2.toString() + "\n");

		}
	}

}
