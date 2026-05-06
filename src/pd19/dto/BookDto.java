package pd19.dto;

import java.time.Year;

public record BookDto(String isbn, String title, String author, Year year) {
}
