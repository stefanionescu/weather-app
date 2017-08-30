package com.weather.app.testapp.app.dependencyinjection.modules;

import com.weather.app.testapp.app.dependencyinjection.scopes.MainScope;
import com.weather.app.testapp.ui.reactive.ForecastSelectedObservable;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author stefan
 */
@Module
public class ReactiveModule {

    @Provides
    public ForecastSelectedObservable proviForecastSelectedObservable() {
        return new ForecastSelectedObservable();
    }
}
