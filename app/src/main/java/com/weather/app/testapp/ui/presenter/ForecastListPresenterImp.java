package com.weather.app.testapp.ui.presenter;

import android.util.Log;

import com.weather.app.testapp.domain.LogUtils;
import com.weather.app.testapp.domain.interactor.GetForecasts;
import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.domain.model.ListOfForecasts;
import com.weather.app.testapp.ui.reactive.ForecastSelectedObservable;
import com.weather.app.testapp.ui.view.ForecastListView;
import com.weather.app.testapp.ui.viewmodel.ForecastViewModel;
import com.weather.app.testapp.ui.viewmodel.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * @author stefan
 */
public class ForecastListPresenterImp implements ForecastListPresenter {

    private ForecastListView modelCollectionView;
    private GetForecasts getForecasts;
    private ListOfForecasts forecastCollection;

    @Inject
    public ForecastListPresenterImp(GetForecasts getForecasts) {
        this.getForecasts = getForecasts;
    }

    @Override
    public void initialize() {

        Log.i("initialize", "Initialized searching....");

        forecastCollection = new ListOfForecasts();
        searchForCharacters();

    }

    @Override
    public void onViewCreate() {

    }

    @Override
    public void onViewResume() {
        //Do nothing
    }

    @Override
    public void onViewDestroy() {
        //Do nothing
    }

    @Override
    public void setView(ForecastListView view) {
        this.modelCollectionView = view;
    }

    @Override
    public ListOfForecasts getParcelableCollection() {
        return forecastCollection;
    }

    @Override
    public void restoreParcelableCollection(ListOfForecasts londonForecasts) {
        this.forecastCollection = londonForecasts;
        modelCollectionView.add(convertToModelViewList(londonForecasts.getForecasts()));
    }

    @Override
    public void onforecastSelected(int position) {
        Collection<Forecast> londonForecasts = forecastCollection.getForecasts();
        Forecast forecast = (Forecast) londonForecasts.toArray()[position];
        modelCollectionView.startInfoActivity(forecast);
    }

    private void searchForCharacters() {

        Log.i("searchForecasts", "Getting forecasts....");

        getForecasts.execute(new GetForecasts.Callback() {
            @Override
            public void onMarvelCharacterList(List<Forecast> londonForecasts) {

                forecastCollection.addAll(londonForecasts);
                modelCollectionView.add(convertToModelViewList(londonForecasts));

            }

            @Override
            public void onError() {
                Log.e(LogUtils.generateTag(this), "Error on interactor getForecasts");
                modelCollectionView.onError();
            }
        });
    }

    private List<Model> convertToModelViewList(List<Forecast> londonForecasts) {

        List<Model> modelList = new ArrayList<Model>();

        for (Forecast marvelCharacter : londonForecasts) {
            modelList.add(new ForecastViewModel(marvelCharacter));
        }

        return modelList;
    }

}
