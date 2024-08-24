package com.itschool.projectweather;

import com.itschool.projectweather.services.GreetingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectweatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectweatherApplication.class, args);
    }
@Bean
   public  GreetingService greetingService() {
    return new GreetingService("Hello world");
}
}
