package com.weather.app.testapp.app.dependencyinjection.modules;

import com.weather.app.testapp.app.dependencyinjection.scopes.ForecastListScope;
import com.weather.app.testapp.domain.interactor.GetForecasts;
import com.weather.app.testapp.ui.presenter.ForecastListPresenter;
import com.weather.app.testapp.ui.presenter.ForecastListPresenterImp;
import com.weather.app.testapp.ui.view.ForecastListView;

import dagger.Module;
import dagger.Provides;

@Module(includes = {InteractorModule.class})
public class ListPresenterModule {

    ForecastListView modelCollectionView;

    public ListPresenterModule(ForecastListView modelCollectionView){

        this.modelCollectionView = modelCollectionView;

    }

    @Provides
    @ForecastListScope
    public ForecastListPresenter provideCharacterCollectionPresenter(GetForecasts getForecasts) {
        return new ForecastListPresenterImp(getForecasts, modelCollectionView);
    }

}
