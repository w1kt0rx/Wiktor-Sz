package pd19.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
public class Loan {
    private long id;
    private Book book;
    private Member member;
    private LocalDate borrowedAt;
    @Setter
    private LocalDate dueDate;
    private LocalDate returnedAt;
    private LoanStatus status;

    private Loan(long id, Book book, Member member, LocalDate borrowedAt, LocalDate dueDate, LocalDate returnedAt) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.borrowedAt = borrowedAt;
        this.dueDate = dueDate;
        this.returnedAt = returnedAt;
        this.status = LoanStatus.ACTIVE;
    }

    public static Loan of(long id, Book book, Member member, LocalDate borrowedAt, LocalDate dueDate, LocalDate returnedAt){
        return new Loan(id, book, member, borrowedAt, dueDate, returnedAt);
    }

    public boolean isOverdue() {
        return returnedAt == null && dueDate.isBefore(LocalDate.now());
    }

    public void returnBook() {
        returnedAt = LocalDate.now();
        status = LoanStatus.FINISHED;
        book.returnBack();
    }

    public boolean isActive() {
        return status.equals(LoanStatus.ACTIVE);
    }
}
