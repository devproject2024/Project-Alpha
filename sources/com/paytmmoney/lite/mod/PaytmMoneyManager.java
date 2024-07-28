package com.paytmmoney.lite.mod;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.helper.IMoneyListener;
import kotlin.g.b.k;

public final class PaytmMoneyManager {
    public static final PaytmMoneyManager INSTANCE = new PaytmMoneyManager();
    public static Application application;
    private static IMoneyListener genericListener;
    private static boolean isInitCalled;
    private static boolean isLoggable;

    private PaytmMoneyManager() {
    }

    public final Application getApplication() {
        Application application2 = application;
        if (application2 == null) {
            k.a("application");
        }
        return application2;
    }

    public final void setApplication(Application application2) {
        k.c(application2, "<set-?>");
        application = application2;
    }

    public final boolean isLoggable() {
        return isLoggable;
    }

    public final void setLoggable(boolean z) {
        isLoggable = z;
    }

    public final boolean isInitCalled() {
        return isInitCalled;
    }

    public final void setInitCalled(boolean z) {
        isInitCalled = z;
    }

    public final synchronized void init(Application application2, boolean z) {
        k.c(application2, "application");
        q.d("init");
        if (!isInitCalled) {
            application = application2;
            isLoggable = z;
            isInitCalled = true;
        }
    }

    public final synchronized void initListeners(IMoneyListener iMoneyListener) {
        q.d("initListeners genericListener - {" + iMoneyListener + '}');
        genericListener = iMoneyListener;
    }

    public final void openH5Container(Activity activity, String str, String str2, String str3, String str4, Bundle bundle) {
        k.c(str, "verticalName");
        k.c(str2, "appUniqueId");
        k.c(str3, "url");
        q.d("openH5Container url - ".concat(String.valueOf(str3)));
        q.d("openH5Container deepLinkUrl - ".concat(String.valueOf(str4)));
        q.d("openH5Container bundle - ".concat(String.valueOf(bundle)));
        IMoneyListener iMoneyListener = genericListener;
        if (iMoneyListener != null) {
            iMoneyListener.loadPage(activity, str, str2, str3, str4, bundle);
        }
    }

    public final void openH5InitActivity(Activity activity, Intent intent) {
        k.c(activity, "activity");
        k.c(intent, "pageIntent");
        Intent intent2 = new Intent(activity, H5MoneyActivity.class);
        intent2.putExtras(intent);
        activity.startActivity(intent2);
    }

    public final String getAuthValue() {
        StringBuilder sb = new StringBuilder("getAuthValue bundle - ");
        IMoneyListener iMoneyListener = genericListener;
        sb.append(iMoneyListener != null ? iMoneyListener.getAuthValue() : null);
        q.d(sb.toString());
        IMoneyListener iMoneyListener2 = genericListener;
        if (iMoneyListener2 != null) {
            return iMoneyListener2.getAuthValue();
        }
        return null;
    }

    public final Object getGtmValue(Context context, String str) {
        k.c(str, "key");
        IMoneyListener iMoneyListener = genericListener;
        if (iMoneyListener != null) {
            return iMoneyListener.getGtmValue(context, str);
        }
        return null;
    }

    public final void openPaytmAuthActivity(Activity activity) {
        q.d("openPaytmAuthActivity");
        IMoneyListener iMoneyListener = genericListener;
        if (iMoneyListener != null) {
            iMoneyListener.openPaytmAuth(activity);
        }
    }

    public final Boolean isUserSignedIn(Context context) {
        IMoneyListener iMoneyListener = genericListener;
        if (iMoneyListener != null) {
            return Boolean.valueOf(iMoneyListener.isUserSignedIn(context));
        }
        return null;
    }

    public final String getAppVersion() {
        IMoneyListener iMoneyListener = genericListener;
        if (iMoneyListener != null) {
            return iMoneyListener.getAppVersion();
        }
        return null;
    }

    public final String getSsoToken(Context context) {
        IMoneyListener iMoneyListener = genericListener;
        if (iMoneyListener != null) {
            return iMoneyListener.getSSOToken(context);
        }
        return null;
    }

    public final String getUserId(Context context) {
        IMoneyListener iMoneyListener = genericListener;
        if (iMoneyListener != null) {
            return iMoneyListener.getUserId(context);
        }
        return null;
    }

    public final String getClientId() {
        IMoneyListener iMoneyListener = genericListener;
        if (iMoneyListener != null) {
            return iMoneyListener.getClientId();
        }
        return null;
    }

    public final String getUserPancard(Context context) {
        IMoneyListener iMoneyListener = genericListener;
        if (iMoneyListener != null) {
            return iMoneyListener.getUserPancard(context);
        }
        return null;
    }

    public final String getBuildType() {
        IMoneyListener iMoneyListener = genericListener;
        if (iMoneyListener != null) {
            return iMoneyListener.getBuildType();
        }
        return null;
    }
}
