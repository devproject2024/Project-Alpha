package net.one97.paytm.wifi.background.wifi.a;

import android.app.Application;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import kotlin.g.b.k;
import net.one97.paytm.wifi.models.WifiAccessPoint;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f21090a = new c();

    private c() {
    }

    public static a a(Application application, WifiAccessPoint wifiAccessPoint) {
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(wifiAccessPoint, "accessPoint");
        return new b(wifiAccessPoint, application);
    }
}
