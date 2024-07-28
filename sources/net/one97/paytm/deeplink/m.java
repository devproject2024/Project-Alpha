package net.one97.paytm.deeplink;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.fragment.app.j;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.utility.q;
import java.util.Observable;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.landingpage.c.f;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static a f50356a;

    /* renamed from: b  reason: collision with root package name */
    public static b f50357b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final m f50358c = new m();

    /* renamed from: d  reason: collision with root package name */
    private static f f50359d;

    public interface a {
        void initInbox(Application application);

        void logOutSheroes();

        void onTabSwitched(Context context, int i2);

        void onTabSwitched(Context context, boolean z, j jVar);

        void onUserLoggedIn(Context context);

        void onUserLoggedOut();

        void onUserProfileUpdate(Context context);

        void openDeepLinkActivity(Context context, String str);

        void sendGaEvent(Context context, String str);
    }

    private m() {
    }

    public static final class b extends Observable {
        public final void a(String str) {
            k.c(str, "status");
            setChanged();
            notifyObservers(str);
        }
    }

    public static void a(Context context, int i2) {
        k.c(context, "context");
        if (DynamicModuleManager.getInstance().isInstalled("feed")) {
            a aVar = f50356a;
            if (aVar != null) {
                aVar.onTabSwitched(context, i2);
            }
            new StringBuilder("Listener onTabSwitched:: ").append(f50356a);
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final c f50360a = new c();

        c() {
        }

        public final void run() {
            m.f50357b.a("inbox/feed");
        }
    }

    private static void d() {
        new Handler().postDelayed(c.f50360a, 1000);
    }

    public static boolean a(String str) {
        return k.a((Object) str, (Object) "feed") || k.a((Object) str, (Object) "paytmmp://feed") || k.a((Object) str, (Object) "inbox/feedpost") || k.a((Object) str, (Object) "paytmmp://inbox/feedpost") || k.a((Object) str, (Object) "paytmmp://inbox/feed") || k.a((Object) str, (Object) "inbox/feed") || k.a((Object) str, (Object) "inbox") || k.a((Object) str, (Object) "sheroes");
    }

    public static void a(Context context, boolean z, j jVar) {
        a aVar;
        k.c(context, "context");
        k.c(jVar, "childFragmentManager");
        if (DynamicModuleManager.getInstance().isInstalled("feed") && (aVar = f50356a) != null) {
            aVar.onTabSwitched(context, z, jVar);
        }
    }

    public static void b(Context context, DeepLinkData deepLinkData) {
        String str;
        String str2;
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (DynamicModuleManager.getInstance().isInstalled("feed") && (str = deepLinkData.f50284b) != null) {
            if (k.a((Object) "sheroes", (Object) str)) {
                b(context);
                Intent a2 = a("deepLink", "net.one97.paytm.dynamic.module.feed.FeedInitActivity");
                a2.putExtra("urlType", deepLinkData.f50284b);
                a2.putExtra("deepLink", deepLinkData.f50283a);
                context.startActivity(a2);
            } else if (p.a(str, "inbox", true)) {
                d();
            } else if (a(str) && (str2 = deepLinkData.f50283a) != null) {
                d();
                k.c(context, "context");
                k.c(str2, "deeplink");
                if (DynamicModuleManager.getInstance().isInstalled("feed")) {
                    a aVar = f50356a;
                    if (aVar == null) {
                        Intent a3 = a("deepLink", "net.one97.paytm.dynamic.module.feed.FeedInitActivity");
                        a3.putExtra("deepLink", str2);
                        context.startActivity(a3);
                    } else if (aVar != null) {
                        aVar.openDeepLinkActivity(context, str2);
                    }
                }
            }
        }
    }

    public static void a(Context context) {
        k.c(context, "context");
        if (DynamicModuleManager.getInstance().isInstalled("feed")) {
            b(context);
            a aVar = f50356a;
            if (aVar != null) {
                aVar.onUserLoggedOut();
            }
        }
    }

    public static void c(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (DynamicModuleManager.getInstance().isInstalled("feed")) {
            context.startActivity(a("deepLink", "net.one97.paytm.dynamic.module.feed.FeedActivity"));
            return;
        }
        Intent intent = new Intent(context, CommonDynamicLoaderActivity.class);
        intent.setAction("deepLink");
        intent.putExtra("urlType", deepLinkData.f50284b);
        intent.putExtra("deepLink", deepLinkData.f50283a);
        intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.feed.FeedActivity");
        intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "feed");
        context.startActivity(intent);
    }

    private static Intent a(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW").setAction(str).setClassName("net.one97.paytm", str2).setPackage("net.one97.paytm");
        k.a((Object) intent, "Intent(Intent.ACTION_VIE….setPackage(PACKAGE_NAME)");
        return intent;
    }

    public static final void a() {
        a aVar;
        if (DynamicModuleManager.getInstance().isInstalled("feed") && (aVar = f50356a) != null) {
            aVar.logOutSheroes();
        }
    }

    public static void a(a aVar) {
        k.c(aVar, "listener");
        f50356a = aVar;
    }

    public static void b() {
        f fVar = f50359d;
        if (fVar != null) {
            fVar.expandAppBar();
        }
    }

    public static void a(f fVar) {
        k.c(fVar, "listener");
        f50359d = fVar;
    }

    public static void c() {
        f50359d = null;
    }

    public static void a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "eventName");
        a aVar = f50356a;
        if (aVar != null) {
            aVar.sendGaEvent(context, str);
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        k.c(context, "context");
        k.c(str, "urlToLoad");
        k.c(str2, "matchId");
        k.c(str3, "postId");
        Bundle b2 = b(context, "");
        b2.putString("matchId", str2);
        b2.putString("postId", str3);
        u.a().a("feed", "5e8085fed79c6d239d311a460e01cf4197ecf157", str, b2, "", context);
    }

    public static void a(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "urlToLoad");
        k.c(str2, H5Param.SESSION_ID);
        h.a aVar = h.f50349a;
        h.a.a(context, str, (Bundle) null);
    }

    private static Bundle b(Context context, String str) {
        k.c(context, "context");
        k.c(str, H5Param.SESSION_ID);
        Bundle bundle = new Bundle();
        bundle.putString("pullRefresh", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        bundle.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
        bundle.putString("canPullDown", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(H5Param.SESSION_ID, str);
        }
        try {
            bundle.putString("customerId", com.paytm.utility.a.a(context));
            bundle.putString("deviceName", com.paytm.utility.a.e());
            bundle.putString("appVersion", com.paytm.utility.b.Q(context));
            bundle.putString("osVersion", String.valueOf(com.paytm.utility.b.d()));
            bundle.putString("deviceId", com.paytm.utility.a.d(context));
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return bundle;
    }

    public static void b(Context context) {
        a aVar;
        if (DynamicModuleManager.getInstance().isInstalled("feed")) {
            try {
                Class.forName("net.one97.paytm.dynamic.module.feed.FeedModuleManager").newInstance();
                Context applicationContext = context != null ? context.getApplicationContext() : null;
                if (!(applicationContext instanceof Application)) {
                    applicationContext = null;
                }
                Application application = (Application) applicationContext;
                if (application != null && (aVar = f50356a) != null) {
                    aVar.initInbox(application);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (!a(deepLinkData.f50284b)) {
            return false;
        }
        if (DynamicModuleManager.getInstance().isInstalled("feed")) {
            String str = deepLinkData.f50284b;
            if (str != null) {
                if (p.a(str, "inbox", true)) {
                    d();
                    return true;
                } else if (a(str)) {
                    return true;
                }
            }
        } else if (p.a(deepLinkData.f50284b, "inbox", true) || p.a(deepLinkData.f50284b, "inbox/feed", true) || p.a(deepLinkData.f50284b, "paytmmp://inbox/feed", true)) {
            f50357b.a("inbox/feed");
        } else {
            Intent intent = new Intent(context, CommonDynamicLoaderActivity.class);
            intent.setAction("deepLink");
            intent.putExtra("urlType", deepLinkData.f50284b);
            intent.putExtra("deepLink", deepLinkData.f50283a);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.feed.FeedInitActivity");
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "feed");
            context.startActivity(intent);
        }
        return true;
    }
}
