package com.alipay.mobile.nebulacore.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import com.alipay.mobile.framework.app.ui.BaseFragmentActivity;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.nebula.appcenter.util.H5AppInstallStep;
import com.alipay.mobile.nebula.callback.H5AppInstallProcess;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5SplitCompatUtils;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.appcenter.H5IApplicationInstallerImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.util.HashMap;

public class H5NebulaAppActivity extends BaseFragmentActivity {
    private static final String TAG = "H5NebulaAppActivity";

    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        try {
            bundle2 = getIntent().getExtras();
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            bundle2 = null;
        }
        final Bundle bundle3 = bundle2;
        final String string = H5Utils.getString(bundle3, H5IApplicationInstallerImpl.NEBULA_FALLBACK_APP_ID);
        H5Log.d(TAG, "appId ".concat(String.valueOf(string)));
        final H5LoadingDialog h5LoadingDialog = new H5LoadingDialog(this);
        h5LoadingDialog.setCancelable(true);
        h5LoadingDialog.setMessage(H5Environment.getResources().getString(R.string.h5_loading_txt));
        h5LoadingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (!H5NebulaAppActivity.this.isFinishing()) {
                    H5NebulaAppActivity.this.finish();
                }
            }
        });
        h5LoadingDialog.show();
        final H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
        if (h5AppProvider == null) {
            finish();
        } else {
            H5Utils.getExecutor(H5ThreadType.RPC).execute(new Runnable() {
                public void run() {
                    HashMap hashMap = new HashMap();
                    hashMap.put(string, (Object) null);
                    h5AppProvider.startUpdateApp(hashMap, new H5AppInstallProcess() {
                        public void prepare(H5AppInstallStep h5AppInstallStep, String str) {
                        }

                        public void onResult(final boolean z, boolean z2) {
                            H5Utils.runOnMain(new Runnable() {
                                public void run() {
                                    if (!H5NebulaAppActivity.this.isFinishing()) {
                                        H5Log.d(H5NebulaAppActivity.TAG, "update result:" + z);
                                        if (h5AppProvider.getAppInfo(string) != null) {
                                            if (h5LoadingDialog != null) {
                                                h5LoadingDialog.dismiss();
                                            }
                                            bundle3.remove(H5IApplicationInstallerImpl.NEBULA_FALLBACK_APP_ID);
                                            b.a().f14954a.a((String) null, string, bundle3);
                                            H5NebulaAppActivity.this.finish();
                                            return;
                                        }
                                        H5Utils.runOnMain(new Runnable() {
                                            public void run() {
                                                Toast.makeText(H5Utils.getContext(), H5Environment.getResources().getString(R.string.h5_update_fail), 0).show();
                                                if (h5LoadingDialog != null) {
                                                    h5LoadingDialog.dismiss();
                                                }
                                                H5NebulaAppActivity.this.finish();
                                            }
                                        });
                                    }
                                }
                            });
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        H5SplitCompatUtils.doInstall(this);
    }
}
