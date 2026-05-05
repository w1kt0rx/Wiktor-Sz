package pd16.exception;

public class InvalidRentalStateException extends RuntimeException {
    public InvalidRentalStateException() {
        super("Gra nie była wypożyczona");
    }
}
