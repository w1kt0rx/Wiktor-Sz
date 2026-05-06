package pd19.service.impl;

import lombok.AllArgsConstructor;
import pd19.domain.Book;
import pd19.dto.BookDto;
import pd19.exception.BookNotFoundException;
import pd19.mapper.BookMapper;
import pd19.repository.BookRepository;
import pd19.service.BookService;

import java.util.List;
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;

    @Override
    public void addBook(BookDto book) {
        repository.save(BookMapper.toEntity(book, repository.getNextId()));
    }

    @Override
    public BookDto findByIsbn(String isbn) {
        Book book = repository.findByIsbn(isbn).orElseThrow(() -> new BookNotFoundException("Nie znalezniono ksiązki"));
        return BookMapper.toDto(book);
    }

    @Override
    public List<BookDto> findAllAvailable() {
        return repository.findAll().stream()
                .filter(Book::isAvailable)
                .map(BookMapper::toDto)
                .toList();
    }

    @Override
    public List<BookDto> search(String query) {
        String q = query.toLowerCase();

        return repository.findAll().stream()
                .filter(book ->
                        book.getTitle().toLowerCase().contains(q)
                || book.getAuthor().toLowerCase().contains(q)
                || book.getIsbn().toLowerCase().contains(q))
                .map(BookMapper::toDto)
                .toList();
    }
}
