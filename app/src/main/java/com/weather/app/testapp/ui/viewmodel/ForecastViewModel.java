package com.weather.app.testapp.ui.viewmodel;

import com.weather.app.testapp.domain.model.Forecast;

public class ForecastViewModel extends Model {

    Forecast model;

    public ForecastViewModel(Forecast model) {
        this.model = model;
    }

    @Override
    public String getTitle() {
        return model.getName();
    }

}
