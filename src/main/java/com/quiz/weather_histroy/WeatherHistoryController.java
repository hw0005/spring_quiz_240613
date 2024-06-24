package com.quiz.weather_histroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weather_history")
public class WeatherHistoryController {
	
	// https://localhost:8080/weather/weather-list-view
	@GetMapping("/weather-list-view")
	public String weatherListView() {
		
		return "weather_history/weatherList";
	}
	
	
}
