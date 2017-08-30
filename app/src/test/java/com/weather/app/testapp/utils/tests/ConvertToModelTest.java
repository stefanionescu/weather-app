package com.weather.app.testapp.utils.tests;

import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.ui.utils.ConvertToModel;
import com.weather.app.testapp.ui.viewmodel.Model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ConvertToModelTest {

    ConvertToModel convertToModel;

    @Test
    public void testConversion(){

        convertToModel = new ConvertToModel();

        Forecast forecast = new Forecast(1, "London", "34", "55","34", "Sun");

        List<Forecast> forecastList = new ArrayList<>();

        forecastList.add(forecast);

        List<Model> models = convertToModel.convertToModelViewList(forecastList);

        assertEquals(models.get(0).getTitle(), "London");

    }

}
