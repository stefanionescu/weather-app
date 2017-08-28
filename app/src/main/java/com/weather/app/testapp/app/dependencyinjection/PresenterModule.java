package com.weather.app.testapp.app.dependencyinjection;

import android.content.Context;

import com.weather.app.testapp.domain.interactor.GetForecasts;
import com.weather.app.testapp.ui.presenter.ForecastInfoPresenter;
import com.weather.app.testapp.ui.presenter.ForecastInfoPresenterImp;
import com.weather.app.testapp.ui.presenter.ForecastListPresenter;
import com.weather.app.testapp.ui.presenter.ForecastListPresenterImp;
import com.weather.app.testapp.ui.reactive.ForecastSelectedObservable;

import dagger.Module;
import dagger.Provides;

/**
 * @author stefan
 */
@Module(
        complete = false,
        library = true
)
public class PresenterModule {

    @Provides
    public ForecastListPresenter provideCharacterCollectionPresenter(Context context, GetForecasts getForecasts, ForecastSelectedObservable forecastSelectedObservable) {
        return new ForecastListPresenterImp(context, getForecasts, forecastSelectedObservable);
    }

    @Provides
    public ForecastInfoPresenter provideCharacterInfoPresenter() {
        return new ForecastInfoPresenterImp();
    }


}
