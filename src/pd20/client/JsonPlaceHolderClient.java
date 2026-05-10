package pd20.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pd20.dto.PostDto;
import pd20.dto.TodoDto;
import pd20.dto.userDto.UserDto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class JsonPlaceHolderClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .followRedirects(HttpClient.Redirect.NORMAL)
            .version(HttpClient.Version.HTTP_2)
            .build();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Optional<UserDto> getUser(Long id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/users/" + id))
                    .header("Accept", "application/json")
                    .header("User-Agent", "JavaHttpClient")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            UserDto user = objectMapper.readValue(response.body(), UserDto.class);
            return Optional.ofNullable(user);
        } catch (Exception e) {
            System.out.println("Coś poszło nie tak podczas pobierania user'ów");
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }

    public List<TodoDto> getTodos(Long userId) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/users/" + userId + "/todos"))
                    .header("Accept", "application/json")
                    .header("User-Agent", "JavaHttpClient")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return objectMapper.readValue(
                    response.body(),
                    new TypeReference<>() {
                    }
            );

        } catch (Exception e) {
            System.out.println("Coś poszło nie tak podczas pobierania tasków");
            System.err.println(e.getMessage());
            return List.of();
        }
    }

    public List<PostDto> getPosts(Long userId) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/users/" + userId + "/posts"))
                    .header("Accept", "application/json")
                    .header("User-Agent", "JavaHttpClient")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return objectMapper.readValue(
                    response.body(),
                    new TypeReference<>() {
                    }
            );

        } catch (Exception e) {
            System.out.println("Coś poszło nie tak podczas pobierania postów");
            System.err.println(e.getMessage());
            return List.of();
        }
    }
}
