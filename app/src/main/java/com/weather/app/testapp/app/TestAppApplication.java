package com.weather.app.testapp.app;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.weather.app.testapp.app.dependencyinjection.components.DaggerTestAppComponent;
import com.weather.app.testapp.app.dependencyinjection.components.TestAppComponent;
import com.weather.app.testapp.app.dependencyinjection.modules.RootModule;

public class TestAppApplication extends Application {

    private static TestAppComponent component;

    public static TestAppApplication get(Context context) {
        return (TestAppApplication) context.getApplicationContext();
    }

    public TestAppComponent getComponent() {
        return component;
    }

    public static TestAppComponent getComponent( Context context ) {
        return ((TestAppApplication)context.getApplicationContext()).getComponent();
    }

    @Override
    public void onCreate() {

        super.onCreate();

        component = DaggerTestAppComponent.builder()
                .rootModule(new RootModule(getApplicationContext()))
                .build();

        component.inject(this);

        setupLeakCanary();

    }

    protected RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

}
