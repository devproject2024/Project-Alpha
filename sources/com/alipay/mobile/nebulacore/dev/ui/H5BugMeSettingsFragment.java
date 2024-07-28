package com.alipay.mobile.nebulacore.dev.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;

public class H5BugMeSettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static final String TAG = "H5BugMeSettingsFragment";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && H5Param.H5_DEV_H5APP.equals(H5Utils.getString(arguments, H5Param.H5_DEV_TYPE))) {
            addPreferencesFromResource(R.xml.h5_dev_h5app_setting);
        } else if (arguments != null && H5Param.H5_DEV_BUG_ME.equals(H5Utils.getString(arguments, H5Param.H5_DEV_TYPE))) {
            addPreferencesFromResource(R.xml.h5_bugme_setting);
        }
        initSummary(getPreferenceScreen());
        try {
            if (!Nebula.DEBUG) {
                PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("h5_bugme_advance_category");
                if (getPreferenceScreen() != null) {
                    getPreferenceScreen().removePreference(preferenceCategory);
                }
            }
        } catch (Throwable th) {
            H5Log.e(TAG, "Remove debug setting", th);
        }
    }

    public void onResume() {
        super.onResume();
        if (getPreferenceScreen() != null && getPreferenceScreen().getSharedPreferences() != null) {
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }
    }

    public void onPause() {
        super.onPause();
        if (getPreferenceScreen() != null && getPreferenceScreen().getSharedPreferences() != null) {
            getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        updateSummary(findPreference(str));
    }

    private void initSummary(Preference preference) {
        if (preference instanceof PreferenceGroup) {
            PreferenceGroup preferenceGroup = (PreferenceGroup) preference;
            for (int i2 = 0; i2 < preferenceGroup.getPreferenceCount(); i2++) {
                initSummary(preferenceGroup.getPreference(i2));
            }
            return;
        }
        updateSummary(preference);
    }

    private void updateSummary(Preference preference) {
        if (preference instanceof ListPreference) {
            preference.setSummary(((ListPreference) preference).getEntry());
        } else if (preference instanceof EditTextPreference) {
            EditTextPreference editTextPreference = (EditTextPreference) preference;
            if (preference.getTitle().toString().contains("password")) {
                preference.setSummary("******");
            } else {
                preference.setSummary(editTextPreference.getText());
            }
        } else if (preference instanceof MultiSelectListPreference) {
            preference.setSummary(((EditTextPreference) preference).getText());
        }
    }
}
