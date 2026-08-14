package open_weather.exceptions;

public class WeatherNotFound extends RuntimeException {
    public WeatherNotFound(Double lat,Double lon) {
        super("weather not found for coordinates lat: " + lat + "and lon: " + lon);
    }
}
