package com.alipay.mobile.nebulacore.wallet;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.alipay.mobile.nebula.activity.H5BaseActivity;
import com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppInfo;
import com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList;
import com.alipay.mobile.nebula.appcenter.apphandler.H5InstallAppAdvice;
import com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.provider.H5BugMeRpcAuthProvider;
import com.alipay.mobile.nebula.provider.H5EnvProvider;
import com.alipay.mobile.nebula.provider.H5LoadingDialog;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.sendbird.android.constant.StringSet;

public class H5DevAppActivity extends H5BaseActivity {
    /* access modifiers changed from: private */
    public String devAppId = "";
    private boolean enableBugMe = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        H5Log.d(H5BugMeDevApp.TAG, "H5DevAppActivity onCreate " + getIntent().getExtras());
        String stringExtra = getIntent().getStringExtra(StringSet.token);
        String stringExtra2 = getIntent().getStringExtra("scheme");
        final Uri parseUrl = H5UrlHelper.parseUrl(stringExtra2);
        if (parseUrl == null) {
            finish();
            return;
        }
        this.enableBugMe = "true".equals(getIntent().getStringExtra("enableBugme"));
        this.devAppId = getValue(parseUrl, "appId");
        String value = getValue(parseUrl, H5InstallAppAdvice.nbsource);
        String value2 = getValue(parseUrl, H5PreferAppList.nbsn);
        String value3 = getValue(parseUrl, H5PreferAppList.nbsv);
        final H5DevAppInfo h5DevAppInfo = new H5DevAppInfo();
        h5DevAppInfo.nbsn = value2;
        h5DevAppInfo.nbsv = value3;
        H5Log.d(H5BaseActivity.TAG, "devAppId " + this.devAppId + " nbsource:" + value + " nbsn:" + value2 + " nbsv:" + value3 + " enableBugme:" + this.enableBugMe);
        final boolean equals = TextUtils.equals(value, "debug");
        if (!Nebula.DEBUG || !H5DevConfig.getBooleanConfig(H5DevConfig.h5_read_use_dev_app_config, false) || !equals) {
            final H5LoadingDialog h5LoadingDialog = (H5LoadingDialog) Nebula.getProviderManager().getProvider(H5LoadingDialog.class.getName());
            if (h5LoadingDialog != null) {
                h5LoadingDialog.showLoading(this, "requesting data");
            }
            H5BugMeRpcAuthProvider h5BugMeRpcAuthProvider = (H5BugMeRpcAuthProvider) Nebula.getProviderManager().getProvider(H5BugMeRpcAuthProvider.class.getName());
            if (h5BugMeRpcAuthProvider != null) {
                h5BugMeRpcAuthProvider.rpcAuth(this.devAppId, value2, stringExtra2, stringExtra, new H5BugMeRpcAuthProvider.AuthRpcCallback() {
                    public void onResponse(boolean z, boolean z2, String[] strArr) {
                        H5Utils.runOnMain(new Runnable() {
                            public void run() {
                                if (h5LoadingDialog != null) {
                                    h5LoadingDialog.hide();
                                }
                            }
                        });
                        if (z) {
                            if (equals) {
                                H5DevAppList.getInstance().add(H5DevAppActivity.this.devAppId, h5DevAppInfo);
                            }
                            H5DevAppActivity.this.onBugMeRpcResult(parseUrl, strArr);
                        } else {
                            if (equals) {
                                H5DevAppList.getInstance().remove(H5DevAppActivity.this.devAppId);
                            }
                            H5Utils.runOnMain(new Runnable() {
                                public void run() {
                                    Toast.makeText(H5Utils.getContext(), H5Environment.getResources().getString(R.string.h5_dev_app_toast), 0).show();
                                }
                            });
                        }
                        H5DevAppActivity.this.finish();
                    }
                });
                return;
            }
            return;
        }
        H5DevAppList.getInstance().add(this.devAppId, h5DevAppInfo);
        onBugMeRpcResult(parseUrl, (String[]) null);
        finish();
    }

    public String getValue(Uri uri, String str) {
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter == null || "".equals(queryParameter)) {
            return null;
        }
        return queryParameter;
    }

    /* access modifiers changed from: private */
    public void onBugMeRpcResult(Uri uri, String[] strArr) {
        if (uri != null) {
            if (this.enableBugMe) {
                String str = "";
                if (strArr != null) {
                    for (String str2 : strArr) {
                        str = str + H5UrlHelper.encode(str2) + "|";
                    }
                }
                uri = uri.buildUpon().appendQueryParameter("enableBugme", String.valueOf(this.enableBugMe)).appendQueryParameter("domainWhiteList", str).build();
            }
            H5EnvProvider h5EnvProvider = (H5EnvProvider) Nebula.getProviderManager().getProvider(H5EnvProvider.class.getName());
            if (h5EnvProvider != null) {
                h5EnvProvider.goToSchemeService(uri.toString());
            }
        }
    }

    public void onResume() {
        super.onResume();
        H5Log.d(H5BugMeDevApp.TAG, "H5DevAppActivity onResume ");
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
