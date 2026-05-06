package pd19.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pd19.domain.Loan;
import pd19.dto.LoanDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LoanMapper {
    public static LoanDto toDto(Loan loan) {
        return new LoanDto(BookMapper.toDto(loan.getBook()), MemberMapper.toDto(loan.getMember()), loan.getBorrowedAt(), loan.getDueDate(), loan.getReturnedAt());
    }
}
