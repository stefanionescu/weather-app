package com.weather.app.testapp.app.dependencyinjection.components;

import com.weather.app.testapp.app.TestAppApplication;
import com.weather.app.testapp.app.dependencyinjection.modules.ExecutorModule;
import com.weather.app.testapp.app.dependencyinjection.modules.RootModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RootModule.class, ExecutorModule.class})
public interface TestAppComponent {

    void inject(TestAppApplication app);

}
