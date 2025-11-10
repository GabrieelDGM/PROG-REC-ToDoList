package net.salesianos.recuperacion.listas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {

    private static Queue<Tarea> listaTareas = new LinkedList<>();

    public static void main(String[] args) {
        // Cargar tareas desde archivo
        listaTareas = GestorArchivos.cargar();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== GESTOR DE TAREAS ===");
            System.out.println("1. Listar tareas");
            System.out.println("2. Agregar tarea");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Salir");
            System.out.print("Elige opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    listarTareas();
                    break;

                case 2:
                    agregarTarea(sc);
                    break;

                case 3:
                    eliminarTarea();
                    break;

                case 4:
                    GestorArchivos.guardar(listaTareas);
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);

        sc.close();
    }

    // ====== MÉTODOS AUXILIARES ======

    private static void listarTareas() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }

        int num = 1;
        for (Tarea t : listaTareas) {
            System.out.println(num + ". " + t);
            num++;
        }
    }

    private static void agregarTarea(Scanner sc) {
        System.out.print("Título de la tarea: ");
        String titulo = sc.nextLine();

        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        listaTareas.add(new Tarea(titulo, descripcion, descripcion, null));
        System.out.println("Tarea agregada correctamente.");
    }

    private static void eliminarTarea() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas para eliminar.");
            return;
        }

        Tarea eliminada = listaTareas.poll();
        System.out.println(" Se ha eliminado la tarea: " + eliminada.getTitulo());
    }
}
