package src.exceptions;

public class IdDuplicadoException extends RuntimeException {
    public IdDuplicadoException(String entidad, int id) {
        super("Ya existe un " + entidad + " con el ID " + id + ".");
    }
}
