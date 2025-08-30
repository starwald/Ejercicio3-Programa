/**
 * Autor: Santiago Maldonado
 * Fecha de Creación: 29/08/2025
 * Última Modificación: 29/08/2025
 * Descripción: Clase que modela el gimnasio, gestionando
 * la lista de miembros y entrenadores disponibles.
 */
import java.util.ArrayList;

public class Gimnasio {
    private ArrayList<Miembro> miembros;
    private ArrayList<Entrenador> entrenadores;
    private ArrayList<Rutina> rutinas;

    public Gimnasio() {
        this.miembros = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
        this.rutinas = new ArrayList<>();
    }

    public String registrarMiembro(String miembro, String id, String membresia) {
        Miembro nuevoMiembro = new Miembro(miembro, id, membresia);
        this.miembros.add(nuevoMiembro);
        return "Miembro '" + miembro + "' registrado con éxito.";
    }

    public String registrarEntrenador(String nombre, String id, String especialidad) {
        Entrenador nuevoEntrenador = new Entrenador(nombre, id, especialidad);
        this.entrenadores.add(nuevoEntrenador);
        return "Entrenador '" + nombre + "' registrado con éxito.";
    }

    public String crearRutina(String nombre, String descripcion) {
        Rutina nuevaRutina = new Rutina(nombre, descripcion);
        this.rutinas.add(nuevaRutina);
        return "Rutina '" + nombre + "' creada con éxito.";
    }

    private Miembro findMiembroById(String id) {
        for (Miembro m : miembros) {
            if (m.getIdMiembro().equals(id)) {
                return m;
            }
        }
        return null;
    }

    private Entrenador findEntrenadorById(String id) {
        for (Entrenador e : entrenadores) {
            if (e.getIdEntrenador().equals(id)) {
                return e;
            }
        }
        return null;
    }

    private Rutina findRutinaByName(String nombre) {
        for (Rutina r : rutinas) {
            if (r.getNombre().equals(nombre)) {
                return r;
            }
        }
        return null;
    }

    public String asignarEntrenamiento(String idMiembro, String idEntrenador, String nombreRutina) {
        Miembro miembro = findMiembroById(idMiembro);
        Entrenador entrenador = findEntrenadorById(idEntrenador);
        Rutina rutina = findRutinaByName(nombreRutina);

        if (miembro == null || entrenador == null || rutina == null) {
            return "Error: Miembro, entrenador o rutina no encontrados.";
        }
        miembro.asignarEntrenador(entrenador);
        miembro.asignarRutina(rutina);
        entrenador.agregarAlumno(miembro);
        rutina.agregarPracticante(miembro);

        return "Entrenador y rutina asignados con éxito al miembro '" + miembro.getNombre() + "'.";
    }

    public String repoRutinaMasPopu() {
        if (rutinas.isEmpty()) {
            return "No hay rutinas registradas.";
        }
        Rutina masPopular = rutinas.get(0);
        for (Rutina rutina : rutinas) {
            if (rutina.getCantPracticantes() > masPopular.getCantPracticantes()) {
                masPopular = rutina;
            }
        }
        
        return "Reporte: Rutina más popular\n" +
                "Nombre: " +masPopular.getNombre() + "\n" +
                "Descripción: " + masPopular.getDescripcion() + "\n" +
                "Cantidad de practicantes: " + masPopular.getCantPracticantes();
    }

    public String repoEntrenadorMasAlumnos() {
        if (entrenadores.isEmpty()) {
            return "No hay entrenadores registradas.";
        }
        Entrenador masOcupado = entrenadores.get(0);
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getCantidadAlumnos() > masOcupado.getCantidadAlumnos()) {
                masOcupado = entrenador;
            }
        }
        
        return "Reporte: Entrenador con más alumnos\n" +
                "Nombre: " +masOcupado.getNombre() + "\n" +
                "ID: " + masOcupado.getIdEntrenador() + "\n" +
                "Cantidad de practicantes: " + masOcupado.getCantidadAlumnos();
    }

    public String reporteTotalRutinasActivas() {
        return "Reporte: Total de rutinas activas\n" +
                "Cantidad de rutinas: " + rutinas.size();
    }

    public ArrayList<Miembro> getMiembros() {
        return miembros;
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public ArrayList<Rutina> getRutinas() {
        return rutinas;
    }
}