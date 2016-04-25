package com.example.guest.weatherforcast;

import android.os.Build;

public class Constants {
    public static final String ApiKey = BuildConfig.ApiKey;

    public static final String baseUrl = "api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=imperial&cnt=7";
    public static final String LOCATION = "location";
//    public static final String locationQuery = "q";
//    public static final String apiQuery = "appid";
}
