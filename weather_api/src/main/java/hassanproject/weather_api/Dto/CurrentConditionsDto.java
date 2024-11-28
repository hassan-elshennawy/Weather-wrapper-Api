package hassanproject.weather_api.Dto;

import lombok.Data;

@Data
public class CurrentConditionsDto {
    String datetime;
    float temp;
    float humidity;
    float visibility;

}
