package com.quiz.weather_histroy.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_histroy.domain.WeatherHistory;
import com.quiz.weather_histroy.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
//	@RequestParam("date") String date, // LocalDate여도 됨
//	@RequestParam("weather") String weather,
//	@RequestParam("temperatures") double temperatures,
//	@RequestParam("precipitation") double precipitation,
//	@RequestParam("microDust") String microDust,
//	@RequestParam("windSpeed") double windSpeed
	
	
	public void addWeatherHistory(String date, String weather, double temperatures, double precipitation,
			String microDust, double windSpeed) {
		
		weatherHistoryMapper.insertWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
	
	// input: X
	// output: List<WeatherHistory>
	
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
	
	
}
