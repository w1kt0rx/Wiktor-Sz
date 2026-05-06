package pd19.service.impl;

import pd19.domain.Book;
import pd19.exception.BookNotFoundException;
import pd19.repository.BookRepository;
import pd19.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookRepository repository;

    public BookServiceImpl(BookRepository repo) {
        repository = repo;
    }

    @Override
    public void addBook(Book book) {
        repository.save(book);
    }

    @Override
    public Book findByIsbn(String isbn) {
        return repository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException("Nie znalezniono ksiązki"));
    }

    @Override
    public List<Book> findAvailable() {
        return repository.findAll().stream()
                .filter(Book::isAvailable)
                .toList();
    }

    @Override
    public List<Book> search(String query) {
        String q = query.toLowerCase();

        return repository.findAll().stream()
                .filter(book ->
                        book.getTitle().toLowerCase().contains(q)
                || book.getAuthor().toLowerCase().contains(q)
                || book.getIsbn().toLowerCase().contains(q))
                .toList();
    }
}
