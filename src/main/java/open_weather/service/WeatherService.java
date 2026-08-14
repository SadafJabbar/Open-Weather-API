package open_weather.service;

import open_weather.domain.GeocodingResponse;
import open_weather.domain.WeatherResponse;
import open_weather.entity.GeocodingEntity;
import open_weather.entity.OpenWeatherEntity;
import open_weather.provider.GeocodingCoordinatesProvider;
import open_weather.provider.OpenWeatherApiProvider;
import open_weather.transformer.GeocodingCoordinatesTransformer;
import open_weather.transformer.OpenWeatherApiTranformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final GeocodingCoordinatesTransformer geocodingCoordinatesTransformer;
    private final OpenWeatherApiTranformer openWeatherApiTranformer;
    private final GeocodingCoordinatesProvider geocodingCoordinatesProvider;
    private final OpenWeatherApiProvider openWeatherApiProvider;

    @Autowired
    public WeatherService(GeocodingCoordinatesTransformer geocodingCoordinatesTransformer,
                          OpenWeatherApiTranformer openWeatherApiTranformer,
                          GeocodingCoordinatesProvider geocodingCoordinatesProvider,
                          OpenWeatherApiProvider openWeatherApiProvider){
        this.geocodingCoordinatesTransformer=geocodingCoordinatesTransformer;
        this.openWeatherApiTranformer=openWeatherApiTranformer;
        this.geocodingCoordinatesProvider=geocodingCoordinatesProvider;
        this.openWeatherApiProvider=openWeatherApiProvider;
    }


    public WeatherResponse weatherByCity(String city){

        GeocodingEntity geocodingEntity =geocodingCoordinatesProvider
                .provideCoordinates(city);

        GeocodingResponse geocodingResponse=geocodingCoordinatesTransformer
                .transformCordinatesToResponse(geocodingEntity);

      OpenWeatherEntity openWeatherEntity =openWeatherApiProvider
                .provideOpenWeather(geocodingResponse);

        WeatherResponse weatherResponse=openWeatherApiTranformer
                .transformOpenWeatherToResponse(openWeatherEntity);

        return weatherResponse;

    }
}
