package controller;

import modelo.Cliente;
import modelo.CuentaBancaria;

public class APP {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("12345678-F", "Jaime", "662 98 23 07");
		Cliente cliente2 = new Cliente("12342342-A", "Laura", "672 12 04 57");
		CuentaBancaria cuenta1 = new CuentaBancaria( cliente1, 5000.34);
		CuentaBancaria cuenta2 = new CuentaBancaria( cliente1, 5000);
		
		cuenta1.depositar(150);
		System.out.println(cuenta1.getSaldo());
		cuenta2.transferencia(150, cuenta1);
		System.out.println("Cuenta "+cuenta1.getNumeroCuenta()+": "+cuenta1.getSaldo());
		System.out.println("Cuenta "+cuenta2.getNumeroCuenta()+": "+cuenta2.getSaldo());
		
	}

}
