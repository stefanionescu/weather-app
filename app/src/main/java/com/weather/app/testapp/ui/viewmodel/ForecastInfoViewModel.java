package com.weather.app.testapp.ui.viewmodel;

import com.weather.app.testapp.domain.model.Forecast;

/**
 * Custom implementation for use with the view ModelInfoView, in this case the model is a ForecastList
 *
 * @author stefan
 */
public class ForecastInfoViewModel extends ModelInfo {

    private Forecast forecast;

    public ForecastInfoViewModel(Forecast model) {
        forecast = model;
    }

    @Override
    public String getWindSpeed() {
        return forecast.getWind_speed();
    }

    @Override
    public String getMainWeather() {
        return forecast.getMain();
    }

    @Override
    public String getHumidity() {
        return forecast.getHumidity();
    }

    @Override
    public String getPressure() {
        return forecast.getPressure();
    }

    @Override
    public String getTemperature() {
        return forecast.getTemperature();
    }

    @Override
    public String getInfoTitle() {
        return String.valueOf(forecast.getName());
    }

}
