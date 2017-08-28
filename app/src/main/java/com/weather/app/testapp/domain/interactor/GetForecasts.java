package com.weather.app.testapp.domain.interactor;

import com.weather.app.testapp.domain.model.Forecast;

import java.util.List;

public interface GetForecasts {

    void execute(final Callback callback);

    interface Callback {

        void onMarvelCharacterList(List<Forecast> forecasts);

        void onError();
    }
}
