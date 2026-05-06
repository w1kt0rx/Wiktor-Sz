package pd19.repository;

import pd19.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemberRepository {
    private final Map<Long, Member> memberMap = new HashMap<>();

    public void save(Member member) {
        memberMap.put(member.getId(), member);
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
}
