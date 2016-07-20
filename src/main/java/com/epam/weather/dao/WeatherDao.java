package com.epam.weather.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.epam.weather.components.CityWeatherFactory;
import com.epam.weather.model.CityWeather;
import com.epam.weather.model.UrlRequestParameters;

public class WeatherDao {
	private static final String APPID = "46afc160d51a3e325f44a9611d2642d7";
	private static final String UNITS = "metric";
	
	private CityWeatherFactory cityWeatherFactory = new CityWeatherFactory(); 
	
	public CityWeather getWeather(String cityName) throws Exception {
		String actualWeather = sendGet(cityName);	
		
		return cityWeatherFactory.createFrom(actualWeather);
	}
	
	private String sendGet(String cityName) throws Exception {

		String url = "http://api.openweathermap.org/data/2.5/weather?" + UrlRequestParameters.CITYNAME.getParamName() + cityName + "&" 
				+ UrlRequestParameters.APPID.getParamName() + APPID +"&" + UrlRequestParameters.UNITS.getParamName() + UNITS;
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println("Result: " + response.toString());
		
		return response.toString();

	}
}
