package com.paytmmall.artifact.debug;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.Toast;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.common.BaseActivity;
import com.paytmmall.artifact.debug.MallDebugPreferenceActivity;

public class MallDebugPreferenceActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentManager().beginTransaction().replace(16908290, new a()).commit();
    }

    public static class a extends PreferenceFragment {
        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.mall_debug_preference);
            findPreference("h5_url").setSummary(com.paytmmall.a.a.e());
            Preference findPreference = findPreference("MockUrlActivity");
            if (findPreference != null) {
                findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    public final boolean onPreferenceClick(Preference preference) {
                        return MallDebugPreferenceActivity.a.this.b(preference);
                    }
                });
            }
            Preference findPreference2 = findPreference("ClearNetworkCache");
            if (findPreference2 != null) {
                findPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    public final boolean onPreferenceClick(Preference preference) {
                        return MallDebugPreferenceActivity.a.this.a(preference);
                    }
                });
            }
            Preference findPreference3 = findPreference("MockHeaderActivity");
            if (findPreference3 != null) {
                findPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    public final boolean onPreferenceClick(Preference preference) {
                        a.this.startActivity(new Intent(a.this.getActivity(), MallMockHeaderActivity.class));
                        return true;
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean b(Preference preference) {
            startActivity(new Intent(getActivity(), MallMockUrlActivity.class));
            return true;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean a(Preference preference) {
            Toast.makeText(getActivity(), "Network Cache is Cleared", 0).show();
            return true;
        }
    }
}
