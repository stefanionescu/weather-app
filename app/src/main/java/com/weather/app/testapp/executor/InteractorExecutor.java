package com.weather.app.testapp.executor;

/**
 * Interface to create executors, the executors will only execute Interactors
 *
 * @author stefan
 */
public interface InteractorExecutor {

    void run(Interactor interactor);
}
