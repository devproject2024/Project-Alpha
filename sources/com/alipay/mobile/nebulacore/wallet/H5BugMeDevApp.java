package com.alipay.mobile.nebulacore.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.framework.app.a;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;

public class H5BugMeDevApp extends a {
    static final String KEY_ENABLE_BUGME = "enableBugme";
    static final String KEY_SCHEME = "scheme";
    static final String KEY_TOKEN = "token";
    static final String KEY_WHITE_LIST = "domainWhiteList";
    public static final String TAG = "H5BugMeDevApp";
    private Bundle bundle;

    public String getEntryClassName() {
        return null;
    }

    public void onCreate(Bundle bundle2) {
        this.bundle = bundle2;
    }

    public void onStart() {
        H5Log.d(TAG, "onStart: " + this.bundle);
        String string = H5Utils.getString(this.bundle, "token");
        String string2 = H5Utils.getString(this.bundle, KEY_SCHEME);
        String string3 = H5Utils.getString(this.bundle, KEY_ENABLE_BUGME);
        if (TextUtils.isEmpty(string2)) {
            destroy((Bundle) null);
            return;
        }
        Intent intent = new Intent(H5Utils.getContext(), H5DevAppActivity.class);
        intent.addFlags(65536);
        intent.putExtra("token", string);
        intent.putExtra(KEY_SCHEME, string2);
        intent.putExtra(KEY_ENABLE_BUGME, string3);
        getMicroApplicationContext().a(this, intent);
    }

    public void onRestart(Bundle bundle2) {
        H5Log.d(TAG, "H5BugMeDevApp onRestart");
    }

    public void onStop() {
        H5Log.d(TAG, "H5BugMeDevApp onStop");
    }

    public void onDestroy(Bundle bundle2) {
        H5Log.d(TAG, "H5BugMeDevApp onDestroy");
    }
}
