/**
 * Autor: Santiago Maldonado
 * Fecha de Creación: 29/08/2025
 * Última Modificación: 29/08/2025
 * Descripción: Clase principal que contiene el método main 
 * para ejecutar el programa de gestión del gimnasio.
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private Gimnasio gimnasio;
    private Scanner scanner;

    public Main() {
        gimnasio = new Gimnasio();
        scanner = new Scanner(System.in);
        cargarDatosDePrueba();
    }

    public static void main(String[] args) {
        Main programa = new Main();
        programa.iniciar();
    }

    public void iniciar() {
        int opcion = 0;
        mostrarMenu();
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
            iniciar();
            return;
        }

        if (opcion == 7) {
            System.out.println("Saliendo del programa. ¡Hasta luego!");
            return;
        }
        ejecutarOpcion(opcion);
        iniciar();
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú del Gimnasio ---");
        System.out.println("1. Registrar Nuevo Miembro");
        System.out.println("2. Registrar Nuevo Entrenador");
        System.out.println("3. Crear Nueva Rutina");
        System.out.println("4. Asignar Entrenamiento a Miembro");
        System.out.println("5. Ver Listas Actuales");
        System.out.println("6. Mostrar Reportes");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void ejecutarOpcion(int opcion) {
        switch(opcion) {
            case 1:
                System.out.print("Ingrese nombre del miembro: ");
                String nombreMiembro = scanner.nextLine();
                System.out.print("Ingrese ID del miembro: ");
                String idMiembro = scanner.nextLine();
                System.out.print("Ingrese tipo de membresía (Básica/Premium): ");
                String tipoMembresia = scanner.nextLine();
                System.out.println(gimnasio.registrarMiembro(nombreMiembro, idMiembro, tipoMembresia));
                break;
            case 2:
                System.out.print("Ingrese nombre del entrenador: ");
                String nombreEntrenador = scanner.nextLine();
                System.out.print("Ingrese ID del entrenador: ");
                String idEntrenador = scanner.nextLine();
                System.out.print("Ingrese especialidad del entrenador: ");
                String especialidad = scanner.nextLine();
                System.out.println(gimnasio.registrarEntrenador(nombreEntrenador, idEntrenador, especialidad));
                break;
            case 3:
                System.out.print("Ingrese nombre de la rutina: ");
                String nombreRutina = scanner.nextLine();
                System.out.print("Ingrese descripción de la rutina: ");
                String descripcionRutina = scanner.nextLine();
                System.out.println(gimnasio.crearRutina(nombreRutina, descripcionRutina));
                break;
            case 4:
                System.out.print("Ingrese ID del miembro a asignar: ");
                String idM = scanner.nextLine();
                System.out.print("Ingrese ID del entrenador a asignar: ");
                String idE = scanner.nextLine();
                System.out.print("Ingrese nombre de la rutina a asignar: ");
                String nombreR = scanner.nextLine();
                System.out.println(gimnasio.asignarEntrenamiento(idM, idE, nombreR));
                break;
            case 5:
                mostrarListas();
                break;
            case 6:
                mostrarReportes();
                break;
            default:
                System.out.println("Opción inválida. Por favor, intente de nuevo.");
                break;
        }
    }

    private void mostrarListas() {
        System.out.println("\n--- Lista de Miembros ---");
        ArrayList<Miembro> miembros = gimnasio.getMiembros();
        if (miembros.isEmpty()) {
            System.out.println("No hay miembros registrados.");
        }
        else {
            for (Miembro m : miembros) {
                System.out.println(m);
            }
        }

        System.out.println("\n--- Lista de Entrenadores ---");
        ArrayList<Entrenador> entrenadores = gimnasio.getEntrenadores();
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
        }
        else {
            for (Entrenador e : entrenadores) {
                System.out.println("Entrenador: " + e.getNombre() + " (ID: " + e.getIdEntrenador() + ") | Alumnos a cargo: " + e.getCantidadAlumnos());
            }
        }

        System.out.println("\n--- Lista de Rutinas ---");
        ArrayList<Rutina> rutinas = gimnasio.getRutinas();
        if (rutinas.isEmpty()) {
            System.out.println("No hay rutinas creadas.");
        }
        else {
            for (Rutina r : rutinas) {
                System.out.println("Rutina: " + r.getNombre() + " | Descripción: " + r.getDescripcion() + " | Cantidad de practicantes: " + r.getCantPracticantes());
            }
        }
    }

    private void mostrarReportes() {
        System.out.println("\n--- Reportes ---");
        String reporte1 = gimnasio.repoRutinaMasPopu();
        System.out.println(reporte1);
        System.out.println("------------------------");
        String reporte2 = gimnasio.repoEntrenadorMasAlumnos();
        System.out.println(reporte2);
        System.out.println("------------------------");
        String reporte3 = gimnasio.reporteTotalRutinasActivas();
        System.out.println(reporte3);
        System.out.println("------------------------");
        System.out.println("Presione Enter para volver al menú principal.");
        scanner.nextLine();
    }

    private void cargarDatosDePrueba() {
        gimnasio.registrarMiembro("Ana Gómez", "M001", "Premium");
        gimnasio.registrarMiembro("Luis Pérez", "M002", "Básica");
        gimnasio.registrarEntrenador("Carlos Ruiz", "E001", "Fuerza");
        gimnasio.registrarEntrenador("Marta López", "E002", "Cardio");
        gimnasio.crearRutina("Rutina A", "Entrenamiento de fuerza y resistencia");
        gimnasio.crearRutina("Rutina B", "Entrenamiento cardiovascular y flexibilidad");
    }
}