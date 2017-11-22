package com.example.android.sunshine;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by minhvu on 22/11/17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    private String[] mWeatherDatas;

    public ForecastAdapter() {

    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // first create the LayoutInflater
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // set attachToParentImmediately = false
        boolean attachToParentImmediately = false;

        // create view
        View view = inflater.inflate(R.layout.forecast_list_item, parent, attachToParentImmediately);

        return new ForecastAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        holder.mWeatherTextView.setText(mWeatherDatas[position]);
    }

    @Override
    public int getItemCount() {
        if(mWeatherDatas == null) {
            return 0;
        }

        return mWeatherDatas.length;
    }

    public void setWeatherData(String[] weatherData) {
        mWeatherDatas = weatherData;
        notifyDataSetChanged();
    }


    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View itemView) {
            super(itemView);
            mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }


    }
}
