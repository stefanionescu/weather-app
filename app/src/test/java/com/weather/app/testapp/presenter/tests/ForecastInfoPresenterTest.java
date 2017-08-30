package com.weather.app.testapp.presenter.tests;

import com.weather.app.testapp.ui.presenter.ForecastInfoPresenterImp;
import com.weather.app.testapp.ui.view.ModelInfoView;
import com.weather.app.testapp.ui.viewmodel.ForecastInfoViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class ForecastInfoPresenterTest {

    @Mock
    ModelInfoView modelInfoView;
    @Mock
    ForecastInfoViewModel forecastInfoViewModel;
    private ForecastInfoPresenterImp forecastInfoPresenterImp;

    @Before
    public void setUp() throws Exception {

        forecastInfoPresenterImp = new ForecastInfoPresenterImp(modelInfoView);

    }

    @Test
    public void testOnForecast() {

        forecastInfoPresenterImp.onForecast(forecastInfoViewModel);

        verify(modelInfoView, times(1)).showForecastInfo(forecastInfoViewModel);

    }

}
