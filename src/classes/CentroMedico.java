package src.classes;

import java.util.*;

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
        turnos.add(turno);
    }

    public void mostrarTurnos () {
        turnos.forEach(turno -> System.out.println(turno.getFecha() + " | " + turno.getHora() + " | " + turno.getMedico().getNombre() + " | " + turno.getPaciente().getNombre() + " | " + turno.getEstadoTurno()));
    }
}
