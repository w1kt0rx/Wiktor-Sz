package pd20.dto;

import pd20.dto.userDto.UserDto;

import java.util.List;

public record UserReport(
        UserDto user,
        List<TodoDto> todos,
        List<PostDto> posts,
        WeatherDto weatherDto
) {
}
