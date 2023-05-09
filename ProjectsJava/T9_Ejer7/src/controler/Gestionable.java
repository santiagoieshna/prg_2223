package controler;

import java.util.ArrayList;

import producto.Producto;

public interface Gestionable {

	public Producto getProducto(String id);
	public Integer getProductosVendidos(String anio);
	public ArrayList<Producto> ventasDeAnio(Integer anio);
	public boolean ventasDeAnioTxt(Integer anio);
}
