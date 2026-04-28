package pd16.exception;

public class RentalNotFoundException extends RuntimeException {
    public RentalNotFoundException(Long id) {
        super("Nie znaleziono wypożyczenia o id: " + id);
    }
}
