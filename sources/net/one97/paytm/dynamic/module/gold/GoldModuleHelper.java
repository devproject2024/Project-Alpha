package net.one97.paytm.dynamic.module.gold;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.URLUtil;
import com.paytm.finance.gold.a.a;
import com.paytm.finance.gold.a.b;
import kotlin.g.b.k;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.u;

public final class GoldModuleHelper implements b {
    public static final GoldModuleHelper INSTANCE = new GoldModuleHelper();

    public final String getBuildType(Context context) {
        return "release";
    }

    private GoldModuleHelper() {
    }

    public final void loadPage(Activity activity, String str, DeepLinkData deepLinkData, Bundle bundle) {
        String str2;
        if (URLUtil.isValidUrl(str)) {
            if (str != null) {
                u a2 = u.a();
                if (deepLinkData != null) {
                    str2 = deepLinkData.f50283a;
                } else {
                    str2 = null;
                }
                a2.a("gold", "e9cb11f8ff1da1ee4eaa7b2d4c33f89a983175ca", str, bundle, str2, (Context) activity);
            }
        } else if (activity != null) {
            activity.finish();
        }
    }

    public final void loadGoldControllerActivity(Activity activity, DeepLinkData deepLinkData) {
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            GoldDataProvider goldDataProvider = GoldDataProvider.INSTANCE;
            Application application = activity.getApplication();
            k.a((Object) application, "it.application");
            goldDataProvider.initGoldModule(application);
            a aVar = a.f13415b;
            a.a(activity, intent);
            activity.finish();
        }
    }
}
