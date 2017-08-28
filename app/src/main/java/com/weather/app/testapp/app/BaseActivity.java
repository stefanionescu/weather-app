package com.weather.app.testapp.app;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

public abstract class BaseActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        injectViews();
    }

    private void injectDependencies() {
        TestAppApplication testAppApplication = (TestAppApplication) getApplication();
        testAppApplication.inject(this);
    }


    private void injectViews() {
        ButterKnife.bind(this);
    }
}
