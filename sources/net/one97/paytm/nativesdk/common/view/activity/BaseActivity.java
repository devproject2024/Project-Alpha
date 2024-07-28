package net.one97.paytm.nativesdk.common.view.activity;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import androidx.localbroadcastmanager.a.a;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.LocationManager;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.login.view.fragment.LoginFragment;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public abstract class BaseActivity extends PaytmActivity {
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (BaseActivity.this.shouldKillActivity()) {
                LogUtility.d(getClass().getSimpleName(), "Activity Kill Broadcast Received");
                String stringExtra = intent.getStringExtra(SDKConstants.SAVE_ACTIVITY);
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = "none";
                }
                BaseActivity.this.saveActivityFromFinish(stringExtra);
                BaseActivity.this.finish();
            }
        }
    };
    private ProgressDialog progressDialog;
    private String tagName;

    public abstract String getChildClassName();

    public abstract void saveActivityFromFinish(String str);

    public abstract boolean shouldKillActivity();

    public void showProgressDialog(boolean z) {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 == null || !progressDialog2.isShowing()) {
            hideKeyboard();
            this.progressDialog = DialogUtility.showProgressDialog(this, getString(R.string.please_wait_progress_msg), z);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
        }
        LocationManager.getManger().buildGoogleApiClient(getApplicationContext());
        screenRecordingCheck();
    }

    public void hideKeyboard() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public void changeFragment(Fragment fragment, boolean z) {
        q b2 = getSupportFragmentManager().a().b(R.id.fragment_container, fragment, LoginFragment.class.getName());
        if (z) {
            b2.a((String) null);
        }
        b2.c();
        supportInvalidateOptionsMenu();
    }

    public Fragment getVisibleFragment() {
        List<Fragment> d2 = getSupportFragmentManager().f3424a.d();
        if (d2 == null) {
            return null;
        }
        for (Fragment next : d2) {
            if (next != null && next.isVisible()) {
                return next;
            }
        }
        return null;
    }

    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                window.addFlags(Integer.MIN_VALUE);
                if (decorView != null) {
                    decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                window.setStatusBarColor(b.c(this, R.color.title_color));
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onResume() {
        super.onResume();
        hideKeyboard();
        a.a(getApplicationContext()).a(this.mMessageReceiver, new IntentFilter("kill"));
    }

    public void onDestroy() {
        super.onDestroy();
        a.a(getApplicationContext()).a(this.mMessageReceiver);
    }

    /* access modifiers changed from: protected */
    public void screenRecordingCheck() {
        if (PaytmSDK.isRecordingDisable()) {
            getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        }
    }
}
