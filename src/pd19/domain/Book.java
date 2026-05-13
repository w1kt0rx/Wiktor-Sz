package pd19.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pd19.exception.BookNotAvailableException;

import java.time.Year;

@ToString
@Getter
@AllArgsConstructor(staticName = "of")
public class Book {
    private long id;
    private String isbn;
    private String title;
    private String author;
    private Year year;
    private int availableCopies;

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
