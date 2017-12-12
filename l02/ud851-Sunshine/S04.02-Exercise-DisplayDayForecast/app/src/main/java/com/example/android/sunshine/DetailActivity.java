package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private TextView mWeatherDetailTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // detail weather text view
        mWeatherDetailTextView = (TextView) findViewById(R.id.tv_weather_detail);

        // TODO (2) Display the weather forecast that was passed from MainActivity
        Intent intentThatCallThis = getIntent();
        if (intentThatCallThis.hasExtra(Intent.EXTRA_TEXT)) {
            mWeatherDetailTextView.setText(intentThatCallThis.getStringExtra(Intent.EXTRA_TEXT));
        }
    }
}