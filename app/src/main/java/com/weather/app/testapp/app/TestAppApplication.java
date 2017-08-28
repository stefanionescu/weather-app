package com.weather.app.testapp.app;

import android.app.Application;
import android.content.Context;

import com.weather.app.testapp.app.dependencyinjection.RootModule;

import dagger.ObjectGraph;

public class TestAppApplication extends Application {

    private ObjectGraph objectGraph;

    public static TestAppApplication get(Context context) {
        return (TestAppApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(new RootModule(this));
        objectGraph.inject(this);
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }

    public void addModules(Object... modules) {
        objectGraph.plus(modules);
    }
}
