package net.one97.paytm;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.Toast;
import com.paytm.network.f;
import net.one97.paytm.DebugPreferenceActivity;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.paytm_finance.R;

public class DebugPreferenceActivity extends PaytmActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentManager().beginTransaction().replace(16908290, new a()).commit();
    }

    public static class a extends PreferenceFragment {
        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.debug_preference);
            findPreference("h5_url").setSummary(net.one97.paytm.marketplace.a.d());
            Preference findPreference = findPreference("MockUrlActivity");
            if (findPreference != null) {
                findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    public final boolean onPreferenceClick(Preference preference) {
                        return DebugPreferenceActivity.a.this.d(preference);
                    }
                });
            }
            Preference findPreference2 = findPreference("ClearNetworkCache");
            if (findPreference2 != null) {
                findPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    public final boolean onPreferenceClick(Preference preference) {
                        return DebugPreferenceActivity.a.this.c(preference);
                    }
                });
            }
            Preference findPreference3 = findPreference("MockHeaderActivity");
            if (findPreference3 != null) {
                findPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    public final boolean onPreferenceClick(Preference preference) {
                        return DebugPreferenceActivity.a.this.b(preference);
                    }
                });
            }
            Preference findPreference4 = findPreference("DynamicAppsFlyerLinkGenerate");
            if (findPreference4 != null) {
                findPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    public final boolean onPreferenceClick(Preference preference) {
                        return DebugPreferenceActivity.a.this.a(preference);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean d(Preference preference) {
            startActivity(new Intent(getActivity(), MockUrlActivity.class));
            return true;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean c(Preference preference) {
            f.b(CJRJarvisApplication.getAppContext()).getCache().clear();
            Toast.makeText(getActivity(), "Network Cache is Cleared", 0).show();
            return true;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean b(Preference preference) {
            startActivity(new Intent(getActivity(), MockHeaderActivity.class));
            return true;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean a(Preference preference) {
            startActivity(new Intent(getActivity(), MockAppsFlyerActivity.class));
            return true;
        }
    }
}
