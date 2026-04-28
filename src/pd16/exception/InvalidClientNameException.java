package pd16.exception;

public class InvalidClientNameException extends RuntimeException {
    public InvalidClientNameException(String name) {
        super("Imię powinno zawierać conajmniej 2 litery: " + name);
    }
}
