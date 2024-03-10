package Vivienda;

import java.util.Scanner;

public class TestVivienda {

	public static void main(String[] args) {

		// EJERCICIOs V1 abajo

		// EJERCICIO 11.2
		Vivienda v2 = new ViviendaImpl();

		// EJERCICIO 11.3
		Vivienda v3 = new ViviendaImpl("");

		// EJERCICIO 11.4
		Scanner sc = new Scanner(System.in);

		System.out.println("Superficie: ");
		double superficie = sc.nextDouble();
		System.out.println("Precio: ");
		double precio = sc.nextDouble();
		System.out.println("Dirección: ");
		String direccion = sc.next();
		sc.close();

		v2.setSuperficie(superficie);
		v2.setPrecio(precio);
		v2.setDireccion(direccion);

		// EJERCICIO 11.5
		v3.setDireccion("Plaza de las flores nº 24, Úbeda");

		// EJERCICIO 11.7
		System.out.println("Gastos de gestion =" + v2.getGastosGestion());

		// EJERCICIO 11.8
		double[] superficies = { 12, 8, 15, 20, 30 };
		v2.calcularSuperficieTotal(superficies);
		System.out.println("Superficie total =" + v2.getSuperficie());

		// EJERCICIO 11.10
		System.out.println("La vivienda más cara es: " + v2.getViviendaMasCara(v3));

		Vivienda v1;
		v1 = new ViviendaImpl(80, 850, Operacion.ALQUILER, "Calle Gongora nº 58  - 4ºB, Cordoba ");
		// EJERCICIO 11.6
		System.out.println("El precio de v1 rebajado es de " + v1.getRebaja() + " euros");
		// EJERCICIO 11.9
		System.out.println("La localidad de v1 es =" + v1.getLocalidad());
		// 11.11
		System.out.println("La vivienda más cara es: " + v1.getViviendaMasCara(v3));

		// EJERCICIO 11.13

		System.out.println("La vivienda más cara es: " + v1.getViviendaMasCara(v2));

		// EJERCICIO 11.12
		System.out.println(v3.getTamanyo());

	}

}
