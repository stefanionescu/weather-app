package com.weather.app.testapp.domain.repository.api.mapper;

import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.domain.repository.ResponseMapper;
import com.weather.app.testapp.domain.repository.api.model.ForecastList;
import com.weather.app.testapp.domain.repository.api.model.OneForecast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stefan
 */
public class ForecastApiResponseMapper implements ResponseMapper<ForecastList> {

    @Override
    public ArrayList<Forecast> mapResponse(ForecastList forecastList) {

        List<OneForecast> forecasts = forecastList.getList();

        ArrayList<Forecast> londonForecasts = new ArrayList<>();

        for (OneForecast oneforecast : forecasts) {
            londonForecasts.add(createForecastFromResponseObject(oneforecast));
        }

        return londonForecasts;
    }

    private Forecast createForecastFromResponseObject(OneForecast oneForecast) {

        Forecast forecast = new Forecast();
        forecast.setName("London - " + oneForecast.getDtTxt());

        forecast.setTemperature(String.valueOf(oneForecast.getMain().getTemp()) + " Kelvin");
        forecast.setPressure(String.valueOf(oneForecast.getMain().getPressure()) + " hPa");
        forecast.setHumidity(String.valueOf(oneForecast.getMain().getHumidity()) + "%");

        forecast.setMain(String.valueOf(oneForecast.getWeather().get(0).getMain() +
                " (" +
                oneForecast.getWeather().get(0).getDescription()
                + ")"));

        forecast.setWind_speed(String.valueOf(oneForecast.getWind().getSpeed()));

        return forecast;
    }
}
