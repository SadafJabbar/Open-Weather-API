package open_weather.domain;

import lombok.Builder;

@Builder
public record WeatherResponse(
        Double latitude,
        Double longitude ,
        int id,
      String main,
      String description,
      String icon
) {
}
