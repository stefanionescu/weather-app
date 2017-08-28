package com.weather.app.testapp.ui.view;

/**
 * @author stefan
 */
public interface ForecastListView extends ModelListView {

    int getModelsRenderer();

    void onError();

}
