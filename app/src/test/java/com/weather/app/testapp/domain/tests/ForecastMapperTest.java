package com.weather.app.testapp.domain.tests;

import android.test.suitebuilder.annotation.LargeTest;

import com.weather.app.testapp.domain.repository.api.model.ForecastList;
import com.weather.app.testapp.domain.repository.api.model.Main;
import com.weather.app.testapp.domain.repository.api.model.OneForecast;
import com.weather.app.testapp.domain.repository.api.model.Weather;
import com.weather.app.testapp.domain.repository.api.model.Wind;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RunWith(JUnit4.class)
@LargeTest
public class ForecastMapperTest {

    private OneForecast oneForecast;

    private Main main;

    private Weather weather;

    private Wind wind;

    private ForecastList forecastList;

    @Before
    public void setUp() throws Exception{

        List<Weather> weathers = Collections.EMPTY_LIST;
        List<OneForecast> forecasts = Collections.EMPTY_LIST;

        main.setHumidity(54);
        main.setPressure(45.6);
        main.setTemp(294.23);
        main.setTempMax(294.23);
        main.setTempMin(294.23);
        main.setSeaLevel(23.2);
        main.setTempKf(1.92);
        main.setGrndLevel(27.9);

        weather.setMain("Clouds");
        weather.setDescription("Very cloudy");
        weather.setIcon("https://www.someicon.com");
        weather.setId(1);

        wind.setDeg(12.2);
        wind.setSpeed(25.7);

        weathers.add(weather);
        forecasts.add(oneForecast);

        oneForecast.setMain(main);
        oneForecast.setWeather(weathers);
        oneForecast.setWind(wind);
        forecastList.setList(forecasts);

    }

    @Test
    public void createForecastTest(){



    }

}
