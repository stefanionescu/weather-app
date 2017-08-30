package com.weather.app.testapp.app.dependencyinjection.modules;

import com.weather.app.testapp.app.dependencyinjection.scopes.ForecastInfoScope;
import com.weather.app.testapp.ui.presenter.ForecastInfoPresenter;
import com.weather.app.testapp.ui.presenter.ForecastInfoPresenterImp;
import com.weather.app.testapp.ui.view.ModelInfoView;

import dagger.Module;
import dagger.Provides;

/**
 * @author stefan
 */
@Module
public class InfoPresenterModule {

    ModelInfoView modelInfoView;

    public InfoPresenterModule(ModelInfoView modelInfoView){

        this.modelInfoView = modelInfoView;

    }

    @Provides
    @ForecastInfoScope
    public ForecastInfoPresenter provideCharacterInfoPresenter() {
        return new ForecastInfoPresenterImp(modelInfoView);
    }

}
