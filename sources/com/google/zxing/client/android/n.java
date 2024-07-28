package com.google.zxing.client.android;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public final class n extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private CheckBoxPreference[] f40262a;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        preferenceScreen.getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        String[] strArr = {"preferences_decode_1D_product", "preferences_decode_1D_industrial", "preferences_decode_QR", "preferences_decode_Data_Matrix", "preferences_decode_Aztec", "preferences_decode_PDF417"};
        CheckBoxPreference[] checkBoxPreferenceArr = new CheckBoxPreference[6];
        for (int i2 = 0; i2 < 6; i2++) {
            checkBoxPreferenceArr[i2] = (CheckBoxPreference) preferenceScreen.findPreference(strArr[i2]);
        }
        this.f40262a = checkBoxPreferenceArr;
        a();
        ((EditTextPreference) preferenceScreen.findPreference("preferences_custom_product_search")).setOnPreferenceChangeListener(new a(this, (byte) 0));
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        a();
    }

    private void a() {
        ArrayList arrayList = new ArrayList(this.f40262a.length);
        for (CheckBoxPreference checkBoxPreference : this.f40262a) {
            if (checkBoxPreference.isChecked()) {
                arrayList.add(checkBoxPreference);
            }
        }
        boolean z = arrayList.size() <= 1;
        for (CheckBoxPreference checkBoxPreference2 : this.f40262a) {
            checkBoxPreference2.setEnabled(!z || !arrayList.contains(checkBoxPreference2));
        }
    }

    class a implements Preference.OnPreferenceChangeListener {
        private a() {
        }

        /* synthetic */ a(n nVar, byte b2) {
            this();
        }

        public final boolean onPreferenceChange(Preference preference, Object obj) {
            if (a(obj)) {
                return true;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(n.this.getActivity());
            builder.setTitle(R.string.msg_error);
            builder.setMessage(R.string.msg_invalid_value);
            builder.setCancelable(true);
            builder.show();
            return false;
        }

        private static boolean a(Object obj) {
            if (obj == null) {
                return true;
            }
            String obj2 = obj.toString();
            if (obj2.isEmpty()) {
                return true;
            }
            try {
                if (new URI(obj2.replaceAll("%[st]", "").replaceAll("%f(?![0-9a-f])", "")).getScheme() != null) {
                    return true;
                }
                return false;
            } catch (URISyntaxException unused) {
            }
        }
    }
}
