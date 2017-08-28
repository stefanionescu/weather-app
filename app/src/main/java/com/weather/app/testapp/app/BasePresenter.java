package com.weather.app.testapp.app;

import android.content.Context;

public class BasePresenter {

    public BasePresenter(Context context) {
        ((TestAppApplication) context.getApplicationContext()).inject(this);

    }
}
