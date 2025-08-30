/**
 * Autor: Santiago Maldonado
 * Fecha de Creación: 29/08/2025
 * Última Modificación: 29/08/2025
 * Descripción: Clase que modela a un entrenador del gimnasio
 * y gestiona la lista de miembros asignados.
 */
 import java.util.ArrayList;

 public class Entrenador {
    private String nombre;
    private String idEntrenador;
    private String especialidad;
    private ArrayList<Miembro> alumnosACargo;

    public Entrenador(String nombre, String idEntrenador, String especialidad) {
        this.nombre = nombre;
        this.idEntrenador = idEntrenador;
        this.especialidad = especialidad;
        this.alumnosACargo = new ArrayList<>();
    }

    public void agregarAlumno(Miembro miembro) {
        alumnosACargo.add(miembro);
    }

    public int getCantidadAlumnos() {
        return this.alumnosACargo.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdEntrenador() {
        return idEntrenador;
    }
 }