package pd19.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
public class Loan {
    private static long amountOfLoans = 0;
    private final long id;
    private final Book book;
    private final Member member;
    private final LocalDate borrowedAt;
    @Setter
    private LocalDate dueDate;
    private LocalDate returnedAt;

    private Loan(Book book, Member member, LocalDate borrowedAt, LocalDate dueDate) {
        id = ++amountOfLoans;
        this.book = book;
        this.member = member;
        this.borrowedAt = borrowedAt;
        this.dueDate = dueDate;
    }

    public static Loan of(Book book, Member member, LocalDate borrowedAt, LocalDate dueDate) {
        return new Loan(book, member, borrowedAt, dueDate);
    }

    public boolean isOverdue() {
        return returnedAt == null && dueDate.isBefore(LocalDate.now());
    }
}
