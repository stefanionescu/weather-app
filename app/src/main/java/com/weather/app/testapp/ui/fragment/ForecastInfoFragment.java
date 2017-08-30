package com.weather.app.testapp.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weather.app.testapp.R;
import com.weather.app.testapp.app.dependencyinjection.modules.InfoPresenterModule;
import com.weather.app.testapp.app.dependencyinjection.components.DaggerForecastInfoComponent;
import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.ui.presenter.ForecastInfoPresenter;
import com.weather.app.testapp.ui.view.ModelInfoView;
import com.weather.app.testapp.ui.viewmodel.ForecastInfoViewModel;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author stefan
 */
public class ForecastInfoFragment extends Fragment implements ModelInfoView {

    public static final String KEY_CHARACTER = "forecast";

    @Inject
    ForecastInfoPresenter forecastInfoPresenter;

    @BindView(R.id.info_description)
    TextView infoDescription;

    @BindView(R.id.info_title)
    TextView infoTitle;

    private String tag;

    public static ForecastInfoFragment newInstance(Forecast forecast) {

        Bundle args = new Bundle();
        Parcelable marvelCharacterParcel = Parcels.wrap(forecast);
        args.putParcelable(KEY_CHARACTER, marvelCharacterParcel);

        ForecastInfoFragment forecastInfoFragment = new ForecastInfoFragment();
        forecastInfoFragment.setArguments(args);
        return forecastInfoFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.model_info, container, false);

        ButterKnife.bind(this, view);

        DaggerForecastInfoComponent.builder()
                .infoPresenterModule(new InfoPresenterModule())
                .build()
                .inject(this);

        this.tag = String.valueOf(view.getTag());

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        forecastInfoPresenter.onViewCreate();
        forecastInfoPresenter.setView(this);

        //Get character info
        if (getArguments() != null) {
            Forecast forecast = getMarvelCharacterFromArgs();
            forecastInfoPresenter.onCharacter(forecast);
        }

    }

    @Override
    public void showForecastInfo(ForecastInfoViewModel forecastInfoViewModel) {

        infoDescription.setText("Temperature: " + forecastInfoViewModel.getTemperature() + "\n\n" +
                                "MainScope Weather: " + forecastInfoViewModel.getMainWeather() + "\n\n" +
                                "Atmospheric Pressure: " + forecastInfoViewModel.getPressure() + "\n\n" +
                                "Humidity: " + forecastInfoViewModel.getHumidity() + "\n\n" +
                                "Wind Speed: " + forecastInfoViewModel.getWindSpeed() + " km/h");

        infoTitle.setText(forecastInfoViewModel.getInfoTitle());

    }

    private Forecast getMarvelCharacterFromArgs() {
        Parcelable marvelCharacterParcelable = getArguments().getParcelable(KEY_CHARACTER);
        return Parcels.unwrap(marvelCharacterParcelable);
    }

}
