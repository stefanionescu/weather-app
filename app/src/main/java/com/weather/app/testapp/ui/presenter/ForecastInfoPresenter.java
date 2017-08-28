package com.weather.app.testapp.ui.presenter;

import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.ui.view.ModelInfoView;

/**
 * @author stefan
 */
public interface ForecastInfoPresenter extends Presenter<ModelInfoView> {

    /**
     * When the view is created it will recibe a marvel character into the bundle, then
     * call the presenter
     *
     * @param forecast
     */
    void onCharacter(Forecast forecast);

}
