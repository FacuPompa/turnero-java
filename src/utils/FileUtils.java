package src.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

import src.enums.Especialidad;
import src.enums.EstadoTurno;
import src.classes.Medico;
import src.classes.Paciente;
import src.classes.Turno;

public class FileUtils {
    private static final String RUTA_MEDICOS = "data/medicos.txt";
    private static final String RUTA_PACIENTES = "data/pacientes.txt";
    private static final String RUTA_TURNOS = "data/turnos.txt";


// Persistencia de médicos

    public static void guardarMedico(Medico medico) {
        String linea = String.join("|",
                String.valueOf(medico.getIdMedico()),
                medico.getNombre(),
                medico.getApellido(),
                medico.getEspecialidad().name()
        );

        try {
            Files.createDirectories(Paths.get("data"));

            Files.writeString(
                Paths.get(RUTA_MEDICOS),
                linea + System.lineSeparator(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.out.println("Error al guardar el médico: " + e.getMessage());
        }
    }

    public static List<Medico> leerMedicos(){
        List<Medico> medicos = new ArrayList<>();
        try {
            if (!Files.exists(Paths.get(RUTA_MEDICOS))) {
                return medicos;
            }

            List<String> lineas = Files.readAllLines(Paths.get(RUTA_MEDICOS));

            for (String linea : lineas) {
                String [] datos = linea.split("\\|");

                if (datos.length == 4) {
                    int idMedico = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String apellido = datos[2];
                    Especialidad especialidad = Especialidad.valueOf(datos[3]);

                    Medico medico = new Medico(nombre, apellido, especialidad, idMedico);

                    medicos.add(medico);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer los médicos: " + e.getMessage());
        }

        return medicos;
    }

    // Persistencia de pacientes

    public static void guardarPaciente(Paciente paciente) {
        String linea = String.join("|",
                String.valueOf(paciente.getIdPaciente()),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getEmail(),
                paciente.getTelefono()
            );

            try {
                Files.createDirectories(Paths.get("data"));

                Files.writeString(
                        Paths.get(RUTA_PACIENTES),
                        linea + System.lineSeparator(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND
                );
            } catch (IOException e) {
                System.out.println("Error al guardar el paciente: " + e.getMessage());
            }
    }

    public static List<Paciente> leerPaciente() {
        List<Paciente> pacientes = new ArrayList<>();

        try {
            if (!Files.exists(Paths.get(RUTA_PACIENTES))) {
                return pacientes;
            }

            List<String> lineas = Files.readAllLines(Paths.get(RUTA_PACIENTES));

            for(String linea : lineas) {
                String[] datos = linea.split("\\|");

                if (datos.length == 5) {
                    int idPaciente = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String apellido = datos[2];
                    String email = datos[3];
                    String telefono = datos[4];
                    Paciente paciente = new Paciente(nombre, apellido, email, telefono, idPaciente);

                    pacientes.add(paciente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer los pacientes: " + e.getMessage());
        }

        return pacientes;
    }

    // Persistencia de turnos

    public static void guardarTurno(Turno turno) {
        String linea = String.join("|",
                String.valueOf(turno.getIdTurno()),
                turno.getFecha().toString(),
                turno.getHora().toString(),
                String.valueOf(turno.getMedico().getIdMedico()),
                String.valueOf(turno.getPaciente().getIdPaciente()),
                String.valueOf(turno.getEstadoTurno().name())
        );

        try {
            Files.createDirectories(Paths.get("data"));

            Files.writeString(
                    Paths.get(RUTA_TURNOS),
                    linea + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.out.println("Error al guardar el turno: " + e.getMessage());
        }
    }

    public static List<Turno> leerTurnos(List<Medico> medicos, List<Paciente> pacientes) {
        List<Turno> turnos = new ArrayList<>();
        try {
            if (!Files.exists(Paths.get(RUTA_TURNOS))) {
                return turnos;
            }

            List<String> lineas = Files.readAllLines(Paths.get(RUTA_TURNOS));

            for (String linea : lineas) {
                String [] datos = linea.split("\\|");

                if (datos.length == 6) {
                    int idTurno = Integer.parseInt(datos[0]);
                    LocalDate fecha = LocalDate.parse(datos[1]);
                    LocalTime hora = LocalTime.parse(datos[2]);
                    int idMedico = Integer.parseInt(datos[3]);
                    int idPaciente = Integer.parseInt(datos[4]);
                    EstadoTurno estadoTurno = EstadoTurno.valueOf(datos[5]);

                    Medico medico = medicos.stream()
                            .filter(m -> m.getIdMedico() == idMedico)
                            .findFirst()
                            .orElse(null);

                    Paciente paciente = pacientes.stream()
                            .filter(p -> p.getIdPaciente() == idPaciente)
                            .findFirst()
                            .orElse(null);
                    
                    if (medico != null && paciente != null) {
                        Turno turno = new Turno(fecha, hora, medico, paciente, idTurno);
                        turno.setEstadoTurno(estadoTurno);
                        turnos.add(turno);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer los turnos: " + e.getMessage());

        }
        return turnos;
    }
}
