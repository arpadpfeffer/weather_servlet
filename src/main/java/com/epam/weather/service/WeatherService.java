package com.epam.weather.service;

import com.epam.weather.dao.WeatherDao;
import com.epam.weather.model.CityWeather;

public class WeatherService {
	
	private WeatherDao weatherDao = new WeatherDao();
	
	public double getWeather(String city) throws Exception {
		
		return weatherDao.getWeather(city).getMain().getTemp();
	}
}
