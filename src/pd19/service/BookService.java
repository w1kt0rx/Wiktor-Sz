package pd19.service;

import pd19.domain.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public Book findByIsbn(String isbn);
    public List<Book> findAvailable();
    public List<Book> search(String query);
}
