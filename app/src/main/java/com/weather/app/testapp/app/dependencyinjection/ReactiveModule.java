package com.weather.app.testapp.app.dependencyinjection;

import com.weather.app.testapp.ui.reactive.ForecastSelectedObservable;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author stefan
 */
@Module(
        complete = false,
        library = true
)
public class ReactiveModule {

    @Singleton
    @Provides
    ForecastSelectedObservable proviForecastSelectedObservable() {
        return new ForecastSelectedObservable();
    }
}
