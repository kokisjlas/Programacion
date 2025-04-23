package ejercicios.basicosColecciones;

import java.util.ArrayList;
import java.util.Scanner;

public class EJ1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String menu = "1- Agregar tarea" + "\n" + "2-Mostrar todas las tareas y sus posiciones" + "\n"
				+ "3-Modificar una tarea" + "\n" + "4-Eliminar una tarea" + "\n" + "5-Mostrar el total de tareas" + "\n"
				+ "6-Salir";

		ArrayList<String> tareas = new ArrayList<String>();

		int opcion = 0;
		do {
			System.out.println(menu);
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("Ingrese la tarea a agregar");
				String tarea = sc.next();
				tareas.add(tarea);
				break;
			case 2:
				System.out.println("--------------------------TAREAS:--------------------------");
				for (int i = 0; i < tareas.size(); i++) {
					System.out.println("Posicion " + i + " Tarea: " + tareas.get(i));
				}
				System.out.println("---------------------------------------------------");
				break;
			case 3:
				System.out.println("Ingrese posicion de la tarea");
				int posicion = sc.nextInt();
				System.out.println("Ingrese la nueva tarea");
				String nuevatarea = sc.next();
				tareas.set(posicion, nuevatarea);
				break;
			case 4:
				System.out.println("Ingrese posicion de la tarea");
				int pos = sc.nextInt();
				tareas.remove(pos);
				break;
			case 5:
				System.out.println("El total de tareas es: " + tareas.size());
				break;
			default:
				break;
			}

		} while (opcion != 6);
	}

}
