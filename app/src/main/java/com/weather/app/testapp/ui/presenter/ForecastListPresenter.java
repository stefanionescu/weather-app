package com.weather.app.testapp.ui.presenter;

import com.weather.app.testapp.domain.model.ListOfForecasts;
import com.weather.app.testapp.ui.view.ForecastListView;

/**
 * @author stefan
 */
public interface ForecastListPresenter extends Presenter<ForecastListView> {

    ListOfForecasts getParcelableCollection();

    void restoreParcelableCollection(ListOfForecasts londonForecasts);

    void onforecastSelected(int position);

}
