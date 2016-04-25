package com.example.guest.weatherforcast;


import com.example.guest.weatherforcast.models.Forecast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherService {

    public static void findWeather(String location, Callback callback) {
        String ApiKey = Constants.ApiKey;

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.baseUrl).newBuilder();
        urlBuilder.addQueryParameter(Constants.LOCATION, location);
        String url = urlBuilder.build().toString();

        OkHttpClient client = new OkHttpClient.Builder()
            .build();


        Request request= new Request.Builder()
            .url(url)
            .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Forecast> processResults(Response response){
        ArrayList<Forecast> forecasts = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject weatherJSON = new JSONObject(jsonData);
                JSONArray forcastsJSON = weatherJSON.getJSONArray("list");
//                String city = weatherJSON.getJSONObject("city").getString("name");
//                String country = weatherJSON.getJSONObject("country").getString("country");
//                int cityId = weatherJSON.getJSONObject("city").getInt("id");
                for (int i = 0; i< weatherJSON.length(); i++){
                    JSONObject forecastJSON = forcastsJSON.getJSONObject(i);
                    String humidity = forecastJSON.getString("humidity");
                    Forecast forecast = new Forecast(humidity);
                    forecasts.add(forecast);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch(JSONException e) {
            e.printStackTrace();
        }
        return forecasts;
    }
}