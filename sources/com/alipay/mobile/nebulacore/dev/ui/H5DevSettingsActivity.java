package com.alipay.mobile.nebulacore.dev.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.wallet.H5WalletBaseActivity;

public class H5DevSettingsActivity extends H5WalletBaseActivity {
    public static final String TAG = "H5DevSettingsActivity";
    private boolean oldDebugSwitch = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.h5_dev_settings);
        Intent intent = getIntent();
        H5BugMeSettingsFragment h5BugMeSettingsFragment = new H5BugMeSettingsFragment();
        Bundle bundle2 = new Bundle();
        boolean z = (intent == null || intent.getExtras() == null || !TextUtils.equals(H5Utils.getString(intent.getExtras(), H5Param.H5_DEV_TYPE), H5Param.H5_DEV_H5APP)) ? false : true;
        this.oldDebugSwitch = H5DevConfig.getBooleanConfig(H5DevConfig.H5_BUG_ME_DEBUG_SWITCH, false);
        if (z) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_content, new H5DevSettingFragment()).commit();
            bundle2.putString(H5Param.H5_DEV_TYPE, H5Param.H5_DEV_H5APP);
            h5BugMeSettingsFragment.setArguments(bundle2);
            getFragmentManager().beginTransaction().replace(R.id.fragment_preference, h5BugMeSettingsFragment).commit();
            return;
        }
        bundle2.putString(H5Param.H5_DEV_TYPE, H5Param.H5_DEV_BUG_ME);
        h5BugMeSettingsFragment.setArguments(bundle2);
        getFragmentManager().beginTransaction().replace(R.id.fragment_content, h5BugMeSettingsFragment).commit();
        if (Nebula.DEBUG) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_preference, new H5BugMeExtFragment()).commit();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        H5Service h5Service;
        boolean booleanConfig = H5DevConfig.getBooleanConfig(H5DevConfig.H5_BUG_ME_DEBUG_SWITCH, false);
        if (!(booleanConfig == this.oldDebugSwitch || (h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName())) == null)) {
            h5Service.getBugMeManager().onBugMeSwitched(booleanConfig);
        }
        H5DevConfig.setBooleanConfig(H5DevConfig.h5_read_use_dev_db, false);
        super.onDestroy();
    }
}
