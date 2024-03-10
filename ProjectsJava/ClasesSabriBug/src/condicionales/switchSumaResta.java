package condicionales;

import java.util.Scanner;

public class switchSumaResta {

	public static void main(String[] args) {
	      // Diseña un programa que muestre en pantalla un menú con tres opciones: sumar,
        // restar
//        y salir. Programa cada opción y utiliza un bucle para que pueda repetirse el menú hasta
//        que el usuario elija salir. Solicita dos números para llevar a cabo cada opción del menú.
//        (utiliza switch)0.15

        Scanner entrada = new Scanner(System.in);
        String opcion = " ";
        int num1 = 0;
        int num2 = 0;

        do {

            System.out.println("Menu: \n* Suma: \n* Resta: \n* Salir:");
            opcion = entrada.next();

            System.out.print("Introduce un numero:");
            num1 = entrada.nextInt();
            System.out.print("Introduce un numero:");
            num2 = entrada.nextInt();

            switch (opcion) {
            
            case "suma":
                int suma = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + suma);
                break;

            case "resta":
                int resta = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + resta);
                break;

            default:
                System.out.println("opcion invalida");

            }

        } while (!opcion.equals("salir"));
	}

}
