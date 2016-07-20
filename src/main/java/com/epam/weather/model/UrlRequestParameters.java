package com.epam.weather.model;

public enum UrlRequestParameters {
	CITYNAME("q="),
	APPID("appid="),
	UNITS("units=");
	
	private final String paramName;

	private UrlRequestParameters(String paramName) {
		this.paramName = paramName;
	}

	public String getParamName() {
		return paramName;
	}
}
