package com.quiz.weather_histroy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_histroy.bo.WeatherHistoryBO;
import com.quiz.weather_histroy.domain.WeatherHistory;

@Controller
@RequestMapping("/weather")
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// 날씨 추가 기능 weather-history/add-weather
	@PostMapping("/add-weather")
	public String addWeather(
			@RequestParam("date") String date,
			@RequestParam("weather") String weather,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed) {
		
		
		return "";
	}
	
	// 날씨 추가 화면
	// http://localhost:8080/weather/add-weather-view
	@GetMapping("/add-weather-view")
	public String addWeatherView(
			@RequestParam("date") String date,
			@RequestParam("weather") String weather,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed) {
		
		weatherHistoryBO.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return "weather_history/addWeather";
	}
	
	// 날씨
	// http://localhost:8080/weather/weather-list-view
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		
		// select db
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		
		//model 담기
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		// 화면 이동
		return "weather_history/weatherList";
	}
	
	
}
