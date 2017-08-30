package com.weather.app.testapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.weather.app.testapp.R;
import com.weather.app.testapp.app.TestAppApplication;
import com.weather.app.testapp.app.dependencyinjection.components.DaggerMainComponent;
import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.ui.fragment.ForecastInfoFragment;
import com.weather.app.testapp.ui.reactive.ForecastSelectedObservable;
import com.weather.app.testapp.ui.reactive.ForecastSelectedObserver;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ForecastSelectedObserver {

    public static final String TAG_LANDSCAPE = "V11-landscape";

    @Inject
    ForecastSelectedObservable forecastSelectedObservable;

    //The viewTag is the key for the navigation with different sizes
    private String viewTag;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(this).inflate(R.layout.main, null);

        DaggerMainComponent.builder().
                testAppComponent(((TestAppApplication) getApplication()).getComponent()).
                build().
                inject(this);

        viewTag = (String) view.getTag();
        setContentView(view);

    }

    @Override
    protected void onResume() {
        super.onResume();
        forecastSelectedObservable.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        forecastSelectedObservable.unregister(this);
    }

    @Override
    public void forecastSelected(Forecast forecast) {

        if (viewTag.equals(TAG_LANDSCAPE)) {
            replaceForecastInfoFragment(forecast);
        }

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
