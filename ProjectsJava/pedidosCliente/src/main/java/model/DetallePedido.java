package model;

public class DetallePedido {
	private String numeroPedido;
	private String codigoProducto;
	private Integer cantidadPedida;
	private Float precioUnidad;
	private short numeroLineaPedido;

	public DetallePedido() {
		super();
	}

	public DetallePedido(String numeroPedido, String codigoProducto, Integer cantidadPedida, Float precioUnidad,
			short numeroLineaPedido) {
		super();
		this.numeroPedido = numeroPedido;
		this.codigoProducto = codigoProducto;
		this.cantidadPedida = cantidadPedida;
		this.precioUnidad = precioUnidad;
		this.numeroLineaPedido = numeroLineaPedido;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public Integer getCantidadPedida() {
		return cantidadPedida;
	}

	public void setCantidadPedida(Integer cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	public Float getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(Float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public short getNumeroLineaPedido() {
		return numeroLineaPedido;
	}

	public void setNumeroLineaPedido(short numeroLineaPedido) {
		this.numeroLineaPedido = numeroLineaPedido;
	}

	@Override
	public String toString() {
		return "DetallePedido [numeroPedido=" + numeroPedido + ", codigoProducto=" + codigoProducto
				+ ", cantidadPedida=" + cantidadPedida + ", precioUnidad=" + precioUnidad + ", numeroLineaPedido="
				+ numeroLineaPedido + "]";
	}
}
