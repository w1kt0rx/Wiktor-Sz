package pd7;

import lombok.ToString;

import java.math.BigDecimal;

public final class Book extends RentableResource {
    private final int amountOfPages;

    public Book(String name, BigDecimal basePrice, int amountOfPages) {
        super(ResourceType.BOOK, basePrice, name);
        this.amountOfPages = amountOfPages;
    }

    public static Book of(String name, BigDecimal basePrice, int amountOfPages) {
        return new Book(name, basePrice, amountOfPages);
    }

    @Override
    public BigDecimal calculatePrice() {
        return getBasePrice().multiply(BigDecimal.valueOf(1.56));
    }
}
