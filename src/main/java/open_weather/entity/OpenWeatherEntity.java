package open_weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherEntity {


    @JsonProperty("coord")
    private CoordEntity coordEntity;
    @JsonProperty("weather")
    private List<WeatherEntity> weatherEntities;

}
