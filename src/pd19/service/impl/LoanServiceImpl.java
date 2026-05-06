package pd19.service.impl;

import lombok.AllArgsConstructor;
import pd19.domain.Book;
import pd19.domain.Loan;
import pd19.domain.Member;
import pd19.dto.CreateLoanRequest;
import pd19.dto.LoanDto;
import pd19.dto.ReturnBookRequest;
import pd19.exception.BookNotFoundException;
import pd19.exception.LoanLimitExceededException;
import pd19.exception.LoanNotFoundException;
import pd19.exception.MemberNotFoundException;
import pd19.mapper.LoanMapper;
import pd19.repository.BookRepository;
import pd19.repository.LoanRepository;
import pd19.repository.MemberRepository;
import pd19.service.LoanService;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepo;
    private final MemberRepository memberRepo;
    private final BookRepository bookRepo;

    @Override
    public void borrow(CreateLoanRequest createLoanRequest) {
        Member member = memberRepo.findById(createLoanRequest.memberId()).orElseThrow( () -> new MemberNotFoundException("Nie znaleziono członka"));
        Book book = bookRepo.findById(createLoanRequest.bookId()).orElseThrow(() -> new BookNotFoundException("Nie znaleziono książki"));

        if(!member.canBorrow()) {
            throw new LoanLimitExceededException("Przekroczono limit wypożyczzeń");
        }
        book.borrow();
        Loan loan = Loan.of(loanRepo.getNextId(), book, member, LocalDate.now(), LocalDate.now().plusDays(14), null);
        loanRepo.save(loan);
        member.borrow(loan);
    }

    @Override
    public void returnBook(ReturnBookRequest returnBookRequest) {
        Loan loan = loanRepo.findById(returnBookRequest.loanId())
                .orElseThrow(() -> new LoanNotFoundException("Nie znaleziono wypożyczenia"));
        loanRepo.delete(loan);
        bookRepo.findById(loan.getId())
                .ifPresent(Book::returnBack);

    }

    @Override
    public List<LoanDto> findOverdue() {
        return loanRepo.findAll().stream()
                .filter(Loan::isOverdue)
                .map(LoanMapper::toDto)
                .toList();
    }
}
