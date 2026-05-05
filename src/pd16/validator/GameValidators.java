package pd16.validator;

import pd16.exception.EmptyGameException;
import pd16.exception.InvalidPriceException;

import java.math.BigDecimal;

public class GameValidators {
    public static void validateGame(String name, BigDecimal price) {
        if (name == null || name.isBlank()) throw new EmptyGameException();
        if (price.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidPriceException();
    }
}
