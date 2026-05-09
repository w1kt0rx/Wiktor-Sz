package pd20.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pd20.dto.WeatherDto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

public class WeatherClient {
    private final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .followRedirects(HttpClient.Redirect.NORMAL)
            .version(HttpClient.Version.HTTP_2)
            .build();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WeatherDto getWeather(double lat, double lon) {
        try {
            String url = String.format("https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&current_weather=true", lat, lon);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .header("User-Agent", "JavaHttpClient")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonNode root = objectMapper.readTree(response.body());
            JsonNode currentWeather = root.get(0).get("current_weather");
            return new WeatherDto(
                    currentWeather.get("temperature").asDouble(),
                    currentWeather.get("windspeed").asDouble()
            );

        } catch (Exception e) {
            System.out.println("Coś poszlo nie tak");
            System.err.println(e.getMessage());
            return null;
        }
    }
}
