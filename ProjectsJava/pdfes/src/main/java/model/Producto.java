package model;

public class Producto {
	private String codigoProducto;
	private String nombreProducto;
	private String categoriaProducto;
	private String escala;
	private String vendedor;
	private String descripcion;
	private Short unidadesStock;
	private Float precioCompra;
	private Float precioVenta;
	
	public Producto(String codigoProducto) {
		super();
		this.codigoProducto = codigoProducto;
		
	}
	public Producto(String codigoProducto, String nombreProducto, String categoriaProducto, String escala,
			String vendedor, String descripcion, Short unidadesStock, Float precioCompra, Float precioVenta) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.categoriaProducto = categoriaProducto;
		this.escala = escala;
		this.vendedor = vendedor;
		this.descripcion = descripcion;
		this.unidadesStock = unidadesStock;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
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
	public String getCategoriaProducto() {
		return categoriaProducto;
	}
	public  void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto=categoriaProducto ;
	}
	@Override
	public String toString() {
		return "Productos [codigoProducto=" + codigoProducto + ", nombreProducto=" + nombreProducto
				+ ", categoriaProducto=" + categoriaProducto + ", escala=" + escala + ", vendedor=" + vendedor
				+ ", descripcion=" + descripcion + ", unidadesStock=" + unidadesStock + ", precioCompra=" + precioCompra
				+ ", precioVenta=" + precioVenta + "]";
	}
	
	
}
