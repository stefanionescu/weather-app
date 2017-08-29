package com.weather.app.testapp.ui.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.weather.app.testapp.app.BasePresenter;
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

/**
 * @author stefan
 */
public class ForecastListPresenterImp extends BasePresenter implements ForecastListPresenter {

    private ForecastListView modelCollectionView;
    private GetForecasts getForecasts;
    private ListOfForecasts marvelCharacterCollection;
    private ForecastSelectedObservable forecastSelectedObservable;
    private Context context;

    public ForecastListPresenterImp(Context context, GetForecasts getForecasts, ForecastSelectedObservable forecastSelectedObservable) {
        super(context);
        this.context = context;
        this.getForecasts = getForecasts;
        this.forecastSelectedObservable = forecastSelectedObservable;
    }

    @Override
    public void initialize() {

        Log.i("initialize", "Initialized searching....");

        marvelCharacterCollection = new ListOfForecasts();
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
        return marvelCharacterCollection;
    }

    @Override
    public void restoreParcelableCollection(ListOfForecasts londonForecasts) {
        this.marvelCharacterCollection = londonForecasts;
        modelCollectionView.add(convertToModelViewList(londonForecasts.getForecasts()));
    }

    @Override
    public void onforecastSelected(int position) {
        Collection<Forecast> londonForecasts = marvelCharacterCollection.getForecasts();
        Forecast marvelCharacter = (Forecast) londonForecasts.toArray()[position];
        forecastSelectedObservable.notifyObservers(marvelCharacter);
    }

    private void searchForCharacters() {

        Log.i("searchForecasts", "Getting forecasts....");

        getForecasts.execute(new GetForecasts.Callback() {
            @Override
            public void onMarvelCharacterList(List<Forecast> londonForecasts) {

                marvelCharacterCollection.addAll(londonForecasts);
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
