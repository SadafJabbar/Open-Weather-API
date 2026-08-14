package open_weather.controller;


import open_weather.domain.WeatherResponse;
import open_weather.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;
    public WeatherController(WeatherService weatherService){
        this.weatherService=weatherService;
    }

    @GetMapping("/{city}")
    public WeatherResponse getWeather(@PathVariable("city") String city){
        return weatherService.weatherByCity(city);
    }
}
