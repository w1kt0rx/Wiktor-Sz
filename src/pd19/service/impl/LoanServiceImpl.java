package pd19.service.impl;

import pd19.domain.Book;
import pd19.domain.Loan;
import pd19.domain.Member;
import pd19.exception.BookNotFoundException;
import pd19.exception.LoanLimitExceededException;
import pd19.exception.LoanNotFoundException;
import pd19.exception.MemberNotFoundException;
import pd19.repository.BookRepository;
import pd19.repository.LoanRepository;
import pd19.repository.MemberRepository;
import pd19.service.LoanService;

import java.time.LocalDate;
import java.util.List;

public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepo;
    private final MemberRepository memberRepo;
    private final BookRepository bookRepo;

    public LoanServiceImpl(LoanRepository loanRepo, MemberRepository memberRepo, BookRepository bookRepo) {
        this.loanRepo = loanRepo;
        this.memberRepo = memberRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void borrow(Long memberId, Long bookId) {
        Member member = memberRepo.findById(memberId).orElseThrow( () -> new MemberNotFoundException("Nie znaleziono członka"));
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new BookNotFoundException("Nie znaleziono książki"));

        if(!member.canBorrow()) {
            throw new LoanLimitExceededException("Przekroczono limit wypożyczzeń");
        }
        book.borrow();
        Loan loan = Loan.of(book, member, LocalDate.now(), LocalDate.now().plusDays(14));
        loanRepo.save(loan);
        member.addLoan(loan);
    }

    @Override
    public void returnBook(Long loanId) {
        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new LoanNotFoundException("Nie znaleziono wypożyczenia"));
        loanRepo.delete(loan);
        bookRepo.findById(loan.getId()).ifPresent(Book::returnBack);

    }

    @Override
    public List<Loan> findOverdue() {
        return loanRepo.findAll().stream()
                .filter(Loan::isOverdue)
                .toList();
    }
}
