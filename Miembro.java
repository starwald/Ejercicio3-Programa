/**
 * Autor: Santiago Maldonado
 * Fecha de Creación: 29/08/2025
 * Última Modificación: 29/08/2025
 * Descripción: Clase que modela a un miembro del gimnasio,
 * encapsulando su información personal y de entrenamiento.
 */

public class Miembro {
    private String nombre;
    private String idMiembro;
    private String tipoMembresia;
    private Entrenador entrenadorAsignado;
    private Rutina rutinaAsignada;

    public Miembro(String nombre, String idMiembro, String tipoMembresia) {
        this.nombre = nombre;
        this.idMiembro = idMiembro;
        this.tipoMembresia = tipoMembresia;
        this.entrenadorAsignado = null;
        this.rutinaAsignada = null;
    }

    public void asignarEntrenador(Entrenador entrenador) {
        this.entrenadorAsignado = entrenador;
    }

    public void asignarRutina(Rutina rutina) {
        this.rutinaAsignada = rutina;
    }

    public String getNombre() {
        return nombre;
    }

    public Entrenador getEntrenadorAsignado(){
        return entrenadorAsignado;
    }

    public Rutina getRutinaAsignada(){
        return rutinaAsignada;
    }

    public String getIdMiembro() {
        return idMiembro;
    }

    public String toString() {
        String nombreEntrenador = (entrenadorAsignado != null) ? entrenadorAsignado.getNombre() : "No asignado";
        String nombreRutina = (rutinaAsignada != null) ? rutinaAsignada.getNombre() : "No asignada";
        return "Miembro: " + nombre + " (ID: " + idMiembro + ") | Membresía: " + tipoMembresia +
                " | Entrenador: " + nombreEntrenador + " | Rutina: " + nombreRutina;
    }
}