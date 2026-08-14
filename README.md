OpenWeather API

A Spring Boot REST API that accepts a city name, converts it into geographic coordinates using OpenWeather's Geocoding API, and then retrieves the current weather for those coordinates using the OpenWeather API.

Features
Search weather by city name
Convert city names into latitude and longitude
Retrieve current weather data using coordinates
Return a simplified weather response
Custom exception handling for missing coordinates and weather data
Layered architecture using controllers, services, providers, entities, transformers, and DTOs
Response

The API returns only the relevant weather information:

{
"latitude": 51.5072,
"longitude": -0.1276,
"id": 800,
"main": "Clear",
"description": "clear sky",
"icon": "01d"
}
API Endpoint
GET /api/v1/weather/{city}

Example:

GET /api/v1/weather/London


Flow
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
Transformer
↓
WeatherResponse
↓
API Response


Project Structure
controller
└── WeatherController
service
└── WeatherService
provider
├── GeocodingCoordinatesProvider
└── OpenWeatherApiProvider
transformer
├── GeocodingCoordinatesTransformer
└── OpenWeatherApiTranformer
entity
├── GeocodingEntity
├── CoordEntity
├── OpenWeatherEntity
└── WeatherEntity
domain
├── GeocodingResponse
└── WeatherResponse
exceptions
├── GeocodingCoordinatesNotFound
├── WeatherNotFound
└── GlobalExceptions


Technologies
Java
Spring Boot
Spring Web
Spring RestClient
Lombok
Jackson
Maven
OpenWeather API
YAML configuration
External APIs

The application uses OpenWeather for:

Geocoding — converts a city name into coordinates
Current Weather — retrieves weather information using latitude and longitude

API credentials are kept in the application's configuration rather than hard-coded into the Java classes.