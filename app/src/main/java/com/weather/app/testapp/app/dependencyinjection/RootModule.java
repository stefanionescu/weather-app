package com.weather.app.testapp.app.dependencyinjection;

import android.content.Context;
import android.view.LayoutInflater;

import com.weather.app.testapp.app.TestAppApplication;
import com.weather.app.testapp.ui.activity.MainActivity;
import com.weather.app.testapp.ui.activity.ModelInfoActivity;
import com.weather.app.testapp.ui.fragment.ForecastInfoFragment;
import com.weather.app.testapp.ui.fragment.ForecastListFragment;
import com.weather.app.testapp.ui.presenter.ForecastListPresenterImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        includes = {
                ExecutorModule.class,
                InteractorModule.class,
                RepositoryModule.class,
                PresenterModule.class,
                ReactiveModule.class,
        },
        injects = {
                TestAppApplication.class,
                ForecastListFragment.class,
                ForecastInfoFragment.class,
                ForecastListPresenterImp.class,
                MainActivity.class,
                ForecastInfoFragment.class,
                ModelInfoActivity.class,
                MainActivity.class
        },
        library = true
)
public class RootModule {

    private final Context context;

    public RootModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return context;
    }

    @Provides
    public LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(context);
    }
}
