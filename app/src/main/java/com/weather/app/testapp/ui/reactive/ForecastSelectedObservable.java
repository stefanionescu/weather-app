package com.weather.app.testapp.ui.reactive;

import com.weather.app.testapp.domain.model.Forecast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author stefan
 */
public class ForecastSelectedObservable implements Observable<ForecastSelectedObserver> {

    List<ForecastSelectedObserver> forecastSelectedObservers;

    @Inject
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

}
