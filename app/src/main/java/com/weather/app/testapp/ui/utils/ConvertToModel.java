package com.weather.app.testapp.ui.utils;


import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.ui.viewmodel.ForecastViewModel;
import com.weather.app.testapp.ui.viewmodel.Model;

import java.util.ArrayList;
import java.util.List;

public class ConvertToModel {

    public List<Model> convertToModelViewList(List<Forecast> londonForecasts) {

        List<Model> modelList = new ArrayList<Model>();

        for (Forecast forecast : londonForecasts) {
            modelList.add(new ForecastViewModel(forecast));
        }

        return modelList;

    }

}
