package ejercicio3;

import java.util.Objects;

public class Producto {
	private String codigoProducto;
	private StringBuilder nombreProducto;
	private StringBuilder cateogriaProducto;
	private StringBuilder escala;
	private StringBuilder vendedor;
	private StringBuilder descripcion;
	private Short unidadesStock;
	private Float precioCompra;
	private Float precioVenta;
	
	public Producto() {
		super();	
	}
	public Producto(String codigoProducto) {
		super();
		this.codigoProducto = codigoProducto;
	}
	public Producto(String codigoProducto, StringBuilder nombreProducto, StringBuilder cateogriaProducto,
			StringBuilder escala, StringBuilder vendedor, StringBuilder descripcion, Short unidadesStock,
			Float precioCompra, Float precioVenta) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.cateogriaProducto = cateogriaProducto;
		this.escala = escala;
		this.vendedor = vendedor;
		this.descripcion = descripcion;
		this.unidadesStock = unidadesStock;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}
	
	/*
	 * categoriaProducto = NULL
	 */
	public Producto(String codigoProducto, StringBuilder nombreProducto,
			StringBuilder escala, StringBuilder vendedor, StringBuilder descripcion, Short unidadesStock,
			Float precioCompra, Float precioVenta) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.cateogriaProducto = null;
		this.escala = escala;
		this.vendedor = vendedor;
		this.descripcion = descripcion;
		this.unidadesStock = unidadesStock;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}
	
	
	@Override
	public String toString() {
		return "Producto [codigoProducto=" + codigoProducto + ", nombreProducto=" + nombreProducto
				+ ", cateogriaProducto=" + cateogriaProducto + ", escala=" + escala + ", vendedor=" + vendedor
				+ ", descripcion=" + descripcion + ", unidadesStock=" + unidadesStock + ", precioCompra=" + precioCompra
				+ ", precioVenta=" + precioVenta + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoProducto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codigoProducto, other.codigoProducto);
	}
	
	public StringBuilder getNombreProducto() {
		return nombreProducto;
	}



	public void setNombreProducto(StringBuilder nombreProducto) {
		this.nombreProducto = nombreProducto;
	}



	public StringBuilder getCateogriaProducto() {
		return cateogriaProducto;
	}



	public void setCateogriaProducto(StringBuilder cateogriaProducto) {
		this.cateogriaProducto = cateogriaProducto;
	}



	public StringBuilder getEscala() {
		return escala;
	}



	public void setEscala(StringBuilder escala) {
		this.escala = escala;
	}



	public StringBuilder getVendedor() {
		return vendedor;
	}



	public void setVendedor(StringBuilder vendedor) {
		this.vendedor = vendedor;
	}



	public StringBuilder getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(StringBuilder descripcion) {
		this.descripcion = descripcion;
	}



	public Short getUnidadesStock() {
		return unidadesStock;
	}



	public void setUnidadesStock(Short unidadesStock) {
		this.unidadesStock = unidadesStock;
	}



	public Float getPrecioCompra() {
		return precioCompra;
	}



	public void setPrecioCompra(Float precioCompra) {
		this.precioCompra = precioCompra;
	}



	public Float getPrecioVenta() {
		return precioVenta;
	}



	public void setPrecioVenta(Float precioVenta) {
		this.precioVenta = precioVenta;
	}



	public String getCodigoProducto() {
		return codigoProducto;
	}
	
	
	
}
