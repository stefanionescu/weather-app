package com.weather.app.testapp.ui.presenter;

import com.weather.app.testapp.ui.view.View;

/**
 * Presenter with lifecycle
 *
 * @author stefan
 */
public interface Presenter<T extends View> {

    void initialize();

    void onViewCreate();

    void onViewResume();

    void onViewDestroy();

    void setView(T view);
}

