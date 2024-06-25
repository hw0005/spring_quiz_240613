package com.quiz.weather_histroy.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_histroy.domain.WeatherHistory;
import com.quiz.weather_histroy.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	public void addWeather(String date, String weather, double temperatures, double precipitation, String microDust, double windSpeed) {
		weatherHistoryMapper.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
	
	// input: X
	// output: List<WeatherHistory>
	
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
	
	
}
