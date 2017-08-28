package com.weather.app.testapp.domain.model;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class ListOfForecasts {

    public List<Forecast> forecasts;

    public ListOfForecasts() {
        this.forecasts = new ArrayList<Forecast>();
    }

    public List<Forecast> getForecasts() {
        return (List<Forecast>) ((ArrayList<Forecast>) forecasts).clone();
    }

    public void add(Forecast forecast) {
        this.forecasts.add(forecast);
    }

    public void addAll(List<Forecast> forecast) {
        this.forecasts.addAll(forecast);
    }

}
