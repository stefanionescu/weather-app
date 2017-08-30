package com.weather.app.testapp.presenter.tests;

import com.weather.app.testapp.domain.interactor.GetForecasts;
import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.domain.model.ListOfForecasts;
import com.weather.app.testapp.ui.presenter.ForecastListPresenterImp;
import com.weather.app.testapp.ui.view.ForecastListView;
import com.weather.app.testapp.ui.viewmodel.Model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class ForecastListPresenterTest {

    @Mock
    GetForecasts getForecasts;

    @Mock
    ForecastListView forecastListView;

    @Mock
    List<Model> models;
    Forecast forecast;
    private ForecastListPresenterImp forecastListPresenterImp;

    @Before
    public void setUp() {

        forecastListPresenterImp = new ForecastListPresenterImp(getForecasts, forecastListView);
        forecast = new Forecast(1, "London", "45", "56", "67", "Clouds");

    }

    @Test
    public void testRestoreParcelable() {

        ListOfForecasts listOfForecasts = new ListOfForecasts();
        listOfForecasts.add(forecast);

        forecastListPresenterImp.restoreParcelableCollection(models, listOfForecasts);

        verify(forecastListView, times(1)).add(models);

    }

    @Test
    public void testForecastSelected(){

        ListOfForecasts listOfForecasts = new ListOfForecasts();
        listOfForecasts.add(forecast);

        forecastListPresenterImp.restoreParcelableCollection(models, listOfForecasts);

        forecastListPresenterImp.onForecastSelected(0);

        verify(forecastListView, times(1)).startInfoActivity(forecast);

    }

}
