package net.one97.paytm.wifi.background.wifi.b;

import android.app.Application;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.wifi.background.wifi.filters.d;
import net.one97.paytm.wifi.models.WifiAccessPoint;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0412a f21100a = new C0412a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final Application f21101b;

    /* renamed from: c  reason: collision with root package name */
    private final d f21102c;

    /* renamed from: d  reason: collision with root package name */
    private final WifiManager f21103d;

    public static void a(List<? extends ScanResult> list, List<WifiAccessPoint> list2) {
        k.c(list, "scanResults");
        k.c(list2, "accessPoints");
    }

    public a(Application application, d dVar, WifiManager wifiManager) {
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(dVar, "scanResultsFilter");
        k.c(wifiManager, "wifiManager");
        this.f21101b = application;
        this.f21102c = dVar;
        this.f21103d = wifiManager;
    }

    /* renamed from: net.one97.paytm.wifi.background.wifi.b.a$a  reason: collision with other inner class name */
    public static final class C0412a {
        private C0412a() {
        }

        public /* synthetic */ C0412a(byte b2) {
            this();
        }
    }
}
