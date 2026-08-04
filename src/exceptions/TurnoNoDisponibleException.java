package src.exceptions;

public class TurnoNoDisponibleException extends RuntimeException {
    public TurnoNoDisponibleException() {
        super("El médico ya tiene un turno asignado en esa fecha y hora.");
    }
}
