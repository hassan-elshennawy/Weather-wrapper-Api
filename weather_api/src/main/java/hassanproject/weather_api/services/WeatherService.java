package hassanproject.weather_api.services;

import com.fasterxml.jackson.databind.JsonNode;
import hassanproject.weather_api.Dto.WeatherDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value("${visualcrossing.api.key}")
    private String apiKey;

    public WeatherService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build() ;
    }

    @Cacheable(key = "#location", value = "weatherCache")
    public WeatherDto getWeather(String location){
        String url = String.format("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s?unitGroup=metric&key=%s&contentType=json",location,apiKey);
        ResponseEntity<WeatherDto> response = restTemplate.getForEntity(url,WeatherDto.class);

        if(response.getStatusCode().is2xxSuccessful())
            return response.getBody();
        else{
            throw new RuntimeException("Failed to fetch weather Data");
        }
    }
}
