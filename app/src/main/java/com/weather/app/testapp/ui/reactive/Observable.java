package com.weather.app.testapp.ui.reactive;

/**
 * @author stefan
 */
public interface Observable<T> {

    void register(T observer);

    void unregister(T observer);
}
