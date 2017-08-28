package com.weather.app.testapp.ui.reactive;

import com.weather.app.testapp.domain.model.Forecast;

/**
 * @author stefan
 */
public interface ForecastSelectedObserver {

    void forecastSelected(Forecast forecast);
}
