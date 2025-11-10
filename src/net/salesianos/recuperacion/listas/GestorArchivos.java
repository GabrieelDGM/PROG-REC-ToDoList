package net.salesianos.recuperacion.listas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Queue;

public class GestorArchivos {

    private static final String RUTA_ARCHIVO = "tareas.txt";

    // Guardar tareas en archivo
    public static void guardar(Queue<Tarea> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(lista);
            System.out.println("Tareas guardadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error guardando las tareas: " + e.getMessage());
        }
    }

    // Cargar tareas desde archivo
    @SuppressWarnings("unchecked")
    public static Queue<Tarea> cargar() {

        File archivo = new File(RUTA_ARCHIVO);

        if (!archivo.exists()) {
            return new LinkedList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO))) {
            return (Queue<Tarea>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error cargando tareas: " + e.getMessage());
            return new LinkedList<>();
        }
    }
}
