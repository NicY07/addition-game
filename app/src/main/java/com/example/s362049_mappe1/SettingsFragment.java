package com.example.s362049_mappe1;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import java.util.List;

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String
            rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Register a preference change listener for the "enable_feature" preference
        ListPreference sprakPref = findPreference("sprakpref");
        sprakPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                int verdi = Integer.parseInt((String) newValue);
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("sprakpreferanse", Integer.toString(verdi));
                editor.commit();
                if (verdi == 0) {
                    LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("nb-NO");
                    AppCompatDelegate.setApplicationLocales(appLocale);
                } else if (verdi == 1) {
                    LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("de-DE");
                    AppCompatDelegate.setApplicationLocales(appLocale);
                }
                getActivity().recreate();
                return true;
            }
        });

        ListPreference antPref = findPreference("antallpref");
        antPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                String verdi = (String) newValue;
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("antallpreferanse", verdi);
                editor.commit();
                return true;
            }
        });
    }
}