package com.weather.app.testapp.app.dependencyinjection.modules;

import com.weather.app.testapp.executor.InteractorExecutor;
import com.weather.app.testapp.executor.MainThreadExecutor;
import com.weather.app.testapp.executor.MainThreadExecutorImp;
import com.weather.app.testapp.executor.ThreadExecutor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ExecutorModule {

    @Provides
    @Named("interactor_exec")
    public InteractorExecutor provideExecutor() {
        return new ThreadExecutor();
    }

    @Provides
    @Named("main_exec")
    public MainThreadExecutor provideMainThreadExecutor() {
        return new MainThreadExecutorImp();
    }
}
