package com.weather.app.testapp.domain.repository;

import com.weather.app.testapp.domain.model.Forecast;

import java.util.List;

public interface ResponseMapper<T> {
    List<Forecast> mapResponse(T response);
}
