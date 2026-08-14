# OpenWeather API

A Spring Boot REST API that accepts a city name, converts it into latitude and longitude coordinates using OpenWeather's Geocoding API, and retrieves current weather data using those coordinates.

## Features

* Search weather by city name
* Convert city names into latitude and longitude coordinates
* Retrieve current weather information
* Return a simplified weather response
* Custom exception handling
* Layered architecture using controllers, services, providers, transformers, entities, and domain records

## API Endpoint

### Get Weather by City

```text
GET /api/v1/weather/{city}
```

Example:

```text
GET /api/v1/weather/London
```

## Response

```json
{
  "latitude": 51.5072,
  "longitude": -0.1276,
  "id": 800,
  "main": "Clear",
  "description": "clear sky",
  "icon": "01d"
}
```

## Application Flow

```text
City Name
    ↓
Weather Controller
    ↓
Weather Service
    ↓
Geocoding Provider
    ↓
Latitude + Longitude
    ↓
OpenWeather Provider
    ↓
Weather Data
    ↓
Weather Transformer
    ↓
WeatherResponse
    ↓
API Response
```

## Project Structure

```text
src/main/java/open_weather
│
├── controller
│   └── WeatherController
│
├── service
│   └── WeatherService
│
├── provider
│   ├── GeocodingCoordinatesProvider
│   └── OpenWeatherApiProvider
│
├── transformer
│   ├── GeocodingCoordinatesTransformer
│   └── OpenWeatherApiTranformer
│
├── entity
│   ├── GeocodingEntity
│   ├── CoordEntity
│   ├── OpenWeatherEntity
│   └── WeatherEntity
│
├── domain
│   ├── GeocodingResponse
│   └── WeatherResponse
│
└── exceptions
    ├── GeocodingCoordinatesNotFound
    ├── WeatherNotFound
    └── GlobalExceptions
```

## Technologies

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring RestClient**
* **Lombok**
* **Jackson**
* **Maven**
* **OpenWeather API**
* **YAML Configuration**

## External APIs

The application uses OpenWeather for:

* **Geocoding API** — converts a city name into latitude and longitude coordinates.
* **Current Weather API** — retrieves weather information using latitude and longitude.

## Error Handling

The API handles cases where:

* Coordinates cannot be found for the requested city
* Weather data cannot be retrieved
* An unexpected server error occurs

Custom error responses include:

* Timestamp
* Error message
* HTTP status
* Request path

API credentials are kept in the application's configuration rather than hard-coded into the Java classes.
