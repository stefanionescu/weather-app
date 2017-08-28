package com.weather.app.testapp.ui.activity;

import android.os.Bundle;
import android.os.Parcelable;

import com.weather.app.testapp.R;
import com.weather.app.testapp.app.BaseActivity;
import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.ui.fragment.ForecastInfoFragment;

import org.parceler.Parcels;

import static com.weather.app.testapp.ui.fragment.ForecastInfoFragment.newInstance;

/**
 * @author stefan
 */
public class ModelInfoActivity extends BaseActivity {

    public static final String KEY_CHARACTER = "forecast";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.model_info_activity);

        addInfoFragment();
    }

    public void addInfoFragment() {

        Parcelable marvelCharacterParcelable = getIntent().getExtras().getParcelable(KEY_CHARACTER);
        Forecast forecast = Parcels.unwrap(marvelCharacterParcelable);

        ForecastInfoFragment forecastInfoFragment = newInstance(forecast);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.info_frame, forecastInfoFragment)
                .commit();
    }

}
