package hassanproject.weather_api.Dto;

import lombok.Data;

@Data
public class DayDto {
    String datetime;
    float tempmax;
    float tempmin;
    float temp;
    float humidity;
    float visibility;
    String conditions;
    String description;
}
