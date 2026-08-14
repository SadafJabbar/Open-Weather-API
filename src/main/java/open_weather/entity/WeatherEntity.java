package open_weather.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherEntity {

    private int id;
    private String main;
    private String description;
    private String icon;

}
