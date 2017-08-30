package com.weather.app.testapp.app.dependencyinjection.components;

import com.weather.app.testapp.app.TestAppApplication;
import com.weather.app.testapp.app.dependencyinjection.modules.ExecutorModule;
import com.weather.app.testapp.app.dependencyinjection.modules.ReactiveModule;
import com.weather.app.testapp.app.dependencyinjection.modules.RootModule;
import com.weather.app.testapp.ui.reactive.ForecastSelectedObservable;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RootModule.class, ReactiveModule.class, ExecutorModule.class})
public interface TestAppComponent {

    void inject(TestAppApplication app);

}
