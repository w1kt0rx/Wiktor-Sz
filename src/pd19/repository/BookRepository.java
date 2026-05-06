package pd19.repository;

import lombok.ToString;
import pd19.domain.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ToString
public class BookRepository {
    private final Map<Long, Book> bookMap = new HashMap<>();

    public void save(Book book) {
        bookMap.put(book.getId(), book);
    }

    public void delete(Book book) {
        bookMap.remove(book.getId());
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(bookMap.get(id));
    }

    public Optional<Book> findByIsbn(String isbn) {
        return bookMap.values().stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();
    }

    public List<Book> findAll() {
        return bookMap.values().stream().toList();
    }
}
