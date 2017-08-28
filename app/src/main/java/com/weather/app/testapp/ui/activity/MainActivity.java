package com.weather.app.testapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;

import com.weather.app.testapp.R;
import com.weather.app.testapp.app.BaseActivity;
import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.ui.fragment.ForecastInfoFragment;
import com.weather.app.testapp.ui.reactive.ForecastSelectedObservable;
import com.weather.app.testapp.ui.reactive.ForecastSelectedObserver;

import org.parceler.Parcels;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements ForecastSelectedObserver {

    public static final String TAG_PORTRAIT = "V11-portrait";
    public static final String TAG_LANDSCAPE = "V11-landscape";

    @Inject
    ForecastSelectedObservable ForecastSelectedObservable;

    //The viewTag is the key for the navigation with different sizes
    private String viewTag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(this).inflate(R.layout.main, null);
        viewTag = (String) view.getTag();
        setContentView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ForecastSelectedObservable.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ForecastSelectedObservable.unregister(this);
    }

    @Override
    public void forecastSelected(Forecast forecast) {
        if (viewTag.equals(TAG_PORTRAIT)) {
            launchForecastInfoActivity(forecast);
        }

        if (viewTag.equals(TAG_LANDSCAPE)) {
            replaceForecastInfoFragment(forecast);
        }
    }

    //TODO Change to navigator class with activity context
    private void launchForecastInfoActivity(Forecast forecast) {
        Intent intent = new Intent(this, ModelInfoActivity.class);
        Parcelable parcelable = Parcels.wrap(forecast);
        intent.putExtra(ModelInfoActivity.KEY_CHARACTER, parcelable);
        startActivity(intent);
    }

    private void replaceForecastInfoFragment(Forecast forecast) {

        ForecastInfoFragment forecastInfoFragment = ForecastInfoFragment.newInstance(forecast);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.forecast_fragment, forecastInfoFragment)
                .disallowAddToBackStack()
                .commit();

    }
}
