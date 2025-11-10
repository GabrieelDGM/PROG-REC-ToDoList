package net.salesianos.recuperacion.listas;
import java.time.LocalDate;

public class Tarea {
    private String titulo;
    private String descripcion;
    private String prioridad;
    private LocalDate fecha;

    public Tarea(String titulo, String descripcion, String prioridad, LocalDate fecha) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fecha = fecha;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getPrioridad() {
        return prioridad;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    
    @Override
    public String toString() {
        return "Tarea [titulo=" + titulo + ", descripcion=" + descripcion + ", prioridad=" + prioridad + ", fecha="
                + fecha + "]";
    }
}
