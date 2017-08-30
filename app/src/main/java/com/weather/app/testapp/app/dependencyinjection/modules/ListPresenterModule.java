package com.weather.app.testapp.app.dependencyinjection.modules;

import com.weather.app.testapp.domain.interactor.GetForecasts;
import com.weather.app.testapp.ui.presenter.ForecastListPresenter;
import com.weather.app.testapp.ui.presenter.ForecastListPresenterImp;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ReactiveModule.class, InteractorModule.class})
public class ListPresenterModule {

    @Provides
    public ForecastListPresenter provideCharacterCollectionPresenter(GetForecasts getForecasts) {
        return new ForecastListPresenterImp(getForecasts);
    }

}
