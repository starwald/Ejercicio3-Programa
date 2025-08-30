/**
 * Autor: Santiago Maldonado
 * Fecha de Creación: 29/08/2025
 * Última Modificación: 29/08/2025
 * Descripción: Define una rutina de ejercicios y mantiene un registro de los miembros que la practican.
 */
import java.util.ArrayList;

public class Rutina {
    private String nombre;
    private String descripcion;
    private ArrayList<Miembro> practicantes;

    public Rutina(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.practicantes = new ArrayList<>();
    }

    public void agregarPracticante(Miembro miembro) {
        if (!practicantes.contains(miembro)) {
            practicantes.add(miembro);
        }
        else {
            System.out.println("El miembro ya está registrado en esta rutina.");
        }
    }

    public int getCantPracticantes() {
        return practicantes.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}