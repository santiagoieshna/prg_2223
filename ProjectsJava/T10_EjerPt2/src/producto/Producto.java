package producto;

import java.util.Objects;

public class Producto {
	private String codigoProducto;
	private String nombreProducto;
	private String cateogriaProducto;
	private String escala;
	private String vendedor;
	private String descripcion;
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
	public Producto(String codigoProducto, String nombreProducto, String cateogriaProducto,
			String escala, String vendedor, String descripcion, Short unidadesStock,
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
	public Producto(String codigoProducto, String nombreProducto,
			String escala, String vendedor, String descripcion, Short unidadesStock,
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
	
	public String getNombreProducto() {
		return nombreProducto;
	}



	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}



	public String getCateogriaProducto() {
		return cateogriaProducto;
	}



	public void setCateogriaProducto(String cateogriaProducto) {
		this.cateogriaProducto = cateogriaProducto;
	}



	public String getEscala() {
		return escala;
	}



	public void setEscala(String escala) {
		this.escala = escala;
	}



	public String getVendedor() {
		return vendedor;
	}



	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
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
