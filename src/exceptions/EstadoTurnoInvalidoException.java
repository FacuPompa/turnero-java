package src.exceptions;

public class EstadoTurnoInvalidoException extends RuntimeException {
    public EstadoTurnoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
