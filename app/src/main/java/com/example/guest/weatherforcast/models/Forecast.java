package com.example.guest.weatherforcast.models;

public class Forecast {
    private String mHumidity;

    public Forecast(String humidity) {
        this.mHumidity = humidity;
    }

    public String getHumidity() {return mHumidity; }
}
