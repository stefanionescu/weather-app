package com.weather.app.testapp.domain.repository;

import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.domain.repository.api.model.ForecastList;
import com.weather.app.testapp.domain.repository.api.model.OneForecast;
import com.weather.app.testapp.domain.repository.exception.GetForecastException;

import java.util.List;

/**
 * Repository to get information
 *
 * @author stefan
 */
public interface ForecastRepository {

    List<Forecast> getForecastsCollection() throws GetForecastException;

}
