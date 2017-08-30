package com.weather.app.testapp.ui.view;

import com.weather.app.testapp.domain.model.Forecast;

/**
 * @author stefan
 */
public interface ForecastListView extends ModelListView {

    int getModelsRenderer();

    void onError();

    void startInfoActivity(Forecast forecast);

}
