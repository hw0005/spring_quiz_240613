package com.quiz.weather_histroy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.weather_histroy.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryMapper {
	public void insertWeather(
			@Param("date") String date, 
			@Param("weather") String weather, 
			@Param("temperatures") double temperatures, 
			@Param("precipitation") double precipitation, 
			@Param("microDust") String microDust, 
			@Param("windSpeed") double windSpeed);
	
	public List<WeatherHistory> selectWeatherHistoryList();
}
