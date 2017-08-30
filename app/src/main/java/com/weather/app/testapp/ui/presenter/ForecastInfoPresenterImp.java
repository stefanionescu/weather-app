package com.weather.app.testapp.ui.presenter;

import com.weather.app.testapp.ui.view.ModelInfoView;
import com.weather.app.testapp.ui.viewmodel.ForecastInfoViewModel;

import javax.inject.Inject;

/**
 * @author stefan
 */
public class ForecastInfoPresenterImp implements ForecastInfoPresenter {

    ModelInfoView modelInfoView;

    @Inject
    public ForecastInfoPresenterImp(ModelInfoView modelInfoView) {

        this.modelInfoView = modelInfoView;

    }

    @Override
    public void initialize() {
        //Do nothing
    }

    @Override
    public void onViewCreate() {
        //Do nothing
    }

    @Override
    public void onViewResume() {
        //Do nothing
    }

    @Override
    public void onViewDestroy() {
        //Do nothing
    }

    @Override
    public void onForecast(ForecastInfoViewModel forecastInfoViewModel) {
        //Parse the character to characterInfoModelView and call the view to show
        modelInfoView.showForecastInfo(forecastInfoViewModel);
    }
}
