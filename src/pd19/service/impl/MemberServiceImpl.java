package pd19.service.impl;

import pd19.domain.Loan;
import pd19.domain.Member;
import pd19.exception.MemberNotFoundException;
import pd19.repository.MemberRepository;
import pd19.service.MemberService;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository repository;

    public MemberServiceImpl(MemberRepository repo) {
        repository = repo;
    }

    @Override
    public Member register(String name, String email) {
        Member member = Member.of(name, email);
        repository.save(member);
        return member;
    }

    @Override
    public Member findById(Long id) {
        return repository.findById(id).orElseThrow(() ->new MemberNotFoundException("Nie znaleziono uzytkownika"));
    }

    @Override
    public List<Loan> getActiveLoans(Long memberId) {
        Member member = repository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("Nie znaleziono uzytkownika"));

        return member.getLoans().stream()
                .filter(l -> l.getReturnedAt() == null)
                .toList();
    }
}
