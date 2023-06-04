package model;

import java.io.Serializable;

public class Producto implements Serializable{
	private String codigoProducto;
	private String nombreProducto;
	private String categoriaProdcuto;
	private String escala;
	private String vendedor;
	private String descripcion;
	private String unidadesStock;
	private Float precioCompra;
	private Float precioVenta;

	public Producto() {
		super();

	}

	public Producto(String codigoProducto, String nombreProducto, String categoriaProdcuto, String escala,
			String vendedor, String descripcion, String unidadesStock, Float precioCompra, Float precioVenta) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.categoriaProdcuto = categoriaProdcuto;
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

	public String getCategoriaProdcuto() {
		return categoriaProdcuto;
	}

	public void setCategoriaProdcuto(String categoriaProdcuto) {
		this.categoriaProdcuto = categoriaProdcuto;
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

	public String getUnidadesStock() {
		return unidadesStock;
	}

	public void setUnidadesStock(String unidadesStock) {
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

	@Override
	public String toString() {
		return "Producto [codigoProducto=" + codigoProducto + ", nombreProducto=" + nombreProducto
				+ ", categoriaProdcuto=" + categoriaProdcuto + ", escala=" + escala + ", vendedor=" + vendedor
				+ ", unidadesStock=" + unidadesStock + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta
				+ "]";
	}

}
