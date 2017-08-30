package com.weather.app.testapp.app.dependencyinjection.components;

import com.weather.app.testapp.app.dependencyinjection.modules.InfoPresenterModule;
import com.weather.app.testapp.app.dependencyinjection.scopes.ForecastInfoScope;
import com.weather.app.testapp.ui.fragment.ForecastInfoFragment;

import javax.inject.Singleton;

import dagger.Component;

@ForecastInfoScope
@Component(modules = InfoPresenterModule.class)
public interface ForecastInfoComponent {

    void inject(ForecastInfoFragment forecast);

}
