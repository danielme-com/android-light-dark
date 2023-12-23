package com.danielme.android.dark;

import android.app.Application;

import com.danielme.android.dark.settings.ThemeSetup;

public class LightDarkApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ThemeSetup.applyTheme(this);
    }

}
