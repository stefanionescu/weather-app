package com.weather.app.testapp.ui.view;


import com.weather.app.testapp.ui.viewmodel.Model;

import java.util.List;

/**
 * Model collection view is designed to be used in different scenarios, in this concrete case
 * the collection is of characters but can be of Users or Animals, but the view can be the same
 *
 * @author stefan
 */
public interface ModelListView extends View {


    void add(Model model);

    void add(List<Model> models);

    void remove(Model model);


}
