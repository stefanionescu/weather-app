package com.weather.app.testapp.domain.tests;

import com.weather.app.testapp.domain.repository.api.mapper.ForecastApiResponseMapper;
import com.weather.app.testapp.domain.repository.api.model.City;
import com.weather.app.testapp.domain.repository.api.model.Clouds;
import com.weather.app.testapp.domain.repository.api.model.Coord;
import com.weather.app.testapp.domain.repository.api.model.ForecastList;
import com.weather.app.testapp.domain.repository.api.model.Main;
import com.weather.app.testapp.domain.repository.api.model.OneForecast;
import com.weather.app.testapp.domain.repository.api.model.Rain;
import com.weather.app.testapp.domain.repository.api.model.Sys;
import com.weather.app.testapp.domain.repository.api.model.Weather;
import com.weather.app.testapp.domain.repository.api.model.Wind;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class ModelTest {

    private OneForecast oneForecast;
    private Main main;
    private Weather weather;
    private Wind wind;
    private ForecastList forecastList;
    private Clouds clouds;
    private Sys sys;
    private Rain rain;
    private City city;
    private Coord coord;

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
        coord = new Coord();
        city = new City();

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

        coord.setLat(43.4567);
        coord.setLon(23.59764);

        city.setCoord(coord);
        city.setId(1);
        city.setCountry("UK");
        city.setName("London");

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
        forecastList.setCity(city);
        forecastList.setCnt(123);
        forecastList.setCod("Some city");
        forecastList.setMessage(1.2);

    }

    

}
