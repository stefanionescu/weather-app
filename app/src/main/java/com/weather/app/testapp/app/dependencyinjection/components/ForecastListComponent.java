package com.weather.app.testapp.app.dependencyinjection.components;

import com.weather.app.testapp.app.dependencyinjection.modules.InteractorModule;
import com.weather.app.testapp.app.dependencyinjection.modules.RepositoryModule;
import com.weather.app.testapp.app.dependencyinjection.modules.ExecutorModule;
import com.weather.app.testapp.app.dependencyinjection.modules.ListPresenterModule;
import com.weather.app.testapp.app.dependencyinjection.scopes.ForecastListScope;
import com.weather.app.testapp.ui.fragment.ForecastListFragment;

import dagger.Component;

@ForecastListScope
@Component(modules = {ListPresenterModule.class, InteractorModule.class, RepositoryModule.class},
        dependencies = {TestAppComponent.class})
public interface ForecastListComponent {

    void inject(ForecastListFragment fragment);

}
