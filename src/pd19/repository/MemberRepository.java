package pd19.repository;

import pd19.domain.Loan;
import pd19.domain.Member;
import pd19.dto.MemberDto;
import pd19.exception.MemberNotFoundException;
import pd19.mapper.MemberMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemberRepository {
    private final Map<Long, Member> memberMap = new HashMap<>();
    private long idCounter = 0;

    public MemberDto save(Member member) {
        memberMap.put(member.getId(), member);
        return MemberMapper.toDto(member);
    }

    public void delete(Member member) {
        memberMap.remove(member.getId());
    }

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(memberMap.get(id));
    }

    public List<Member> findAll() {
        return memberMap.values().stream().toList();
    }

    public List<Loan> getActiveLoans(long memberId) {
        return memberMap.values().stream()
                .filter(member -> member.getId() == memberId)
                .findFirst()
                .map(Member::getLoans)
                .orElseThrow(() -> new MemberNotFoundException("Nie znaleziono uzytkownika"))
                .stream()
                .filter(Loan::isActive)
                .toList();
    }
    public long getNextId() {
        return ++idCounter;
    }
}
