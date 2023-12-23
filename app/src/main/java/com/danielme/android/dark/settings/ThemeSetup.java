package com.danielme.android.dark.settings;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import com.danielme.android.dark.R;

public final class ThemeSetup {

    private ThemeSetup() {
    }

    public static void applyTheme(String mode, Context context) {
        if (context.getString(R.string.settings_theme_value_dark).equals(mode)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else if (context.getString(R.string.settings_theme_value_light).equals(mode)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }

    public static void applyTheme(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String value = defaultSharedPreferences.getString(context.getString(R.string.settings_theme_key),
                context.getString(R.string.settings_theme_value_default));
        applyTheme(value, context);
    }

}
