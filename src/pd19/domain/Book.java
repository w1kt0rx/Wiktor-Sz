package pd19.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pd19.exception.BookNotAvailableException;

import java.time.Year;

@ToString
@Getter
public class Book {
    private static long amountOfBooks = 0;
    private final long id;
    private final String isbn;
    private final String title;
    private final String author;
    private final Year year;
    @Setter
    private int availableCopies;

    private Book(String isbn, String title, String author, Year year, int availableCopies) {
        id = ++amountOfBooks;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.availableCopies = availableCopies;
    }

    public static Book of(String isbn, String title, String author, Year year, int availableCopies) {
        return new Book(isbn, title, author, year, availableCopies);
    }

    public void borrow() {
        if (availableCopies <= 0) {
            throw new BookNotAvailableException("Ksiązka nie jest dostępna");
        } else {
            availableCopies--;
        }
    }

    public void returnBack() {
        availableCopies++;
    }

    public boolean isAvailable() {
        return availableCopies > 0;
    }
}
