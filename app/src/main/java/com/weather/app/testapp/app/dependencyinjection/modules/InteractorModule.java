package com.weather.app.testapp.app.dependencyinjection.modules;

import com.weather.app.testapp.app.dependencyinjection.scopes.ForecastListScope;
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
@Module(includes = {ExecutorModule.class, RepositoryModule.class})
public class InteractorModule {

    @Provides
    @ForecastListScope
    public GetForecasts provideGetlondonForecastsLimit(@Named("interactor_exec") InteractorExecutor interactorExecutor,
                                                       @Named("main_exec") MainThreadExecutor mainThreadExecutor,
                                                       @Named("production_api") ForecastRepository forecastRepository) {

        return new GetForecastsImp(interactorExecutor, mainThreadExecutor, forecastRepository);

    }


}
