package open_weather.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(GeocodingCoordinatesNotFound.class)
    public ResponseEntity<Map<String,Object>> coordinatesException(GeocodingCoordinatesNotFound ex
            , WebRequest webRequest){
        Map<String,Object> map=new HashMap<>();
        map.put("timestamp", LocalDateTime.now());
        map.put("message",ex.getMessage());
        map.put("status", HttpStatus.NOT_FOUND.value());
        map.put("path",webRequest.getDescription(false).replace("uri=",""));
        return  new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WeatherNotFound.class)
    public ResponseEntity<Map<String,Object>> weatherException(WeatherNotFound ex
            , WebRequest webRequest){
        Map<String,Object> map=new HashMap<>();
        map.put("timestamp", LocalDateTime.now());
        map.put("message",ex.getMessage());
        map.put("status", HttpStatus.NOT_FOUND.value());
        map.put("path",webRequest.getDescription(false).replace("uri=",""));
        return  new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> globalException(Exception ex, WebRequest webRequest){
        Map<String,Object> map=new HashMap<>();
        map.put("timestamp", LocalDateTime.now());
        map.put("message",ex.getMessage());
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("path",webRequest.getDescription(false).replace("uri=",""));
        return  new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
