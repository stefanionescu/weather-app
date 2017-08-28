package com.weather.app.testapp.domain.repository.api.mapper;

import android.util.Log;

import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.domain.repository.ResponseMapper;
import com.weather.app.testapp.domain.repository.api.model.ForecastList;
import com.weather.app.testapp.domain.repository.api.model.OneForecast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author stefan
 */
public class ForecastApiResponseMapper implements ResponseMapper<ForecastList> {

    @Override
    public List<Forecast> mapResponse(ForecastList forecastList) {

        Log.i("mapper", "Mapping info");

        List<OneForecast> forecasts = forecastList.getList();

        Log.i("mapper", "Size of List<OneForecast> is: " + String.valueOf(forecasts.size()));

        List<Forecast> marvelCharacters = Collections.emptyList();

        if (forecastList.getList().size() > 0) {
            marvelCharacters = new ArrayList<Forecast>();
        } else
            Log.i("mapper", "marvelCharacters is null...maybe you didn't get info from the Retrofit call?");

        for (OneForecast oneforecast : forecasts) {
            Log.i("mapper", "Processing OneForecast...");
            marvelCharacters.add(createMarvelCharacterFromResponseCharacter(oneforecast));
        }

        Log.i("mapper", String.valueOf(marvelCharacters.size()));

        return marvelCharacters;
    }


    private Forecast createMarvelCharacterFromResponseCharacter(OneForecast oneForecast) {

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
