package com.weather.app.testapp.executor;

/**
 * @author stefan
 */
public interface MainThreadExecutor {

    void execute(Runnable runnable);
}
