package modelo;

public class CuentaBancaria {
	
	private String numeroCuenta;
	private Cliente propietario;
	private double saldo;
	private static int con_NumeroCuenta=0;
	
	/**
	 * @param numedroCuenta
	 * @param propietario
	 * @param saldo
	 */
	public CuentaBancaria( Cliente propietario, double saldo) {
		super();
		this.numeroCuenta = auto_Increment_ID();
		this.propietario = propietario;
		this.saldo = saldo;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumedroCuenta(String numedroCuenta) {
		this.numeroCuenta = numedroCuenta;
	}
	public Cliente getPropietario() {
		return propietario;
	}
	public void setPropietario(Cliente propietario) {
		this.propietario = propietario;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double cantidad) {
		saldo += cantidad;
	}
	
	public boolean transferencia(double cantidad, CuentaBancaria cuenta) {
		boolean check = false;
		if (cantidad>0 && cantidad <= this.saldo) {
			this.saldo -= cantidad;
			cuenta.depositar(cantidad);
			check = true;
		}
		
		return check;
	}
	private static String auto_Increment_ID() {
		con_NumeroCuenta ++;
		return String.valueOf(con_NumeroCuenta);
	}
	
}
