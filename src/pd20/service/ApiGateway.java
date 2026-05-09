package pd20.service;

import pd20.client.JsonPlaceHolderClient;
import pd20.client.WeatherClient;
import pd20.dto.PostDto;
import pd20.dto.TodoDto;
import pd20.dto.UserReport;
import pd20.dto.WeatherDto;
import pd20.dto.userDto.UserDto;

import java.util.Comparator;
import java.util.List;

public class ApiGateway {
    private final JsonPlaceHolderClient jsonClient = new JsonPlaceHolderClient();
    private final WeatherClient weatherClient = new WeatherClient();

    public UserReport getUserReport(Long userId) {
        UserDto user = jsonClient.getUser(userId).orElseThrow(() -> new RuntimeException("Nie znaleziono uzytkownika"));

        List<TodoDto> todos;
        try {
            todos = jsonClient.getTodos(userId).stream()
                    .filter(todo -> !todo.completed())
                    .toList();
        } catch (Exception e) {
            System.out.println("Coś poszło nie tak");
            System.err.println(e.getMessage());
            todos = List.of();
        }

        List<PostDto> posts;
        try {
            posts = jsonClient.getPosts(userId).stream()
                    .sorted(Comparator.comparing(PostDto::id).reversed())
                    .limit(3)
                    .toList();
        } catch (Exception e) {
            System.out.println("Coś poszło nie tak");
            System.err.println(e.getMessage());
            posts = List.of();
        }

        WeatherDto weather = null;
        try {
            weather = weatherClient.getWeather(Double.parseDouble(user.address().geo().lat()), Double.parseDouble(user.address().geo().lng()));
        } catch (Exception e) {
            System.out.println("Coś poszło nie tak");
            System.err.println(e.getMessage());
        }
        return new UserReport(
                user,
                todos,
                posts,
                weather
        );
    }

}
