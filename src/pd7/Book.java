package pd7;

import lombok.ToString;

public final class Book extends RentableResource {
    private int amountOfPages;

    public Book(String name, int basePrice, int amountOfPages) {
        super(ResourceType.BOOK, basePrice, name);
        this.amountOfPages = amountOfPages;
    }

    public static Book of(String name, int basePrice, int amountOfPages) {
        return new Book(name, basePrice, amountOfPages);
    }

    @Override
    public double calculatePrice() {
        return getBasePrice() * 1.56;
    }
}
