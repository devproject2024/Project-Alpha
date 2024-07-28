package net.one97.paytm.dynamic.module.h5sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import net.one97.paytm.deeplink.u;

public class H5CommunicatorImpl implements u.a {
    public H5CommunicatorImpl() {
        u.a().f50377i = this;
    }

    public void init(Application application, String str) {
        PaytmH5ManagerImpl.INSTANCE.init(application, str);
        PhoenixManagerImpl.INSTANCE.init(application, str);
    }

    public void loadPage(String str, String str2, String str3, Bundle bundle, String str4, boolean z, Context context) {
        H5ManagerHelper.loadPage(str, str2, str3, bundle, str4, z, context);
    }

    public void handleDeeplink(Context context, String str) {
        H5InternalDeeplinkHandler.handleDeeplink(context, str);
    }

    public void clearCache(Activity activity) {
        PhoenixManagerImpl.INSTANCE.clearCache(activity);
        PaytmH5ManagerImpl.INSTANCE.clearCache(activity);
    }
}
