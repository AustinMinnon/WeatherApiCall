package com.example.guest.weatherforcast;

public class Constants {
    public static final String ApiKey = BuildConfig.ApiKey;

    public static final String baseUrl = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=imperial&cnt=7";
    public static final String WEATHER_LOCATION_QUERY_PARAMETER = "q";
    public static final String WEATHER_API_QUERY_PARAMETER = "appid";
}