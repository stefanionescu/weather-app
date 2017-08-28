package com.weather.app.testapp.ui.viewmodel;

/**
 * This view model is a adapter from other model, usually a domain model, if in any moment the
 * application need to show other model we only need to create a new adapter for a viewmodel and the
 * view continue working
 * <p/>
 * This abstract model is for use with model.xml in layouts (or other with the same information)
 *
 * @author stefan
 */
public abstract class Model {

    public abstract String getTitle();

}
