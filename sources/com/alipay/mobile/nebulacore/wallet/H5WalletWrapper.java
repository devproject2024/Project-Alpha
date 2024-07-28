package com.alipay.mobile.nebulacore.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.framework.a;
import com.alipay.mobile.framework.app.f;
import com.alipay.mobile.framework.app.ui.BaseActivity;
import com.alipay.mobile.framework.app.ui.BaseFragmentActivity;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.framework.c;
import com.alipay.mobile.h5container.api.H5Context;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.RnService;
import com.alipay.mobile.h5container.service.UcService;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class H5WalletWrapper {
    public static final String TAG = "H5WalletWrapper";

    public static Resources getResources() {
        b.a().b();
        return a.a();
    }

    public static UcService getUcService() {
        b.a();
        return (UcService) c.a(UcService.class.getName());
    }

    public static RnService getRnService() {
        b.a();
        return (RnService) c.a(RnService.class.getName());
    }

    public static Class<?> getClass(String str, String str2) {
        H5Log.d("H5WalletWrapper", "getClass " + str + AppConstants.COLON + str2);
        try {
            b.a().b();
            ClassLoader b2 = a.b();
            if (b2 != null) {
                return b2.loadClass(str2);
            }
            return null;
        } catch (Throwable th) {
            if (!H5Environment.isInWallet()) {
                return null;
            }
            H5Log.e("H5WalletWrapper", "failed to load class bundle.", th);
            return null;
        }
    }

    public static void startActivity(H5Context h5Context, Intent intent) {
        Context context;
        if (intent == null) {
            H5Log.w("H5WalletWrapper", "invalid event parameter");
            return;
        }
        f microApplication = getMicroApplication(h5Context);
        if (microApplication != null) {
            try {
                H5Log.debug("H5WalletWrapper", "microApp != null getMicroApplicationContext().startActivity");
                b.a().f14954a.a(microApplication, intent);
            } catch (Exception e2) {
                H5Log.e("H5WalletWrapper", "startActivity exception", e2);
            }
        } else {
            if (h5Context == null || h5Context.getContext() == null) {
                context = H5Environment.getContext();
            } else {
                context = h5Context.getContext();
            }
            H5Log.debug("H5WalletWrapper", "context ".concat(String.valueOf(context)));
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public static String getSessionId(H5Context h5Context, Bundle bundle) {
        f microApplication;
        if (bundle == null) {
            return null;
        }
        String string = H5Utils.getString(bundle, H5Param.SESSION_ID);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if ((h5Context instanceof WalletContext) && (microApplication = ((WalletContext) h5Context).getMicroApplication()) != null && !TextUtils.isEmpty(microApplication.getAppId())) {
            String appId = microApplication.getAppId();
            bundle.putString("appId", appId);
            string = "h5session_".concat(String.valueOf(appId));
        }
        return TextUtils.isEmpty(string) ? "h5session_default" : string;
    }

    public static f getMicroApplication(H5Context h5Context) {
        com.alipay.mobile.framework.app.a aVar = null;
        if (h5Context == null) {
            return null;
        }
        Context context = h5Context.getContext();
        if (context instanceof BaseActivity) {
            aVar = ((BaseActivity) context).getActivityApplication();
        } else if (context instanceof BaseFragmentActivity) {
            aVar = ((BaseFragmentActivity) context).getActivityApplication();
        }
        return (aVar != null || !(h5Context instanceof WalletContext)) ? aVar : ((WalletContext) h5Context).getMicroApplication();
    }
}
