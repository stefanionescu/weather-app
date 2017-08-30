package com.weather.app.testapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.weather.app.testapp.R;
import com.weather.app.testapp.domain.model.Forecast;
import com.weather.app.testapp.ui.fragment.ForecastInfoFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(this).inflate(R.layout.main, null);

        setContentView(view);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}
