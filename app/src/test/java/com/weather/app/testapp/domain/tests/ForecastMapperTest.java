package com.weather.app.testapp.domain.tests;

import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.domain.repository.api.mapper.ForecastApiResponseMapper;
import com.weather.app.testapp.domain.repository.api.model.Clouds;
import com.weather.app.testapp.domain.repository.api.model.ForecastList;
import com.weather.app.testapp.domain.repository.api.model.Main;
import com.weather.app.testapp.domain.repository.api.model.OneForecast;
import com.weather.app.testapp.domain.repository.api.model.Rain;
import com.weather.app.testapp.domain.repository.api.model.Sys;
import com.weather.app.testapp.domain.repository.api.model.Weather;
import com.weather.app.testapp.domain.repository.api.model.Wind;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ForecastMapperTest {

    private OneForecast oneForecast;
    private Main main;
    private Weather weather;
    private Wind wind;
    private ForecastList forecastList;
    private ForecastApiResponseMapper mapper;
    private Clouds clouds;
    private Sys sys;
    private Rain rain;

    @Before
    public void setUp() throws Exception {

        java.util.List<Weather> weathers = new ArrayList<>();
        List<OneForecast> forecasts = new ArrayList<>();

        main = new Main();
        weather = new Weather();
        wind = new Wind();
        clouds = new Clouds();
        rain = new Rain();
        sys = new Sys();
        oneForecast = new OneForecast();
        forecastList = new ForecastList();
        mapper = new ForecastApiResponseMapper();

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

        rain.set3h(3.09);

        sys.setPod("pod");

        clouds.setAll(1);

        weathers.add(weather);
        forecasts.add(oneForecast);

        oneForecast.setMain(main);
        oneForecast.setWeather(weathers);
        oneForecast.setWind(wind);
        oneForecast.setDt(1);
        oneForecast.setDtTxt("2017-30-1 15:00:00");
        oneForecast.setClouds(clouds);
        oneForecast.setRain(rain);
        oneForecast.setSys(sys);

        forecastList.setList(forecasts);

    }

    @Test
    public void testCreateForecast() {

        List<Forecast> londonForecasts = new ArrayList<>();

        londonForecasts = mapper.mapResponse(forecastList);

        assertEquals(londonForecasts.get(0).getName(), "London - 2017-30-1 15:00:00");

    }

}
