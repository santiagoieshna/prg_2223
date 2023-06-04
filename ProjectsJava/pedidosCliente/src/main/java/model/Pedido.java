package model;

public class Pedido {
	private String numeroPedido;
	private String fechaPedido;
	private String fechaEntrega;
	private String estado;
	private String comentarios;
	private String numeroCliente;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(String numeroPedido, String fechaPedido, String fechaEntrega, String estado, String comentarios,
			String numeroCliente) {
		super();
		this.numeroPedido = numeroPedido;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
		this.comentarios = comentarios;
		this.numeroCliente = numeroCliente;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	@Override
	public String toString() {
		return "Pedido [numeroPedido=" + numeroPedido + ", fechaPedido=" + fechaPedido + ", fechaEntrega="
				+ fechaEntrega + ", estado=" + estado + ", comentarios=" + comentarios + ", numeroCliente="
				+ numeroCliente + "]";
	}
}
