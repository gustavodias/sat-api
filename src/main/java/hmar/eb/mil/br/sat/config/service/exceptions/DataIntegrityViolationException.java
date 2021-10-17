package hmar.eb.mil.br.sat.config.service.exceptions;

public class DataIntegrityViolationException extends RuntimeException{


    public DataIntegrityViolationException(String message) {
        super(message);
    }

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
