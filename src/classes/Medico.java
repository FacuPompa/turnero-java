package src.classes;

import src.enums.Especialidad;

public class Medico {
    private String nombre;
    private String apellido;
    private Especialidad especialidad;
    private int idMedico;

    public Medico(String nombre, String apellido, Especialidad especialidad, int idMedico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }
    

}