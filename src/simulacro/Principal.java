package simulacro;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// APARTADO DE LOS ATRIBUTOS DEL CONCESIONARIO
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();
		TreeMap<String, Cliente> listaClientes = new TreeMap<String, Cliente>();
		Concesionario concesionario = new Concesionario(listaCoches, listaClientes);
		// OBJETOS CREADOS A MANO
		Coche coche1 = new CocheVenta("1a", "A", 2000, 1000);
		Coche coche2 = new Coche("2b", "B", 2010, 2000);
		Coche coche3 = new CocheVenta("3c", "C", 2020, 3000);
		Coche coche4 = new CocheAlquiler("4d", "D", 2025, 4000, 50);

		listaCoches.add(coche1);
		listaCoches.add(coche2);
		listaCoches.add(coche3);
		listaCoches.add(coche4);

		Cliente cliente3 = new Cliente("Renzo", "9999999X");
		Cliente cliente1 = new Cliente("cliente1", "123456789");
		Cliente cliente2 = new Cliente("cliente2", "987654321");

		listaClientes.put("123456789", cliente1);
		listaClientes.put("987654321", cliente2);

		String menu = "1-Venta de un coche" + "\n" + "2-Alquiler de un coche" + "\n" + "3-Devolucion de un alquiler"
				+ "\n" + "4-Ordenar coches" + "\n" + "5-Listar coches que esten disponibles" + "\n"
				+ "6-Obtener la media del preico de los coches" + "\n" + "7-Salir";

		// APARTADO DE VARIABLES
		int opcion = 0;
		String matricula;
		String dni = "";
		int numDias = 0;
		String nombre = "";

		do {
			System.out.println(menu);
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("---------------------------VENDER--------------------------");
				System.out.println("Ingrese la matricula");
				matricula = sc.next();
				concesionario.buscarCocheVenta(matricula);
				System.out.println("----------------------------------------------------------");
				break;

			case 2:
				System.out.println("---------------------------ALQUILAR--------------------------");
				System.out.println("Ingrese la matricula");
				matricula = sc.next();
				concesionario.buscarCocheAlquiler(matricula);
				System.out.println("Ingrese el numero de dias a alquilar");
				numDias = sc.nextInt();

				System.out.println("Ingrese el dni");
				dni = sc.next();

				Cliente cliente = concesionario.buscarClientePorDNI(dni);

				if (cliente == null) {

					System.out.println("Cliente no encontrado, añadir a la base de datos");
					System.out.println("Ingrese el nombre del nuevo cliente");
					nombre = sc.next();

					Cliente nuevocliente = concesionario.altaCliente(dni, nombre);
				} else {

					concesionario.alquilarCoche(matricula, cliente, numDias);

				}

				System.out.println("----------------------------------------------------------");

				break;
			case 3:
				System.out.println("---------------------------DEVOLVER--------------------------");
				System.out.println("Ingrese la matricula");
				matricula = sc.next();
				CocheAlquiler cochealquiler=concesionario.buscarCocheAlquiler(matricula);
				cochealquiler.devolver();

				break;
				//ORDENAR ARRAYLIST CON LAMBDA
			case 4:
			
				break;
			case 5:
				break;
			case 6:
				break;

			}
		} while (opcion != 7);

	}

}
