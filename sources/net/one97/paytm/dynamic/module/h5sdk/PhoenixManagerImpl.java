package net.one97.paytm.dynamic.module.h5sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import com.google.firebase.perf.metrics.Trace;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.phoenix.PhoenixManager;
import net.one97.paytm.phoenix.api.d;
import net.one97.paytm.phoenix.core.a;
import net.one97.paytm.phoenix.d.c;
import net.one97.paytm.phoenix.d.e;
import net.one97.paytm.phoenix.d.g;
import net.one97.paytm.phoenix.d.h;
import net.one97.paytm.phoenix.d.i;
import net.one97.paytm.phoenix.d.j;
import net.one97.paytm.phoenix.d.l;
import net.one97.paytm.phoenix.d.m;
import net.one97.paytm.phoenix.d.n;
import net.one97.paytm.phoenix.d.o;
import net.one97.paytm.phoenix.d.p;
import net.one97.paytm.phoenix.d.q;
import net.one97.paytm.phoenix.d.y;
import net.one97.paytm.phoenix.provider.BuildTypeProvider;
import net.one97.paytm.phoenix.provider.DeveloperModeWhiteListDataProvider;
import net.one97.paytm.phoenix.provider.H5ActivityResultProvider;
import net.one97.paytm.phoenix.provider.H5AuthDataProvider;
import net.one97.paytm.phoenix.provider.H5ExitSessionProvider;
import net.one97.paytm.phoenix.provider.H5InternalDeepLinkProviderImpl;
import net.one97.paytm.phoenix.provider.H5LocationProvider;
import net.one97.paytm.phoenix.provider.H5MiniAppShortcutProviderImpl;
import net.one97.paytm.phoenix.provider.H5NavigationClassProvider;
import net.one97.paytm.phoenix.provider.LoadingViewProvider;
import net.one97.paytm.phoenix.provider.PaytmAppInfoProvider;
import net.one97.paytm.phoenix.provider.PaytmH5AnalyticsProviderImpl;
import net.one97.paytm.phoenix.provider.PaytmH5AppAnalyticsProviderImpl;
import net.one97.paytm.phoenix.provider.PaytmH5BridgeInterceptProviderImpl;
import net.one97.paytm.phoenix.provider.PaytmH5ShowSessionPopUpDialogProvider;
import net.one97.paytm.phoenix.provider.PaytmLanguageSelectedProvider;
import net.one97.paytm.phoenix.provider.PaytmPhoenixPaymentProviderImpl;
import net.one97.paytm.phoenix.provider.PhoenixAppPermissionProviderImpl;
import net.one97.paytm.phoenix.provider.PhoenixAppsFlyerSendEventProviderImpl;
import net.one97.paytm.phoenix.provider.PhoenixGenerateShortLinkProviderImpl;
import net.one97.paytm.phoenix.provider.PhoenixHTTPRequestProvider;
import net.one97.paytm.phoenix.provider.PhoenixWhiteListAppDataProviderImpl;
import net.one97.paytm.phoenix.provider.SplashLoadingViewProvider;
import net.one97.paytm.phoenix.provider.TitleBarImageProviderImpl;
import net.one97.paytm.upi.util.UpiConstants;

public final class PhoenixManagerImpl {
    public static final PhoenixManagerImpl INSTANCE = new PhoenixManagerImpl();
    private static final HashSet<String> appListingData = new HashSet<>();
    private static Bundle defaultBundle;
    private static String gaClientId = "";
    private static boolean isPhoenixInit;
    private static Trace phoenixBridgeInitTrace;

    public final void addAppListingData(String str) {
        k.c(str, "appId");
    }

    public final void loadPage(String str, String str2, Bundle bundle, String str3, boolean z) {
        loadPage$default(this, str, str2, bundle, str3, z, (List) null, (List) null, 96, (Object) null);
    }

    public final void loadPage(String str, String str2, Bundle bundle, String str3, boolean z, List<? extends d> list) {
        loadPage$default(this, str, str2, bundle, str3, z, list, (List) null, 64, (Object) null);
    }

    private PhoenixManagerImpl() {
    }

    public final void init(Application application, String str) {
        Application application2 = application;
        k.c(application2, "application");
        k.c(str, "appPublicKey");
        if (!isPhoenixInit) {
            startPhoenixBridgeInitTrace();
            defaultBundle = getDefaultBundleData(application2);
            PhoenixManager.INSTANCE.init(application2, kotlin.a.k.b((T[]) new a[]{new y(), new net.one97.paytm.phoenix.d.d(), new o(), new g(), new p(), new c(), new l(), new e(), new i(), new m(), new net.one97.paytm.phoenix.d.k(), new h(), new j(), new n(), new q(), new net.one97.paytm.h5.a.a()}), kotlin.a.k.b((T[]) new Object[]{new PhoenixWhiteListAppDataProviderImpl(), new H5ActivityResultProvider(), new PaytmPhoenixPaymentProviderImpl(), new PhoenixAppPermissionProviderImpl(), new TitleBarImageProviderImpl(), new H5InternalDeepLinkProviderImpl(), new LoadingViewProvider(), new H5LocationProvider(), new SplashLoadingViewProvider(), new H5AuthDataProvider(), new H5MiniAppShortcutProviderImpl(), new PaytmH5AnalyticsProviderImpl(), new PaytmH5BridgeInterceptProviderImpl(), new PaytmLanguageSelectedProvider(), new PaytmAppInfoProvider(), new PhoenixHTTPRequestProvider(), new H5NavigationClassProvider(), new H5ExitSessionProvider(), new PaytmH5AppAnalyticsProviderImpl(), new PaytmH5ShowSessionPopUpDialogProvider(), new PhoenixGenerateShortLinkProviderImpl(), new DeveloperModeWhiteListDataProvider(), new BuildTypeProvider(), new PhoenixAppsFlyerSendEventProviderImpl()}), false);
            isPhoenixInit = true;
            Trace trace = phoenixBridgeInitTrace;
            if (trace == null) {
                k.a("phoenixBridgeInitTrace");
            }
            trace.stop();
            return;
        }
    }

    public static /* synthetic */ void loadPage$default(PhoenixManagerImpl phoenixManagerImpl, String str, String str2, Bundle bundle, String str3, boolean z, List list, List list2, int i2, Object obj) {
        phoenixManagerImpl.loadPage(str, str2, bundle, str3, z, (i2 & 32) != 0 ? null : list, (i2 & 64) != 0 ? null : list2);
    }

    public final void loadPage(String str, String str2, Bundle bundle, String str3, boolean z, List<? extends d> list, List<? extends Serializable> list2) {
        String str4 = str2;
        Bundle bundle2 = bundle;
        k.c(str, "appUniqueId");
        k.c(str2, "urlOrAssetPath");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str4)) {
            Bundle bundle3 = new Bundle();
            Bundle bundle4 = defaultBundle;
            if (bundle4 != null) {
                bundle3.putAll(bundle4);
            }
            if (bundle2 != null) {
                bundle3.putAll(bundle);
            }
            PhoenixManager.loadPage$default(str, str2, (PhoenixManager.a) null, bundle3, str3, z, list, list2, (Activity) null, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS, (Object) null);
        }
    }

    public final Bundle getDefaultBundleData(Context context) {
        k.c(context, "context");
        Bundle a2 = u.a(context);
        k.a((Object) a2, "JarvisH5Manager.getDefaultBundleData(context)");
        return a2;
    }

    public final void handleDeeplink(Context context, String str) {
        k.c(context, "context");
        k.c(str, "deeplink");
        H5InternalDeeplinkHandler.handleDeeplink(context, str);
    }

    public final void clearCache(Activity activity) {
        if (activity != null) {
            PhoenixManager.INSTANCE.clearCache(activity);
            INSTANCE.clearCookies(activity);
            net.one97.paytm.h5.b.c cVar = net.one97.paytm.h5.b.c.f16920a;
            net.one97.paytm.h5.b.c.a();
        }
    }

    private final void clearCookies(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 22) {
                CookieManager.getInstance().removeAllCookies((ValueCallback) null);
                CookieManager.getInstance().flush();
                return;
            }
            CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
            createInstance.startSync();
            CookieManager instance = CookieManager.getInstance();
            instance.removeAllCookie();
            instance.removeSessionCookie();
            createInstance.stopSync();
            createInstance.sync();
        } catch (Exception e2) {
            com.paytm.utility.q.b(e2.getMessage());
        }
    }

    private final void startPhoenixBridgeInitTrace() {
        com.google.firebase.perf.a.a();
        Trace b2 = com.google.firebase.perf.a.b("phoenix_bridge_init_trace");
        k.a((Object) b2, "FirebasePerformance.getI…oenix_bridge_init_trace\")");
        phoenixBridgeInitTrace = b2;
        if (b2 == null) {
            k.a("phoenixBridgeInitTrace");
        }
        b2.start();
    }
}
