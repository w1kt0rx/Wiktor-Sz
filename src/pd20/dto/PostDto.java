package pd20.dto;

public record PostDto(
        Long userId,
        Long id,
        String title,
        String body
) {
}
