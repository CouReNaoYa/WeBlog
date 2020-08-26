package com.example.weblog.application;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    public Context getApplication() {
        return getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
