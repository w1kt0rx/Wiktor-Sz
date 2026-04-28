package pd16.exception;

public class RentalOwnershipException extends RuntimeException {
    public RentalOwnershipException() {
        super("Wypożyczenie jest innego użytkownika");
    }
}
