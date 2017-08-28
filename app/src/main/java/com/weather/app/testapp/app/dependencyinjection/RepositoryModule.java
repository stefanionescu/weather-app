package com.weather.app.testapp.app.dependencyinjection;

import com.weather.app.testapp.domain.repository.ForecastRepository;
import com.weather.app.testapp.domain.repository.ResponseMapper;
import com.weather.app.testapp.domain.repository.api.mapper.ForecastApiResponseMapper;
import com.weather.app.testapp.domain.repository.api.retrofit.RetrofitForecastAPIRepository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @author stefan
 */

@Module(
        complete = false,
        library = true
)
public class RepositoryModule {

    @Provides
    @Named("api_base_url")
    public String provideApiBaseUrl() {
        return "http://api.openweathermap.org/data/2.5/";
    }

    @Provides
    public ResponseMapper provideResponseMapper() {
        return new ForecastApiResponseMapper();
    }

    @Provides
    @Named("production_api")
    public ForecastRepository provideMarvelRepository(ResponseMapper responseMapper, @Named("api_base_url") String endpoint) {
        return new RetrofitForecastAPIRepository(endpoint, responseMapper);
    }

}
