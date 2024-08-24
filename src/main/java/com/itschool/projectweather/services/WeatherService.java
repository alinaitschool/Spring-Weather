package com.itschool.projectweather.services;

import com.itschool.projectweather.models.Weather;

import java.io.IOException;

public interface WeatherService {
    Weather getCityWeather(String city) throws IOException;

}
