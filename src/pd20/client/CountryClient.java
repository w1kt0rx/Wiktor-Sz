package pd20.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pd20.dto.CountryDto;
import pd20.dto.WeatherDto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

public class CountryClient {
    private final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .followRedirects(HttpClient.Redirect.NORMAL)
            .version(HttpClient.Version.HTTP_2)
            .build();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Optional<CountryDto> getCountry(String name) {
        try {
                String url = String.format("https://restcountries.com/v3.1/name/%s", name);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .header("User-Agent", "JavaHttpClient")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonNode root = objectMapper.readTree(response.body());
            JsonNode country = root.get(0);
            return Optional.of(new CountryDto(
                    country.get("name").get("official").asText(),
                    country.get("population").asLong(),
                    country.get("region").asText())
            );
        } catch (Exception e) {
            System.out.println("Coś poszło nie tak");
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }
}
