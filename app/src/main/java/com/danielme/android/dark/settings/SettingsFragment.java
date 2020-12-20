package com.danielme.android.dark.settings;

import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

import com.danielme.android.dark.R;

public class SettingsFragment extends PreferenceFragmentCompat {

  @Override
  public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
    setPreferencesFromResource(R.xml.app_settings, rootKey);

    ListPreference themePreference = getPreferenceManager().findPreference(getString(R.string.settings_theme_key));
    if (themePreference.getValue() == null) {
      themePreference.setValue(ThemeSetup.Mode.DEFAULT.name());
    }
    themePreference.setOnPreferenceChangeListener((preference, newValue) -> {
      ThemeSetup.applyTheme(ThemeSetup.Mode.valueOf((String) newValue));
      return true;
    });
  }


}