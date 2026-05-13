package pd20.dto;

public record TodoDto(
        Long userId,
        Long id,
        String title,
        boolean completed
) {
}
