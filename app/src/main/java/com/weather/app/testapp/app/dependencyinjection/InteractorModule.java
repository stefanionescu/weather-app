package com.weather.app.testapp.app.dependencyinjection;

import com.weather.app.testapp.domain.interactor.GetForecasts;
import com.weather.app.testapp.domain.interactor.GetForecastsImp;
import com.weather.app.testapp.domain.repository.ForecastRepository;
import com.weather.app.testapp.executor.InteractorExecutor;
import com.weather.app.testapp.executor.MainThreadExecutor;

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
public class InteractorModule {

    @Provides
    public GetForecasts provideGetMarvelCharactersLimit(InteractorExecutor interactorExecutor,
                                                        MainThreadExecutor mainThreadExecutor,
                                                        @Named("production_api") ForecastRepository forecastRepository) {

        return new GetForecastsImp(interactorExecutor, mainThreadExecutor, forecastRepository);

    }


}
