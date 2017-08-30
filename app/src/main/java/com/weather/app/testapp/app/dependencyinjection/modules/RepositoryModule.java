package com.weather.app.testapp.app.dependencyinjection.modules;

import com.weather.app.testapp.app.dependencyinjection.scopes.ForecastListScope;
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

@Module
public class RepositoryModule {

    @Provides
    @ForecastListScope
    @Named("api_base_url")
    public String provideApiBaseUrl() {
        return "http://api.openweathermap.org/data/2.5/";
    }

    @Provides
    @ForecastListScope
    public ResponseMapper provideResponseMapper() {
        return new ForecastApiResponseMapper();
    }

    @Provides
    @ForecastListScope
    @Named("production_api")
    public ForecastRepository provideMarvelRepository(ResponseMapper responseMapper, @Named("api_base_url") String endpoint) {
        return new RetrofitForecastAPIRepository(endpoint, responseMapper);
    }

}
