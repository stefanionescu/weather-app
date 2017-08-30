package com.weather.app.testapp.executor;

import android.os.Handler;
import android.os.Looper;

/**
 * MainScope Thread executor using the classic Looper.getMainLooper() from Android
 *
 * @author stefan
 */
public class MainThreadExecutorImp implements MainThreadExecutor {

    private Handler handler;

    public MainThreadExecutorImp() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}
