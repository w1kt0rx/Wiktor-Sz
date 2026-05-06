package pd19.service;

import pd19.domain.Loan;

import java.util.List;

public interface LoanService {
    public void borrow(Long memberId, Long bookId);
    public void returnBook(Long loanId);
    public List<Loan> findOverdue();
}
