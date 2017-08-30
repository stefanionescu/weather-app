package com.weather.app.testapp.ui.presenter;

import com.weather.app.testapp.domain.model.ListOfForecasts;
import com.weather.app.testapp.ui.view.ForecastListView;
import com.weather.app.testapp.ui.viewmodel.Model;

import java.util.List;

/**
 * @author stefan
 */
public interface ForecastListPresenter extends Presenter<ForecastListView> {

    ListOfForecasts getParcelableCollection();

    void restoreParcelableCollection(List<Model> models, ListOfForecasts forecastCollection);

    void onForecastSelected(int position);

}
