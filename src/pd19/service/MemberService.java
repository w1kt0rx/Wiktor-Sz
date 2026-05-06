package pd19.service;

import pd19.domain.Loan;
import pd19.domain.Member;

import java.util.List;

public interface MemberService {
    public Member register(String name, String email);
    public Member findById(Long id);
    public List<Loan> getActiveLoans(Long memberId);
}
