package hassanproject.weather_api.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Currency;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDto {

    private String resolvedAddress;
    private String description;
    List<DayDto> days;
    CurrentConditionsDto currentConditions;
}
