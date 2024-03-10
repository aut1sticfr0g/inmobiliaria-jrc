package Test;

import java.util.ArrayList;
import java.util.Scanner;

import Comparators.SuperficieComparator;
import Vivienda.*;
import ViviendaExceptions.*;

public class Test {

	public static Piso pedirInfoPiso() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Superficie del piso en metros: ");
		Double superficie = sc.nextDouble();
		System.out.println("Precio: ");
		Double precio = sc.nextDouble();
		System.out.println("Operación (elija ALQUILER, VENTA O ALQUILER_VENTA): ");
		String op = sc.nextLine();
		Operacion operacion = null;
		boolean operacionCorrecta = false;
		
		while (!operacionCorrecta) {
			
			switch (op.toUpperCase()) {
			case "ALQUILER":
				operacion = Operacion.ALQUILER;
				operacionCorrecta = true;
				break;
			case "VENTA":
				operacion = Operacion.VENTA;
				operacionCorrecta = true;
			case "ALQUILER_VENTA":
				operacion = Operacion.ALQUILER_VENTA;
				operacionCorrecta = true;
			default:
				System.out.println("Introduzca operación correcta.");
				op = sc.nextLine();
			}
		}
		
		
		System.out.println("Dirección de la vivienda: ");
		String direccion = sc.nextLine();
		System.out.println("Planta: ");
		int planta = sc.nextInt();
		System.out.println("Puerta: ");
		String puertaString = sc.next();
		char puerta = puertaString.charAt(0);
		Piso piso = new PisoImpl(superficie, precio, operacion, direccion, planta, puerta);
		return piso;
	}

	public static void addPiso(Catalogo catalogo) {

		try {
			catalogo.addPiso(pedirInfoPiso());
		} catch (SamePisoException e) {
			System.out.println(e);
		}
	}

	public static void eliminarPiso(Catalogo catalogo) {

		try {
			catalogo.removePiso(pedirInfoPiso());
		} catch (PisoNotFoundException e) {
			System.out.println(e);
		}
		visualizarCatalogo(catalogo);
	}

	public static void visualizarCatalogo(Catalogo catalogo) {

		System.out.println("PISOS DISPONIBLES: ");
		System.out.println(catalogo.getPisos()); 
	}

	public static void mostrarPisoMasPequenyo(Catalogo catalogo) {

		catalogo.sortSuperficie();
		System.out.println("EL PISO MÁS PEQUEÑO ES: ");
		System.out.println(catalogo.getPisos().get(0));
	}

	public static void rebajarPisos(Catalogo catalogo) {

		System.out.println("Elija la superficie de los pisos a rebajar: ");
		Scanner sc = new Scanner(System.in);
		double superficie = sc.nextDouble();
		System.out.println("Porcentaje que desea rebajar: ");
		double porcentaje = sc.nextDouble();

		catalogo.getRebajaPorSuperficie(superficie, porcentaje);

		System.out.println("Los piso de " + superficie + "m2 se han rebajado corectamente.");
		visualizarCatalogo(catalogo);
	}

	public static void filtrarPrecioYSuperficie(Catalogo catalogo) {

		System.out.println("Elija el precio a filtrar: ");
		Scanner sc = new Scanner(System.in);
		int precio = sc.nextInt();
		System.out.println("Elija la superficie a filtrar: ");
		double superficie = sc.nextDouble();

		Catalogo filtrado = catalogo.getMejorCatalogo(precio, superficie);
		visualizarCatalogo(filtrado);
	}

	public static void inicializarMenu(Catalogo catalogo) {

		int opcion = 0;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("============================================================================");
			System.out.println("Pulse un número del 1 al 6 para realizar algunas de las siguientes opciones: ");
			System.out.println("1: Añadir nuevo piso");
			System.out.println("2: Eliminar un piso");
			System.out.println("3: Mostrar piso con el menor precio por superficie");
			System.out.println("4: Rebajar pisos");
			System.out.println("5: Filtrar por precio y superficie");
			System.out.println("6: Visualizar Catálogo");
			System.out.println("7: Salir del menú");
			System.out.println("============================================================================");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				opcion = 0;
				addPiso(catalogo);
				break;
			case 2:
				opcion = 0;
				eliminarPiso(catalogo);
				break;
			case 3:
				opcion = 0;
				mostrarPisoMasPequenyo(catalogo);
				break;
			case 4:
				opcion = 0;
				rebajarPisos(catalogo);
				break;
			case 5:
				opcion = 0;
				filtrarPrecioYSuperficie(catalogo);
				break;
			case 6:
				opcion = 0;
				visualizarCatalogo(catalogo);
				break;
			default:
				System.out.println("Opción no disponible.");
				break;
			}

		} while (opcion != 7);

	}

	public static void main(String[] args) {

		ArrayList<Piso> pisos = new ArrayList<>();
		Catalogo catalogo = new CatalogoImpl(pisos);
		inicializarMenu(catalogo);
	}
}
