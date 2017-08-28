package com.weather.app.testapp.app.dependencyinjection;

import com.weather.app.testapp.executor.InteractorExecutor;
import com.weather.app.testapp.executor.MainThreadExecutor;
import com.weather.app.testapp.executor.MainThreadExecutorImp;
import com.weather.app.testapp.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        complete = false,
        library = true
)
public class ExecutorModule {


    @Provides
    @Singleton
    public InteractorExecutor provideExecutor() {
        return new ThreadExecutor();
    }

    @Provides
    @Singleton
    public MainThreadExecutor provideMainThreadExecutor() {
        return new MainThreadExecutorImp();
    }
}
