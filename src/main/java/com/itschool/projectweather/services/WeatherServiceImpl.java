package com.itschool.projectweather.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.projectweather.models.entities.Weather;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService {
    private final String apiValue;
    private final String key;

    public WeatherServiceImpl(@Value("${weather.api.url}") String apiValue, @Value("${weather.api.key}") String key) {
        this.apiValue = apiValue;
        this.key = key;
    }

    @Override
    public Weather getCityWeather(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(apiValue + "key=" + key + "&q=" + city).build();
        Response response = client.newCall(request).execute();

        ObjectMapper objectMapper = new ObjectMapper();
        String responseBody = response.body().string();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime localDateTime = LocalDateTime.parse(jsonNode.get("current").get("last_updated").asText(), formatter);
        log.info(responseBody);
        Weather weatherResponse = buildWeatherResponse(jsonNode, localDateTime);
        return weatherResponse;
    }

    @NotNull
    private static Weather buildWeatherResponse(JsonNode jsonNode, LocalDateTime localDateTime) {
        Weather weatherResponse = new Weather();
        weatherResponse.setCity(jsonNode.get("location").get("name").asText());
        weatherResponse.setTemp(jsonNode.get("current").get("temp_c").asDouble());
        weatherResponse.setDescription(jsonNode.get("current").get("condition").get("text").asText());
        weatherResponse.setLastUpdated(localDateTime);
        return weatherResponse;
    }
}
