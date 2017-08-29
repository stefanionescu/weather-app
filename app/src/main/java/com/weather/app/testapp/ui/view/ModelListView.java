package com.weather.app.testapp.ui.view;


import com.weather.app.testapp.ui.viewmodel.Model;

import java.util.List;

/**
 * @author stefan
 */
public interface ModelListView extends View {


    void add(Model model);

    void add(List<Model> models);

    void remove(Model model);


}
