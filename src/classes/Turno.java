package src.classes;

import src.enums.EstadoTurno;
import java.time.*;

public class Turno {
    private LocalDate fecha;
    private LocalTime hora;
    private Medico medico;
    private Paciente paciente;
    private EstadoTurno estadoTurno;
    private int idTurno;

    public Turno(LocalDate fecha, LocalTime hora, Medico medico, Paciente paciente, int idTurno) {
        this.fecha = fecha;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
        this.estadoTurno = EstadoTurno.PENDIENTE;
        this.idTurno = idTurno;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public EstadoTurno getEstadoTurno() {
        return estadoTurno;
    }
    public void setEstadoTurno(EstadoTurno estadoTurno) {
        this.estadoTurno = estadoTurno;
    }
    public int getIdTurno() {
        return idTurno;
    }
    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }
}
