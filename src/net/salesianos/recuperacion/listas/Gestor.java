package net.salesianos.recuperacion.listas;

import java.util.LinkedList;
import java.util.List;

public class Gestor<T> {

    private List<T> elementos;

    public Gestor() {
        elementos = new LinkedList<>();
    }

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public void eliminar(int index) {
        if (index >= 0 && index < elementos.size()) {
            elementos.remove(index);
        }
    }

    public List<T> obtenerTodos() {
        return elementos;
    }

    public int contar() {
        return elementos.size();
    }
}
