package com.weather.app.testapp.interactor.tests;

import com.weather.app.testapp.domain.interactor.GetForecasts;
import com.weather.app.testapp.domain.interactor.GetForecastsImp;
import com.weather.app.testapp.domain.repository.ForecastRepository;
import com.weather.app.testapp.executor.InteractorExecutor;
import com.weather.app.testapp.executor.MainThreadExecutor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class GetForecastsTest {

    @Mock
    InteractorExecutor interactorExecutor;

    @Mock
    MainThreadExecutor mainThreadExecutor;

    @Mock
    ForecastRepository forecastRepository;

    @Mock
    GetForecasts.Callback callback;

    private GetForecastsImp getForecasts;

    @Before
    public void setUp() throws Exception{

        getForecasts = new GetForecastsImp(interactorExecutor, mainThreadExecutor, forecastRepository);

    }

    @Test
    public void testRun(){

        getForecasts.run();

        verify(forecastRepository).getForecastsCollection();
        verifyNoMoreInteractions(interactorExecutor);

    }

    @Test
    public void testExecute(){

        getForecasts.execute(callback);

        verify(interactorExecutor).run(getForecasts);
        verifyNoMoreInteractions(mainThreadExecutor);

    }

}
