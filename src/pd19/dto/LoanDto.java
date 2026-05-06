package pd19.dto;

import pd19.domain.Book;
import pd19.domain.Member;

import java.time.LocalDate;

public record LoanDto(Book book, Member member, LocalDate borrowedAt, LocalDate dueDate) {
}
