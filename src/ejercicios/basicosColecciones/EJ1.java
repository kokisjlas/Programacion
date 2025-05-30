package ejercicios.basicosColecciones;

import java.util.ArrayList;
import java.util.Scanner;

public class EJ1 {
	static ArrayList<String> tareas = new ArrayList<String>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String menu = "1- Agregar tarea" + "\n" + "2-Mostrar todas las tareas y sus posiciones" + "\n"
				+ "3-Modificar una tarea" + "\n" + "4-Eliminar una tarea" + "\n" + "5-Mostrar el total de tareas" + "\n"
				+ "6-Salir";

		sc.useDelimiter("\n");
		int opcion = 0;
		String tarea;
		int index = 0;
		do {
			System.out.println(menu);
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("Ingrese la posicion de la tarea a agregar");
				index = sc.nextInt();
				System.out.println("Ingrese la tarea a agregar");
				tarea = sc.next();
				agregarTarea(index, tarea);
				break;
			case 2:
				System.out.println("--------------------------TAREAS:--------------------------");
				mostrarTareas();
				System.out.println("------------------------------------------------------------");
				break;
			case 3:
				System.out.println("Ingrese posicion de la tarea");
				index = sc.nextInt();
				System.out.println("Ingrese la nueva tarea");
				tarea = sc.next();
				modificarTarea(index, tarea);
				break;
			case 4:
				System.out.println("Ingrese posicion de la tarea");
				index = sc.nextInt();
				removerTarea(index);
				break;
			case 5:
				mostrarTotalDeTareas();
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}

		} while (opcion != 6);
	}

	private static void agregarTarea(int index, String tarea) {
		/*
		 * Excepcion evitable por codigo
		 * 
		 * if (0 < index || index > tareas.size()) {
		 * System.out.println("Posicion incorrecta"); } else { tareas.add(index, tarea);
		 * }
		 */

		// EXCEPCION EVITABLE CONTROLADA POR TRY CATCH
		try {
			tareas.add(index, tarea);
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("Posicion incorrecta");
		}

	}

	public static void mostrarTareas() {
		for (int i = 0; i < tareas.size(); i++) {
			System.out.println("Posicion " + i + " Tarea: " + tareas.get(i));
		}
	}

	public static void modificarTarea(int index, String tarea) {
		try {
			tareas.set(index, tarea);
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("Posicion incorrecta");
		}

	}

	public static void removerTarea(int index) {
		try {
			tareas.remove(index);
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("Posicion incorrecta");
		}
	}

	public static void mostrarTotalDeTareas() {
		System.out.println("Total de Tareas: "+tareas.size());
	}

}
