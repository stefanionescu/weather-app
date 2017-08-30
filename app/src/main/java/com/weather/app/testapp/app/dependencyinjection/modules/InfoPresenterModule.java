package com.weather.app.testapp.app.dependencyinjection.modules;

import com.weather.app.testapp.app.dependencyinjection.scopes.ForecastInfoScope;
import com.weather.app.testapp.app.dependencyinjection.scopes.ForecastListScope;
import com.weather.app.testapp.domain.interactor.GetForecasts;
import com.weather.app.testapp.ui.presenter.ForecastInfoPresenter;
import com.weather.app.testapp.ui.presenter.ForecastInfoPresenterImp;
import com.weather.app.testapp.ui.presenter.ForecastListPresenter;
import com.weather.app.testapp.ui.presenter.ForecastListPresenterImp;
import com.weather.app.testapp.ui.reactive.ForecastSelectedObservable;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author stefan
 */
@Module
public class InfoPresenterModule {

    @Provides
    @ForecastInfoScope
    public ForecastInfoPresenter provideCharacterInfoPresenter() {
        return new ForecastInfoPresenterImp();
    }

}
