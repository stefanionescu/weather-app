package com.weather.app.testapp.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.weather.app.testapp.R;
import com.weather.app.testapp.app.TestAppApplication;
import com.weather.app.testapp.app.dependencyinjection.components.DaggerForecastListComponent;
import com.weather.app.testapp.app.dependencyinjection.modules.ExecutorModule;
import com.weather.app.testapp.app.dependencyinjection.modules.InteractorModule;
import com.weather.app.testapp.app.dependencyinjection.modules.ListPresenterModule;
import com.weather.app.testapp.app.dependencyinjection.modules.RepositoryModule;
import com.weather.app.testapp.domain.LogUtils;
import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.domain.model.ListOfForecasts;
import com.weather.app.testapp.ui.activity.ModelInfoActivity;
import com.weather.app.testapp.ui.adapter.ModelAdapter;
import com.weather.app.testapp.ui.custom.recycler.ClickRecyclerView;
import com.weather.app.testapp.ui.presenter.ForecastListPresenter;
import com.weather.app.testapp.ui.view.ForecastListView;
import com.weather.app.testapp.ui.viewmodel.Model;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author stefan
 */
public class ForecastListFragment extends Fragment implements ForecastListView {

    private static final String EXTRA_CHARACTER_COLLECTION = "extraCharacterCollection";

    @Inject
    ForecastListPresenter forecastCollectionPresenter;

    @BindView(R.id.collection_view)
    ClickRecyclerView collectionView;

    private ModelAdapter modelAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("ForecastList", "on create()");
        super.onCreate(savedInstanceState);
        modelAdapter = new ModelAdapter();
        mLayoutManager = new LinearLayoutManager(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.forecast_list, container, false);

        ButterKnife.bind(this, view);

        DaggerForecastListComponent.builder().
                testAppComponent(((TestAppApplication)getActivity().getApplication()).getComponent())
                .interactorModule(new InteractorModule())
                .repositoryModule(new RepositoryModule())
                .listPresenterModule(new ListPresenterModule())
                .build()
                .inject(this);

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeCollectionView();
        forecastCollectionPresenter.setView(this);
        forecastCollectionPresenter.onViewCreate();

        if (savedInstanceState == null) {
            Log.i("initialize", "First time running");
            forecastCollectionPresenter.initialize();
        }

        addClickListenerToCharacterList();

        Log.i("ForecastList", "View created");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Get the actual state of the characters
        ListOfForecasts londonForecasts = forecastCollectionPresenter.getParcelableCollection();

        //Parcel the object to be saved in the bundle
        Parcelable londonForecastsWrapped = Parcels.wrap(londonForecasts);

        //Save the parcelable
        outState.putParcelable(EXTRA_CHARACTER_COLLECTION, londonForecastsWrapped);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null) {
            Log.i(LogUtils.generateTag(this), "onViewStateRestored");
            //Get parcelable from bundle
            Parcelable londonForecastsWrapped = savedInstanceState.getParcelable(EXTRA_CHARACTER_COLLECTION);
            ListOfForecasts londonForecasts = Parcels.unwrap(londonForecastsWrapped);
            forecastCollectionPresenter.restoreParcelableCollection(londonForecasts);
        }
    }

    private void initializeCollectionView() {
        collectionView.setAdapter(modelAdapter);
        collectionView.setLayoutManager(mLayoutManager);
        collectionView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void add(Model model) {
        modelAdapter.add(model);
    }

    @Override
    public void add(List<Model> models) {
        modelAdapter.add(models);
    }

    @Override
    public void remove(Model model) {
        //TODO implement
    }

    @Override
    public int getModelsRenderer() {
        return modelAdapter.getItemCount();
    }

    @Override
    public void onError() {
        Toast.makeText(this.getActivity(), getString(R.string.genericError), Toast.LENGTH_LONG).show();
    }

    @Override
    public void startInfoActivity(Forecast forecast) {

        launchForecastInfoActivity(forecast);

    }

    private void addClickListenerToCharacterList() {
        collectionView.setOnItemClickListener(new CharacterClickListener());
    }

    private class CharacterClickListener implements ClickRecyclerView.OnItemClickListener {

        @Override
        public void onItemClick(RecyclerView parent, View view, int position, long id) {
            forecastCollectionPresenter.onforecastSelected(position);
        }
    }

    private void launchForecastInfoActivity(Forecast forecast) {
        Intent intent = new Intent(getActivity(), ModelInfoActivity.class);
        Parcelable parcelable = Parcels.wrap(forecast);
        intent.putExtra(ModelInfoActivity.KEY_CHARACTER, parcelable);
        startActivity(intent);
    }

}
