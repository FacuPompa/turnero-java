import java.util.*;
import java.time.*;
import src.classes.*;
import src.enums.*;
import src.utils.ScannerUtils;


public class Main {
    public static final int REGISTRAR_MEDICO = 1;
    public static final int MOSTRAR_MEDICOS = 2;
    public static final int REGISTRAR_PACIENTE = 3;
    public static final int MOSTRAR_PACIENTES = 4;
    public static final int REGISTRAR_TURNO = 5;
    public static final int MOSTRAR_TURNOS = 6;
    public static final int SALIR = 10;
    public static void main(String[] args) {
        CentroMedico centroMedico = new CentroMedico();

        while(true) {
            System.out.println("\nBienvenido al centro medico.\n");
        
            System.out.println("""
                    1. Registrar médico
                    2. Mostrar médicos
                    3. Registrar paciente
                    4. Mostrar pacientes
                    5. Registrar turno
                    6. Mostrar turnos
                    10. Salir
                    """);

            int opcion = ScannerUtils.leerEntero("Seleccione una opcion");
            switch(opcion) {

                    case REGISTRAR_MEDICO:
                        String nombreMedico = ScannerUtils.leerTexto("Ingrese el nombre del medico");
                        String apellidoMedico = ScannerUtils.leerTexto("Ingrese el apellido del medico");
                        Especialidad especialidad = ScannerUtils.leerEspecialidad("Ingrese la especialidad del medico");
                        int idMedico = ScannerUtils.leerEntero("Ingrese el ID del medico");
                        Medico medico = new Medico(nombreMedico, apellidoMedico, especialidad, idMedico);
                        centroMedico.agregarMedico(medico);
                        System.out.println("Medico registrado exitosamente.");
                        break;

                    case MOSTRAR_MEDICOS:
                        centroMedico.mostrarMedicos();
                        break;
                    case MOSTRAR_PACIENTES:
                        centroMedico.mostrarPacientes();
                        break;
                    case MOSTRAR_TURNOS:
                        centroMedico.mostrarTurnos();
                        break;
                    case SALIR:
                        System.out.println("Saliendo del programa...");
                        return;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese un número del al 10.");
                        break;
            }
        }
    }
}