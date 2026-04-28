package pd16.exception;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(Long id) {
        super("Nie znaleziono gry od id: " + id);
    }
}
