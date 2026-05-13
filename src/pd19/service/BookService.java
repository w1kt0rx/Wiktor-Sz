package pd19.service;

import pd19.domain.Book;
import pd19.dto.BookDto;

import java.util.List;

public interface BookService {
    public void addBook(BookDto book);
    public BookDto findByIsbn(String isbn);
    public List<BookDto> findAllAvailable();
    public List<BookDto> search(String query);
}
