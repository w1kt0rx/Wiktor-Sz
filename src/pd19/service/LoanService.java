package pd19.service;

import pd19.domain.Loan;
import pd19.dto.CreateLoanRequest;
import pd19.dto.LoanDto;
import pd19.dto.ReturnBookRequest;

import java.util.List;

public interface LoanService {
    public void borrow(CreateLoanRequest createLoanRequest);
    public void returnBook(ReturnBookRequest returnBookRequest);
    public List<LoanDto> findOverdue();
}
