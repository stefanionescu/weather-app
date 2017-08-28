package com.weather.app.testapp.ui.fragment;

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
import com.weather.app.testapp.app.BaseFragment;
import com.weather.app.testapp.domain.LogUtils;
import com.weather.app.testapp.domain.model.ListOfForecasts;
import com.weather.app.testapp.ui.adapter.ModelAdapter;
import com.weather.app.testapp.ui.custom.recycler.ClickRecyclerView;
import com.weather.app.testapp.ui.presenter.ForecastListPresenter;
import com.weather.app.testapp.ui.view.ForecastListView;
import com.weather.app.testapp.ui.viewmodel.Model;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @author stefan
 */
public class ForecastListFragment extends BaseFragment implements ForecastListView {

    private static final String EXTRA_CHARACTER_COLLECTION = "extraCharacterCollection";

    @Inject
    ForecastListPresenter characterCollectionPresenter;

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
        return inflater.inflate(R.layout.forecast_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeCollectionView();
        characterCollectionPresenter.setView(this);
        characterCollectionPresenter.onViewCreate();

        if (savedInstanceState == null) {
            Log.i("initialize", "First time running");
            characterCollectionPresenter.initialize();
        }

        addClickListenerToCharacterList();

        Log.i("ForecastList", "View created");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Get the actual state of the characters
        ListOfForecasts marvelCharacters = characterCollectionPresenter.getParcelableCollection();

        //Parcel the object to be saved in the bundle
        Parcelable marvelCharactersWrapped = Parcels.wrap(marvelCharacters);

        //Save the parcelable
        outState.putParcelable(EXTRA_CHARACTER_COLLECTION, marvelCharactersWrapped);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null) {
            Log.i(LogUtils.generateTag(this), "onViewStateRestored");
            //Get parcelable from bundle
            Parcelable marvelCharactersWrapped = savedInstanceState.getParcelable(EXTRA_CHARACTER_COLLECTION);
            ListOfForecasts marvelCharacters = Parcels.unwrap(marvelCharactersWrapped);
            characterCollectionPresenter.restoreParcelableCollection(marvelCharacters);
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

    private void addClickListenerToCharacterList() {
        collectionView.setOnItemClickListener(new CharacterClickListener());
    }

    private void disableSearchOnFinish() {
        collectionView.setOnScrollListener(null);
    }


    private class CharacterClickListener implements ClickRecyclerView.OnItemClickListener {

        @Override
        public void onItemClick(RecyclerView parent, View view, int position, long id) {
            characterCollectionPresenter.onforecastSelected(position);
        }
    }

}
