package com.weather.app.testapp.domain.interactor;

import android.util.Log;

import com.weather.app.testapp.domain.LogUtils;
import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.domain.repository.ForecastRepository;
import com.weather.app.testapp.domain.repository.exception.GetForecastException;
import com.weather.app.testapp.executor.InteractorExecutor;
import com.weather.app.testapp.executor.MainThreadExecutor;

import java.util.List;

public class GetForecastsImp extends AbstractInteractor implements GetForecasts {

    private ForecastRepository forecastRepository;
    private Callback callback;

    public GetForecastsImp(InteractorExecutor interactorExecutor,
                           MainThreadExecutor mainThreadExecutor,
                           ForecastRepository forecastRepository) {
        super(interactorExecutor, mainThreadExecutor);
        this.forecastRepository = forecastRepository;
    }

    @Override
    public void run() {

        try {
            final List<Forecast> forecasts = forecastRepository.getForecastsCollection();

            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onForecastList(forecasts);
                }
            });

        } catch (GetForecastException e) {
            Log.e(LogUtils.generateTag(this), "Error on GetLondonForecasts interactor");
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onError();
                }
            });
        }

    }

    @Override
    public void execute(Callback callback) {
        this.callback = callback;

        getInteractorExecutor().run(this);
    }

}
