import java.time.*;
import java.util.List;

import src.classes.*;
import src.enums.*;
import src.utils.FileUtils;
import src.utils.ScannerUtils;
import src.exceptions.*;


public class Main {
    public static final int REGISTRAR_MEDICO = 1;
    public static final int MOSTRAR_MEDICOS = 2;
    public static final int REGISTRAR_PACIENTE = 3;
    public static final int MOSTRAR_PACIENTES = 4;
    public static final int REGISTRAR_TURNO = 5;
    public static final int MOSTRAR_TURNOS = 6;
    public static final int CANCELAR_TURNO = 7;
    public static final int MARCAR_TURNO_ATENDIDO = 8;
    public static final int MOSTRAR_TURNOS_PENDIENTES = 9;
    public static final int SALIR = 10;
    public static void main(String[] args) {
        CentroMedico centroMedico = new CentroMedico();
        FileUtils.leerMedicos().forEach(centroMedico::agregarMedico);
        FileUtils.leerPaciente().forEach(centroMedico::agregarPaciente);
        FileUtils.leerTurnos(
            centroMedico.obtenerMedicos(),
            centroMedico.obtenerPacientes()
            
        ).forEach(centroMedico::agregarTurno);

        while(true) {
            System.out.println("\nBienvenido al centro medico.\n");
        
            System.out.println("""
                    1. Registrar médico
                    2. Mostrar médicos
                    3. Registrar paciente
                    4. Mostrar pacientes
                    5. Registrar turno
                    6. Mostrar turnos
                    7. Cancelar turno
                    8. Marcar turno atendido
                    9. Mostrar turnos pendientes
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
                        FileUtils.guardarMedico(medico);

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
                        FileUtils.guardarPaciente(paciente);

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

                        try {
                            centroMedico.agregarTurno(turno);
                            FileUtils.guardarTurno(turno);
                        } catch (TurnoNoDisponibleException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case MOSTRAR_TURNOS:
                        centroMedico.mostrarTurnos();
                        break;

                    case CANCELAR_TURNO:
                        int idTurnoCancelar = ScannerUtils.leerEntero("Ingrese el ID del turno a cancelar");
                        if (centroMedico.cancelarTurno(idTurnoCancelar)) {
                            System.out.println("Turno cancelado exitosamente.");
                        } else {
                            System.out.println("No se encontró un turno con el ID proporcionado.");
                        }
                        break;

                    case MARCAR_TURNO_ATENDIDO:
                        int idTurnoAtendido = ScannerUtils.leerEntero("Ingrese el ID del turno a marcar como atendido");
                        try {
                            if (centroMedico.marcarTurnoAtendido(idTurnoAtendido)) {
                                System.out.println("Turno marcado como atendido exitosamente.");
                            } else {
                                System.out.println("No se encontró un turno con el ID proporcionado.");
                            }
                        } catch (EstadoTurnoInvalidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case MOSTRAR_TURNOS_PENDIENTES:
                        centroMedico.mostrarTurnosPendientes();
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
