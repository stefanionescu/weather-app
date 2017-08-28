package com.weather.app.testapp.domain.repository.api.retrofit;

import com.weather.app.testapp.domain.repository.api.model.ForecastList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author stefan
 */
public interface RetrofitForecastService {

    @GET("forecast?id=2643743&appid=4bfb61d0fd064b9402721e73c7f9dbf6")
    Call<ForecastList> getForecasts();

}
