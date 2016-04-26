package com.example.guest.weatherforcast.models;

public class Forecast {
    private String mAvgTemp;
//    private String mLowTemp;
//    private String mHighTemp;
//    private String mMornTemp;
//    private String mEveTemp;
//    private String mNightTemp;
    private String mHumidity;


    public Forecast(String humidity, String avgTemp) {
        this.mAvgTemp = avgTemp;
        this.mHumidity = humidity;
    }

    public String getHumidity() {
        return mHumidity;
    }
    public String getmAvgTemp(){
        return mAvgTemp;
    }
}
