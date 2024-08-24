package com.itschool.projectweather;

import com.itschool.projectweather.services.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class ProjectweatherApplicationTests {

	@Test
	void contextLoads() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ProjectweatherApplication.class);
		GreetingService greetingService = context.getBean(GreetingService.class);
		String greeting = greetingService.greet();
		System.out.println(greeting);
	}
}
