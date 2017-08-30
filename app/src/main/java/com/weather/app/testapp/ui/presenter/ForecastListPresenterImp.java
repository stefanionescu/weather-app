package com.weather.app.testapp.ui.presenter;

import android.util.Log;

import com.weather.app.testapp.domain.LogUtils;
import com.weather.app.testapp.domain.interactor.GetForecasts;
import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.domain.model.ListOfForecasts;
import com.weather.app.testapp.ui.utils.ConvertToModel;
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
    private ConvertToModel convertToModel;

    @Inject
    public ForecastListPresenterImp(GetForecasts getForecasts, ForecastListView modelCollectionView) {

        this.getForecasts = getForecasts;
        this.modelCollectionView = modelCollectionView;

        convertToModel = new ConvertToModel();

    }

    @Override
    public void initialize() {

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
    public ListOfForecasts getParcelableCollection() {
        return forecastCollection;
    }

    @Override
    public void restoreParcelableCollection(List<Model> models, ListOfForecasts forecastCollection) {
        this.forecastCollection = forecastCollection;
        modelCollectionView.add(models);
    }

    @Override
    public void onForecastSelected(int position) {
        Collection<Forecast> londonForecasts = forecastCollection.getForecasts();
        Forecast forecast = (Forecast) londonForecasts.toArray()[position];
        modelCollectionView.startInfoActivity(forecast);
    }

    private void searchForCharacters() {

        getForecasts.execute(new GetForecasts.Callback() {
            @Override
            public void onForecastList(List<Forecast> londonForecasts) {

                forecastCollection.addAll(londonForecasts);
                modelCollectionView.add(convertToModel.convertToModelViewList(londonForecasts));

            }

            @Override
            public void onError() {
                Log.e(LogUtils.generateTag(this), "Error on interactor getForecasts");
                modelCollectionView.onError();
            }
        });
    }


}
