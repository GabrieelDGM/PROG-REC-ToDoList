package net.salesianos.recuperacion.listas; 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import net.salesianos.recuperacion.listas.FormTarea;
import net.salesianos.recuperacion.listas.GestorArchivos;
import net.salesianos.recuperacion.listas.Tarea;



public class App {

    private static Queue<Tarea> listaTareas = new LinkedList<>();

    public static void main(String[] args) {

        // Cargar tareas desde archivo
        listaTareas = GestorArchivos.cargar();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("=== GESTOR DE TAREAS ===");
            System.out.println("1. Listar tareas");
            System.out.println("2. Agregar tarea (GUI)");
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
                    new FormTarea(listaTareas);
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

    private static void eliminarTarea() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas para eliminar.");
            return;
        }

        Tarea eliminada = listaTareas.poll(); 
        System.out.println("Se ha eliminado: " + eliminada.getTitulo());
    }
}

}
