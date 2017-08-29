package com.weather.app.testapp.ui.reactive;

import com.weather.app.testapp.domain.model.Forecast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stefan
 */
public class ForecastSelectedObservable implements Observable<ForecastSelectedObserver> {

    List<ForecastSelectedObserver> forecastSelectedObservers;

    public ForecastSelectedObservable() {
        forecastSelectedObservers = new ArrayList<ForecastSelectedObserver>();
    }

    @Override
    public void register(ForecastSelectedObserver observer) {

        if (!forecastSelectedObservers.contains(observer)) {
            forecastSelectedObservers.add(observer);
        }
        
    }

    @Override
    public void unregister(ForecastSelectedObserver observer) {
        forecastSelectedObservers.remove(observer);
    }


    public void notifyObservers(Forecast forecast) {
        for (ForecastSelectedObserver forecastSelectedObserver : forecastSelectedObservers) {
            forecastSelectedObserver.forecastSelected(forecast);
        }
    }
}
