package com.danielme.android.dark.settings;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.danielme.android.dark.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.app_settings, rootKey);

        getPreferenceManager()
                .findPreference(getString(R.string.settings_theme_key))
                .setOnPreferenceChangeListener((preference, newValue) -> {
                    ThemeSetup.applyTheme((String) newValue, getContext());
                    return true;
                });
    }


}