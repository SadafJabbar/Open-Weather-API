package open_weather.provider;

import open_weather.domain.GeocodingResponse;
import open_weather.entity.OpenWeatherEntity;
import open_weather.exceptions.WeatherNotFound;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

@Component
public class OpenWeatherApiProvider {

    @Value("${weather.url}")
    private String weatherUrl;

    @Value("${api.key}")
    private String apiKey;

    private final RestClient restClient = RestClient.create();

    public OpenWeatherEntity provideOpenWeather(GeocodingResponse geocodingResponse) {
        try {
            OpenWeatherEntity openWeatherEntity = restClient.get()
                    .uri(weatherUrl
                            + "?lat=" + geocodingResponse.latitude()
                            + "&lon=" + geocodingResponse.longitude()
                            + "&appid=" + apiKey)
                    .retrieve()
                    .body(OpenWeatherEntity.class);

            if (openWeatherEntity == null) {
                throw new WeatherNotFound(
                        geocodingResponse.latitude(),
                        geocodingResponse.longitude()
                );
            }

            return openWeatherEntity;

        } catch (RestClientResponseException ex) {
            throw new WeatherNotFound(
                    geocodingResponse.latitude(),
                    geocodingResponse.longitude()
            );
        }
    }
}