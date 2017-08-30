package com.weather.app.testapp.ui.presenter;

import com.weather.app.testapp.ui.view.ModelInfoView;
import com.weather.app.testapp.ui.viewmodel.ForecastInfoViewModel;

/**
 * @author stefan
 */
public interface ForecastInfoPresenter extends Presenter<ModelInfoView> {

    /**
     * When the view is created it will recibe a marvel character into the bundle, then
     * call the presenter
     *
     * @param forecastInfoViewModel
     */
    void onForecast(ForecastInfoViewModel forecastInfoViewModel);

}
