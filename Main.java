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

                    case REGISTRAR_PACIENTE:
                        String nombrePaciente = ScannerUtils.leerTexto("Ingrese el nombre del paciente");
                        String apellidoPaciente = ScannerUtils.leerTexto("Ingrese el apellido del paciente");
                        String emailPaciente = ScannerUtils.leerTexto("Ingrese el email del paciente");
                        String telefonoPaciente = ScannerUtils.leerTexto("Ingrese el telefono del paciente (+549 ...)");
                        int idPaciente = ScannerUtils.leerEntero("Ingrese el ID del paciente");

                        Paciente paciente = new Paciente(nombrePaciente, apellidoPaciente, emailPaciente, telefonoPaciente, idPaciente);
                        centroMedico.agregarPaciente(paciente);

                        System.out.println("Paciente registrado exitosamente.");
                        break;
                    case MOSTRAR_PACIENTES:
                        centroMedico.mostrarPacientes();
                        break;

                    case REGISTRAR_TURNO:
                        int idMedicoTurno = ScannerUtils.leerEntero("Ingrese el ID del médico para el turno");
                        Medico medicoTurno = centroMedico.buscarMedico(idMedicoTurno);
                            if (medicoTurno == null) {
                                System.out.println("No se encontró un médico con el ID proporcionado.");
                                break;
                            }
                        int idPacienteTurno = ScannerUtils.leerEntero("Ingrese el ID del paciente para el turno");
                        Paciente pacienteTurno = centroMedico.buscarPaciente(idPacienteTurno);
                            if (pacienteTurno == null) {
                                System.out.println("No se encontró un paciente con el ID proporcionado.");
                                break;
                            }
                        LocalDate fechaTurno = ScannerUtils.leerFecha("Ingrese la fecha del turno (AAAA-MM-DD)");
                        LocalTime horaTurno = ScannerUtils.leerHora("Ingrese la hora del turno (HH:MM)");
                        int idTurno = ScannerUtils.leerEntero("Ingrese el ID del turno");

                        Turno turno = new Turno(fechaTurno, horaTurno, medicoTurno, pacienteTurno, idTurno);

                        centroMedico.agregarTurno(turno);

                        System.out.println("Turno registrado exitosamente.");
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