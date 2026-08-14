package open_weather.exceptions;

public class GeocodingCoordinatesNotFound extends RuntimeException {
    public GeocodingCoordinatesNotFound(String city) {
        super("coordinates not found for city " + city );
    }
}
