package com.example.guest.weatherforcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guest.weatherforcast.models.Forecast;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = WeatherActivity.class.getSimpleName();
    public ArrayList<Forecast> mForecasts = new ArrayList<>();
    @Bind(R.id.weatherListView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        getWeather(location);
    }

    private void getWeather(String location) {
        final WeatherService weatherService = new WeatherService();

        WeatherService.findWeather(location, new Callback(){

            @Override
            public void onFailure(Call call, IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mForecasts = weatherService.processResults(response);

                WeatherActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String[] forecastDays = new String[mForecasts.size()];
                        for (int i=0; i< forecastDays.length; i++) {
                            forecastDays[i]= mForecasts.get(i).getHumidity();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(WeatherActivity.this, android.R.layout.simple_list_item_1, forecastDays);
                        mListView.setAdapter(adapter);

                        for (Forecast forecast : mForecasts) {
                            Log.d(TAG, "Humidity:" + forecast.getHumidity());
                            Log.d(TAG, "Morning Temp:" + forecast.getmAvgTemp());
                        }
                    }
                });
            }
        });
    }
}