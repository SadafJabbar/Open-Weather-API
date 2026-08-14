package open_weather.domain;

import lombok.Builder;

@Builder
public record GeocodingResponse(
        Double latitude,
        Double longitude
) {
}
