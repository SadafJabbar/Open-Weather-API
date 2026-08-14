package open_weather.transformer;


import open_weather.domain.WeatherResponse;
import open_weather.entity.OpenWeatherEntity;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherApiTranformer {
    public WeatherResponse transformOpenWeatherToResponse(OpenWeatherEntity openWeatherEntity){
        return WeatherResponse.builder()
                .latitude(openWeatherEntity.getCoordEntity().getLatitude())
                .longitude(openWeatherEntity.getCoordEntity().getLongitude())
                .id(openWeatherEntity.getWeatherEntities().get(0).getId())
                .main(openWeatherEntity.getWeatherEntities().get(0).getMain())
                .description(openWeatherEntity.getWeatherEntities().get(0).getDescription())
                .icon(openWeatherEntity.getWeatherEntities().get(0).getIcon())
                .build();

    }
}
