package pd19.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pd19.domain.Member;
import pd19.dto.MemberDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MemberMapper {

    public static MemberDto toDto(Member member) {
        return new MemberDto(member.getName(), member.getEmail());
    }

    public static Member toEntity(MemberDto memberDto, long id) {
        return Member.of(id, memberDto.name(), memberDto.email());
    }
}
