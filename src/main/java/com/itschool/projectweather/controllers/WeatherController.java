package com.itschool.projectweather.controllers;

import com.itschool.projectweather.models.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class WeatherController {

    @GetMapping("/api/weather")
    public ResponseEntity<Weather> getWeather(@RequestParam String city){
     return ResponseEntity.ok(null);
    }
}
