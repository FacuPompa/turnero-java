package src.classes;

import java.util.*;
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
        medicos.add(medico);
    }

    public void mostrarMedicos() {
        medicos.forEach(medico -> System.out.println(medico.getNombre() + " | " + medico.getApellido() + " | " + medico.getEspecialidad()));
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void mostrarPacientes() {
        pacientes.forEach(paciente -> System.out.println(paciente.getNombre() + " | " + paciente.getApellido() + " | " + paciente.getEmail()));
    }

    public void agregarTurno(Turno turno) {
        boolean horarioOcupado = turnos.stream()
                .anyMatch(t -> t.getFecha().equals(turno.getFecha())
                        && t.getHora().equals(turno.getHora())
                        && t.getMedico().getIdMedico() == turno.getMedico().getIdMedico());

        if (horarioOcupado) {
            throw new TurnoNoDisponibleException();
        }
        
        turnos.add(turno);
        System.out.println("Turno registrado exitosamente.");
    }

    public void mostrarTurnos () {
        turnos.forEach(turno -> System.out.println(turno.getFecha() + " | " + turno.getHora() + " | " + turno.getMedico().getNombre() + " | " + turno.getPaciente().getNombre() + " | " + turno.getEstadoTurno()));
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
}
