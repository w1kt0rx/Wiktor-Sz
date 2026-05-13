package pd19.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pd19.domain.Book;
import pd19.dto.BookDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BookMapper {

    public static BookDto toDto(Book book) {
        return new BookDto(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getYear(), book.getAvailableCopies());
    }

    public static Book toEntity(BookDto bookDto, long id) {
        return Book.of(id, bookDto.isbn(), bookDto.title(), bookDto.author(), bookDto.year(), bookDto.availableCopies());
    }
}
