package pd19.service;

import pd19.domain.Loan;
import pd19.domain.Member;
import pd19.dto.LoanDto;
import pd19.dto.MemberDto;

import java.util.List;

public interface MemberService {
    public void register(MemberDto memberDto);
    public MemberDto findById(Long id);
    public List<LoanDto> getActiveLoans(Long memberId);
}
