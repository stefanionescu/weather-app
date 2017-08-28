package com.weather.app.testapp.domain.repository.api.retrofit;

import android.util.Log;

import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.domain.repository.ForecastRepository;
import com.weather.app.testapp.domain.repository.ResponseMapper;
import com.weather.app.testapp.domain.repository.api.model.ForecastList;
import com.weather.app.testapp.domain.repository.exception.GetForecastException;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitForecastAPIRepository implements ForecastRepository {

    private String endpoint;
    private RetrofitForecastService marvelAPI;
    private ResponseMapper responseMapper;

    public RetrofitForecastAPIRepository(String endpoint, ResponseMapper responseMapper) {
        this.endpoint = endpoint;
        this.responseMapper = responseMapper;
        init();
    }

    private void init() {

        Log.i("retrofit", "Preparing Retrofit....");

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Log.i("retrofit", endpoint);

        marvelAPI = restAdapter.create(RetrofitForecastService.class);

    }

    @Override
    public List<Forecast> getForecastsCollection() throws GetForecastException {
        //The request using retrofit

        ForecastList forecasts = new ForecastList();

        Log.i("retrofit", "Will we get a response?");

        Call<ForecastList> call = marvelAPI.getForecasts();

        try {

            forecasts = call.execute().body();

            Log.i("retrofit", "Got a response!");

        } catch (Exception e) {

            Log.i("retrofit", e.getMessage());

        }

        if (forecasts != null) {

            Log.i("retrofit", "A value from forecasts: " + forecasts.getList().get(0).getDtTxt());

            return responseMapper.mapResponse(forecasts);

        } else
            Log.i("retrofit", "forecasts is null...");

        return responseMapper.mapResponse(new ForecastList());

    }

}
