package com.itschool.projectweather.services;

import com.itschool.projectweather.models.Weather;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Override
    public Weather getCityWeather(String city) throws IOException {
        return null;
    }
}
