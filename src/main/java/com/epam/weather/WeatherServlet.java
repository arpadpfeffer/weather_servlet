package com.epam.weather;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.weather.service.WeatherService;

public class WeatherServlet extends HttpServlet{
	private static final String CITY = "city";
	private static final String TEMP = "temp";
	private WeatherService weatherService = new WeatherService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cityName = req.getParameter(CITY);
		
		double temp = 0.0;
		try {
			temp = weatherService.getWeather(cityName);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(temp);
		req.setAttribute(TEMP, temp);

		req.getRequestDispatcher("weather.jsp").forward(req, res);
	}
	
}
