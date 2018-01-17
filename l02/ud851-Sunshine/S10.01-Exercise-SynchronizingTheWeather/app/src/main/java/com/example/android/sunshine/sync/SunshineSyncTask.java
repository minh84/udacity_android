package com.example.android.sunshine.sync;

//  Done (1) Create a class called SunshineSyncTask
//  Done (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
//      Done (3) Within syncWeather, fetch new weather data
//      Done (4) If we have valid results, delete the old data and insert the new

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import java.net.URL;

public class SunshineSyncTask {
    synchronized public static void syncWeather(Context context) {
        try {
            // get the URL for weather request
            URL weatherRequestUrl = NetworkUtils.getUrl(context);

            // request weather data
            String weatherDataJson = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);

            // parsing the weather data
            ContentValues[] contentValues = OpenWeatherJsonUtils
                    .getWeatherContentValuesFromJson(context, weatherDataJson);


            // if data is valid
            if (contentValues != null && contentValues.length > 0) {
                /* Get a handle on the ContentResolver to delete and insert data */
                ContentResolver sunshineContentResolver = context.getContentResolver();

                // delete old data
                sunshineContentResolver.delete(WeatherContract.WeatherEntry.CONTENT_URI,
                                                null, null);

                // update new data
                sunshineContentResolver.bulkInsert(WeatherContract.WeatherEntry.CONTENT_URI, contentValues);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}