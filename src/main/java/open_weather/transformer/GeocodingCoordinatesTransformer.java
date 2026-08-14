package open_weather.transformer;

import open_weather.domain.GeocodingResponse;
import open_weather.entity.GeocodingEntity;
import org.springframework.stereotype.Component;

@Component
public class GeocodingCoordinatesTransformer {

    public GeocodingResponse transformCordinatesToResponse(GeocodingEntity geocodingEntity){
        return GeocodingResponse.builder()
                .latitude(geocodingEntity.getLatitude())
                .longitude(geocodingEntity.getLongitude())
                .build();
    }
}
