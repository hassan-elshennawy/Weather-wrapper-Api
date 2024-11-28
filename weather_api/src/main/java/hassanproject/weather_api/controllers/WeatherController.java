package hassanproject.weather_api.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import hassanproject.weather_api.Dto.WeatherDto;
import hassanproject.weather_api.services.WeatherService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }
    @GetMapping("/weather/{location}")
    public WeatherDto get_weather(@PathVariable String location){

        return weatherService.getWeather(location) ;
    }

}
