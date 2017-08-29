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

    private ForecastRepository marvelRepository;
    private Callback callback;

    public GetForecastsImp(InteractorExecutor interactorExecutor,
                           MainThreadExecutor mainThreadExecutor,
                           ForecastRepository marvelRepository) {
        super(interactorExecutor, mainThreadExecutor);
        this.marvelRepository = marvelRepository;
    }


    @Override
    public void run() {

        try {
            final List<Forecast> forecasts = marvelRepository.getForecastsCollection();

            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onMarvelCharacterList(forecasts);
                }
            });

        } catch (GetForecastException e) {
            Log.e(LogUtils.generateTag(this), "Error on GerlondonForecasts interactor");
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
