package src.classes;

import java.util.*;
import src.exceptions.EstadoTurnoInvalidoException;
import src.exceptions.IdDuplicadoException;
import src.exceptions.TurnoNoDisponibleException;
import src.enums.EstadoTurno;

public class CentroMedico {
    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<Turno> turnos;

    public CentroMedico() {
        this.medicos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.turnos = new ArrayList<>();
    }

    public void agregarMedico(Medico medico) {
        if (buscarMedico(medico.getIdMedico()) != null) {
            throw new IdDuplicadoException("médico", medico.getIdMedico());
        }

        medicos.add(medico);
    }

    public void mostrarMedicos() {
        medicos.forEach(medico -> System.out.println(
                "ID: " + medico.getIdMedico()
                        + " | " + medico.getNombre()
                        + " | " + medico.getApellido()
                        + " | " + medico.getEspecialidad()
        ));
    }

    public void agregarPaciente(Paciente paciente) {
        if (buscarPaciente(paciente.getIdPaciente()) != null) {
            throw new IdDuplicadoException("paciente", paciente.getIdPaciente());
        }

        pacientes.add(paciente);
    }

    public void mostrarPacientes() {
        pacientes.forEach(paciente -> System.out.println(
                "ID: " + paciente.getIdPaciente()
                        + " | " + paciente.getNombre()
                        + " | " + paciente.getApellido()
                        + " | " + paciente.getEmail()
        ));
    }

    public List<Turno> obtenerTurnos() {
        return new ArrayList<>(turnos);
    }

    public List<Medico> obtenerMedicos() {
        return new ArrayList<>(medicos);
    }

    public List<Paciente> obtenerPacientes() {
        return new ArrayList<>(pacientes);
    }

    public void agregarTurno(Turno turno) {
        if (buscarTurno(turno.getIdTurno()) != null) {
            throw new IdDuplicadoException("turno", turno.getIdTurno());
        }

        boolean horarioOcupado = turnos.stream()
                .anyMatch(t -> t.getFecha().equals(turno.getFecha())
                        && t.getHora().equals(turno.getHora())
                        && t.getMedico().getIdMedico() == turno.getMedico().getIdMedico());

        if (horarioOcupado) {
            throw new TurnoNoDisponibleException();
        }
        
        turnos.add(turno);
    }

    public void mostrarTurnos () {
        turnos.forEach(turno -> System.out.println(
                "ID: " + turno.getIdTurno()
                        + " | " + turno.getFecha()
                        + " | " + turno.getHora()
                        + " | " + turno.getMedico().getNombre()
                        + " | " + turno.getPaciente().getNombre()
                        + " | " + turno.getEstadoTurno()
        ));
    }

    public Medico buscarMedico(int idMedico) {
        return medicos.stream()
                .filter(medico -> medico.getIdMedico() == idMedico)
                .findFirst()
                .orElse(null);
    }

    public Paciente buscarPaciente (int idPaciente) {
        return pacientes.stream()
                .filter(paciente -> paciente.getIdPaciente() == idPaciente)
                .findFirst()
                .orElse(null);
    }

    public Turno buscarTurno(int idTurno) {
        return turnos.stream()
                .filter(turno -> turno.getIdTurno() == idTurno)
                .findFirst()
                .orElse(null);
    }

    public boolean cancelarTurno(int idTurno) {
        Turno turno = buscarTurno(idTurno);
        
        if (turno == null) {
            return false;
        }

        turno.setEstadoTurno(EstadoTurno.CANCELADO);
        return true;
    }

    public boolean marcarTurnoAtendido(int idTurno) {
        Turno turno = buscarTurno(idTurno);
        
        if (turno == null) {
            return false;
        }

        if (turno.getEstadoTurno() == EstadoTurno.ATENDIDO) {
            throw new EstadoTurnoInvalidoException("El turno ya estaba marcado como atendido.");
        }

        turno.setEstadoTurno(EstadoTurno.ATENDIDO);
        return true;
    }

    public void mostrarTurnosPendientes() {
        turnos.stream()
                .filter(turno -> turno.getEstadoTurno() == EstadoTurno.PENDIENTE)
                .forEach(turno -> System.out.println(
                        "ID: " + turno.getIdTurno()
                                + " | " + turno.getFecha()
                                + " | " + turno.getHora()
                                + " | " + turno.getMedico().getNombre()
                                + " | " + turno.getPaciente().getNombre()
                ));
    }
}
