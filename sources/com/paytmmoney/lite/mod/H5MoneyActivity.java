package com.paytmmoney.lite.mod;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.appcompat.app.AppCompatActivity;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.paytmmoney.lite.mod.util.MoneyUtils;
import com.paytmmoney.lite.mod.util.PMConstants;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class H5MoneyActivity extends AppCompatActivity {
    private boolean cameraPermissionGranted = false;
    private DeepLinkData deepLinkData;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q.b("onCreate");
        checkForDeepLinkIntent(getIntent());
        checkIsUserLogged();
    }

    private void launchH5Page(String str, String str2, String str3) {
        q.b("H5:: launchH5Page");
        q.b("Lite Bundle Url - ".concat(String.valueOf(str)));
        if (URLUtil.isValidUrl(str)) {
            PaytmMoneyManager.INSTANCE.openH5Container(this, str2, str3, str, this.deepLinkData.f50283a, getH5ParamsBundle());
        }
    }

    public Bundle getH5ParamsBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("pullRefresh", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        bundle.putString("canPullDown", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        bundle.putBoolean("paytmShowTitleBar", false);
        bundle.putString("showLoading", H5Param.DEFAULT_LONG_PRESSO_LOGIN);
        bundle.putString("ssoToken", PaytmMoneyManager.INSTANCE.getSsoToken(getApplicationContext()));
        bundle.putString("userId", PaytmMoneyManager.INSTANCE.getUserId(getApplicationContext()));
        bundle.putString("Authorization", PaytmMoneyManager.INSTANCE.getAuthValue());
        bundle.putString("buildType", PaytmMoneyManager.INSTANCE.getBuildType());
        bundle.putString("ipv4", b.o());
        bundle.putLong("utc_offset", MoneyUtils.getUtcOffset());
        bundle.putString("platform", "android");
        bundle.putString("app_version", PaytmMoneyManager.INSTANCE.getAppVersion());
        bundle.putString("device_id", b.A(getApplicationContext()));
        bundle.putString("model", Build.MANUFACTURER + " " + Build.MODEL);
        bundle.putInt("os_version", b.d());
        bundle.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        bundle.putString("paytmChangeStatusBarColor", "#012B72");
        bundle.putString("clientId", PaytmMoneyManager.INSTANCE.getClientId());
        bundle.putString("pancard", PaytmMoneyManager.INSTANCE.getUserPancard(getApplicationContext()));
        return bundle;
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }

    private void checkForDeepLinkIntent(Intent intent) {
        if (intent.getExtras() != null && getIntent().hasExtra("EXTRA_DEEP_LINK_DATA")) {
            this.deepLinkData = (DeepLinkData) getIntent().getParcelableExtra("EXTRA_DEEP_LINK_DATA");
            if (this.deepLinkData != null) {
                q.b("deepLinkData uri - " + this.deepLinkData.f50283a);
                return;
            }
            q.b("deepLinkData is null");
        }
    }

    private void requestCameraAndStoragePermission() {
        if (!s.a() || s.a((Activity) this)) {
            this.cameraPermissionGranted = true;
            requestWriteStoragePermission();
            return;
        }
        androidx.core.app.a.a(this, new String[]{"android.permission.CAMERA"}, 51);
    }

    private void requestWriteStoragePermission() {
        if (!s.a()) {
            openMoneyH5Page();
        } else if (androidx.core.content.b.a((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            androidx.core.app.a.a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 5);
        } else if (this.cameraPermissionGranted) {
            openMoneyH5Page();
        }
    }

    private void handleAppRedirection() {
        q.b("handleAppRedirection deepLinkData - " + this.deepLinkData);
        DeepLinkData deepLinkData2 = this.deepLinkData;
        if (deepLinkData2 == null || TextUtils.isEmpty(deepLinkData2.f50283a)) {
            finish();
            return;
        }
        q.b("handleAppRedirection getMUrlType - " + this.deepLinkData.f50284b);
        q.b("handleAppRedirection getMDeepLinkUri - " + this.deepLinkData.f50289g);
        if (this.deepLinkData.f50283a.startsWith(PMConstants.PM_MINI_DEEPLINK_URL)) {
            Uri parse = Uri.parse(this.deepLinkData.f50283a);
            String str = PaytmMoneyManager.INSTANCE.getBuildType().equals(SDKConstants.KEY_STAGING_API) ? PMConstants.PM_MINI_STAGING_BUNDLE_URL : PMConstants.PM_MINI_PROD_BUNDLE_URL;
            String queryParameter = parse.getQueryParameter("pageName");
            q.b("handleAppRedirection url - ".concat(str));
            q.b("handleAppRedirection pageName - ".concat(String.valueOf(queryParameter)));
            if (!TextUtils.isEmpty(queryParameter)) {
                str = str + queryParameter;
            }
            q.b("handleAppRedirection url - ".concat(String.valueOf(str)));
            invokeGenericH5Flow(str, PMConstants.MONEY_VERTICAL_NAME, PMConstants.PM_MINI_UNIQUE_ID);
            return;
        }
        invokeMoneyLiteFlow();
    }

    private void invokeGenericH5Flow(String str, String str2, String str3) {
        q.b("invokeGenericH5Flow deepLinkData - " + this.deepLinkData);
        launchH5Page(str, str2, str3);
        finish();
    }

    private void invokeMoneyLiteFlow() {
        q.b("invokeMoneyLiteFlow isLiteOn - " + PaytmMoneyManager.INSTANCE.getGtmValue(this, CJRConstants.GTM_IS_LITE_ON_KEY));
        if (!((Boolean) PaytmMoneyManager.INSTANCE.getGtmValue(this, CJRConstants.GTM_IS_LITE_ON_KEY)).booleanValue()) {
            openSmartLinkUrl();
        } else if (!openPaytmMoneyNativeApp()) {
            openMoneyH5Page();
        }
    }

    private void checkIsUserLogged() {
        if (PaytmMoneyManager.INSTANCE.isUserSignedIn(this).booleanValue()) {
            handleAppRedirection();
        } else {
            PaytmMoneyManager.INSTANCE.openPaytmAuthActivity(this);
        }
    }

    private void openSmartLinkUrl() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(PMConstants.PAYTM_MONEY_SMART_LINK)));
        finish();
    }

    private boolean openPaytmMoneyNativeApp() {
        if (b.h((Context) this, PMConstants.PAYTM_MONEY_NATIVE_PACKAGE_NAME)) {
            try {
                Intent intent = new Intent();
                if (this.deepLinkData != null && !TextUtils.isEmpty(this.deepLinkData.f50283a)) {
                    String deepLinkUriForNative = MoneyUtils.getDeepLinkUriForNative(Uri.parse(this.deepLinkData.f50283a));
                    if (!TextUtils.isEmpty(deepLinkUriForNative)) {
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(deepLinkUriForNative));
                    }
                }
                intent.addFlags(268435456);
                startActivity(intent);
                finish();
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private void openMoneyH5Page() {
        launchH5Page((String) PaytmMoneyManager.INSTANCE.getGtmValue(this, CJRConstants.GTM_H5_BUNDLE_KEY), PMConstants.MONEY_VERTICAL_NAME, PMConstants.H5_MONEY_ID);
        finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 3) {
            return;
        }
        if (i3 == -1) {
            checkIsUserLogged();
        } else {
            finish();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        q.b("onRequestPermissionsResult requestCode - ".concat(String.valueOf(i2)));
        openMoneyH5Page();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }
}
