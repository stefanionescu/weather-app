package com.weather.app.testapp.ui.presenter;

import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.ui.view.ModelInfoView;
import com.weather.app.testapp.ui.viewmodel.ForecastInfoViewModel;

/**
 * @author stefan
 */
public class ForecastInfoPresenterImp implements ForecastInfoPresenter {

    ModelInfoView modelInfoView;

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
    public void setView(ModelInfoView view) {
        this.modelInfoView = view;
    }

    @Override
    public void onCharacter(Forecast forecast) {
        //Parse the character to characterInfoModelView and call the view to show
        ForecastInfoViewModel forecastInfoViewModel = new ForecastInfoViewModel(forecast);
        modelInfoView.showCharacterInfo(forecastInfoViewModel);
    }
}
