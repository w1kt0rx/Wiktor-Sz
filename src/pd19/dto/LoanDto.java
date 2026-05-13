package pd19.dto;

import java.time.LocalDate;

public record LoanDto(BookDto book, MemberDto member, LocalDate borrowedAt, LocalDate dueDate, LocalDate returnedAt) {
}
