package com.weather.app.testapp.app.dependencyinjection.components;

import com.weather.app.testapp.app.dependencyinjection.scopes.MainScope;
import com.weather.app.testapp.ui.activity.MainActivity;

import dagger.Component;

@MainScope
@Component(dependencies = TestAppComponent.class)
public interface MainComponent {

    void inject(MainActivity main);

}
