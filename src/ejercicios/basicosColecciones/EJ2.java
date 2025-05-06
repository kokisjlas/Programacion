package ejercicios.basicosColecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EJ2 {
	static ArrayList<Tarea> tareas = new ArrayList<Tarea>();
	static HashMap<String, Integer> tareas1 = new HashMap<String, Integer>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String menu = "1- Agregar tarea" + "\n" + "2-Mostrar todas las tareas y sus posiciones" + "\n"
				+ "3-Modificar una tarea" + "\n" + "4-Eliminar una tarea" + "\n" + "5-Mostrar el total de tareas" + "\n"
				+ "6-Salir";
		/// APARTADO DE VARIABLES//////
		sc.useDelimiter("\n");
		int opcion = 0;
		String tarea;
		int index = 0;
		int duracion;

		do {
			System.out.println(menu);
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:// INGRESAR
				System.out.println("Ingrese la posicion de la tarea a agregar");
				index = sc.nextInt();
				System.out.println("Ingrese la tarea a agregar");
				tarea = sc.next();
				System.out.println("Ingrese la duracion");
				duracion = sc.nextInt();
				agregarTarea(index, tarea, duracion);
				break;
			case 2:// LISTAR
				System.out.println("--------------------------TAREAS:--------------------------");
				mostrarTareas();
				mostrarDuracionTotal();
				System.out.println("------------------------------------------------------------");
				break;
			case 3:// MODIFICAR
				System.out.println("Ingrese posicion de la tarea");
				index = sc.nextInt();
				System.out.println("Ingrese la nueva tarea");
				tarea = sc.next();
				System.out.println("Ingrese la nueva duracion");
				duracion = sc.nextInt();
				modificarTarea(index, tarea, duracion);
				break;
			case 4:// REMOVER
				System.out.println("Ingrese posicion de la tarea");
				index = sc.nextInt();
				removerTarea(index);
				break;
			case 5:// IMPRIMIR
				mostrarTotalDeTareas();
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}

		} while (opcion != 6);
	}

	private static void agregarTarea(int index, String tarea, int duracion) {
		/*
		 * Excepcion evitable por codigo
		 * 
		 * if (0 < index || index > tareas.size()) {
		 * System.out.println("Posicion incorrecta"); } else { tareas.add(index, tarea);
		 * }
		 */

		// EXCEPCION EVITABLE CONTROLADA POR TRY CATCH
		try {
			tareas.add(index, new Tarea(tarea, duracion));
			int duracionPrevia = tareas1.get(tarea) == null ? 0 : tareas1.get(tarea);
			tareas1.put(tarea, duracionPrevia + duracion);
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("Posicion incorrecta");
		}

	}

	public static void mostrarTareas() {
		for (int i = 0; i < tareas.size(); i++) {
			System.out.println("Posicion " + i + " Tarea: " + tareas.get(i));
		}
	}

	public static void mostrarDuracionTotal() {

		System.out.println(tareas1.toString());

	}

	public static void modificarTarea(int index, String tarea, int duracion) {
		try {

			removerTarea(index);
			agregarTarea(index, tarea, duracion);


		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("Posicion incorrecta");
		}

	}

	public static void removerTarea(int index) {
		try {

			if (tareas.get(index).getDuracion() == tareas1.get(tareas.get(index).getNombre())) {

				tareas1.remove(tareas.get(index).getNombre());

			} else {
				tareas1.put(tareas.get(index).getNombre(),
						tareas1.get(tareas.get(index).getNombre()) - tareas.get(index).getDuracion());

			}
			tareas.remove(index);

		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("Posicion incorrecta");
		}
	}

	public static void mostrarTotalDeTareas() {
		System.out.println("Total de Tareas: " + tareas.size());
	}

}
