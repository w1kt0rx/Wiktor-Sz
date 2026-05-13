package pd19.service.impl;

import lombok.AllArgsConstructor;
import pd19.domain.Member;
import pd19.dto.LoanDto;
import pd19.dto.MemberDto;
import pd19.exception.MemberNotFoundException;
import pd19.mapper.LoanMapper;
import pd19.mapper.MemberMapper;
import pd19.repository.MemberRepository;
import pd19.service.MemberService;

import java.util.List;
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository repository;

    @Override
    public void register(MemberDto memberDto) {
        Member member = Member.of(repository.getNextId(),memberDto.name(), memberDto.email());
        repository.save(member);
    }

    @Override
    public MemberDto findById(Long id) {
        Member member = repository.findById(id).orElseThrow(() -> new MemberNotFoundException("Nie znaleziono uzytkownika"));
        return MemberMapper.toDto(member);
    }

    @Override
    public List<LoanDto> getActiveLoans(Long memberId) {
        return repository.getActiveLoans(memberId).stream()
                .map(LoanMapper::toDto)
                .toList();
    }
}
