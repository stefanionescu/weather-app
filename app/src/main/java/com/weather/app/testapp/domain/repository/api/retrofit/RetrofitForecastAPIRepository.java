package com.weather.app.testapp.domain.repository.api.retrofit;

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

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marvelAPI = restAdapter.create(RetrofitForecastService.class);

    }

    @Override
    public List<Forecast> getForecastsCollection() throws GetForecastException {
        //The request using retrofit

        ForecastList forecasts = new ForecastList();

        Call<ForecastList> call = marvelAPI.getForecasts();

        try {

            forecasts = call.execute().body();

        } catch (Exception e) {

        }

        if (forecasts != null) {

            return responseMapper.mapResponse(forecasts);

        }

        return responseMapper.mapResponse(new ForecastList());

    }

}
