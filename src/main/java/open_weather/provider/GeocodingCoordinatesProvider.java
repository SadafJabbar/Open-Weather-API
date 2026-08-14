package open_weather.provider;


import open_weather.entity.GeocodingEntity;
import open_weather.exceptions.GeocodingCoordinatesNotFound;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

@Component
public class GeocodingCoordinatesProvider {

    @Value("${geocoding.url}")
    private String geocodingUrl;

    @Value("${api.key}")
    private String apiKey;

    private final RestClient restClient = RestClient.create();

    public GeocodingEntity provideCoordinates(String city) {

        try {
            GeocodingEntity[] response = restClient.get()
                    .uri(geocodingUrl
                            + "?q=" + city
                            + "&limit=1"
                            + "&appid=" + apiKey)
                    .retrieve()
                    .body(GeocodingEntity[].class);

            if (response == null || response.length == 0) {
                throw new GeocodingCoordinatesNotFound(city);
            }

            return response[0];

        } catch (RestClientResponseException ex) {
            throw new GeocodingCoordinatesNotFound(city);
        }
    }
}