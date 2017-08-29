package com.weather.app.testapp.app;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.ButterKnife;

/**
 * @author stefan
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
    }

    private void injectDependencies() {
        TestAppApplication testAppApplication = (TestAppApplication) getActivity().getApplication();
        testAppApplication.inject(this);
    }

    private void injectViews(View view) {
        ButterKnife.bind(this, view);
    }

}
