package net.one97.paytm.deeplink;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.google.firebase.perf.metrics.Trace;
import com.paytm.utility.q;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.one97.paytm.addmoney.c;
import net.one97.paytm.addmoney.d;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.utils.ag;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static String f50369a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCknhsytDzXe9JYs2aJ7ggIHsB3\nfL/7xFPxWdvwaKb5wN81Y2WCgmyoSsEc/dRmY/mQ4evSthuY2yZ/D660Y8qi7TPi\nF/Hy565Xra1ZWWsjbJtlFF2TwhGRHSZDWyty4w2QoRzXP+28wve00rxmWjxiA54q\n8/Ygwa12hlpaOwq1PQIDAQAB";

    /* renamed from: b  reason: collision with root package name */
    public static String f50370b = "bundle";

    /* renamed from: c  reason: collision with root package name */
    public static String f50371c = "deeplink_data";

    /* renamed from: d  reason: collision with root package name */
    public static String f50372d = H5TabbarUtils.MATCH_TYPE_PATH;

    /* renamed from: e  reason: collision with root package name */
    public static String f50373e = "appUniqueId";

    /* renamed from: f  reason: collision with root package name */
    public static String f50374f = "verticalName";

    /* renamed from: g  reason: collision with root package name */
    public static String f50375g = H5Param.LONG_TRANSPARENT;

    /* renamed from: h  reason: collision with root package name */
    public static String f50376h = "action";
    private static final u j = new u();
    private static String k = "net.one97.paytm.dynamic.module.h5sdk.H5InitActivity";

    /* renamed from: i  reason: collision with root package name */
    public a f50377i;

    public interface a {
        void clearCache(Activity activity);

        void handleDeeplink(Context context, String str);

        void loadPage(String str, String str2, String str3, Bundle bundle, String str4, boolean z, Context context);
    }

    public enum b {
        INITIALIZE,
        INITIALIZE_LOAD,
        DOWNLOAD_INITIALIZE,
        DOWNLOAD_INITIALIZE_LOAD,
        DOWNLOAD_INITIALIZE_DEEPLINK,
        CLEAR_CACHE
    }

    public static String b() {
        return "Basic bWFya2V0LWFwcDo5YTA3MTc2Mi1hNDk5LTRiZDktOTE0YS00MzYxZTdjM2Y0YmM=";
    }

    public static u a() {
        return j;
    }

    private u() {
    }

    public final void a(String str, String str2, String str3, Bundle bundle, String str4, Context context) {
        a aVar = this.f50377i;
        if (aVar != null) {
            aVar.loadPage(str, str2, str3, bundle, str4, false, context);
        } else if (c()) {
            b(context, str, str2, str3, bundle, str4);
        } else {
            a(context, str, str2, str3, bundle, str4);
        }
    }

    public final void a(Activity activity) {
        if (c()) {
            a aVar = this.f50377i;
            if (aVar != null) {
                aVar.clearCache(activity);
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(activity, k);
            intent.setFlags(268435456);
            intent.putExtra(f50376h, b.CLEAR_CACHE.name());
            activity.startActivity(intent);
        }
    }

    private void a(Context context, String str) {
        if (context != null && str != null) {
            if (this.f50377i != null && c()) {
                this.f50377i.handleDeeplink(context, str);
            } else if (c()) {
                b(context, str);
            } else {
                c(context, str);
            }
        }
    }

    public static String b(Activity activity) {
        String b2 = ag.a(activity.getApplicationContext()).b("sso_token=", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static Bundle a(Context context) {
        Bundle bundle = new Bundle();
        try {
            bundle.putString("pullRefresh", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString("canPullDown", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString("deviceName", com.paytm.utility.a.e());
            bundle.putString("appVersion", com.paytm.utility.b.Q(context));
            bundle.putString("osVersion", String.valueOf(com.paytm.utility.b.d()));
            bundle.putString("deviceId", com.paytm.utility.a.d(context));
            bundle.putString("applicationName", "Paytm");
            bundle.putString("applicationId", "net.one97.paytm");
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return bundle;
    }

    public static void a(Application application) {
        Trace a2 = com.google.firebase.perf.a.a("jarvisH5InitTrace");
        try {
            Class<?> cls = Class.forName("net.one97.paytm.dynamic.module.h5sdk.H5CommunicatorImpl");
            Method declaredMethod = cls.getDeclaredMethod("init", new Class[]{Application.class, String.class});
            if (application != null) {
                declaredMethod.invoke(cls.newInstance(), new Object[]{application, f50369a});
            }
        } catch (InstantiationException e2) {
            q.b(e2.getMessage());
        } catch (IllegalAccessException e3) {
            q.b(e3.getMessage());
        } catch (ClassNotFoundException e4) {
            q.b(e4.getMessage());
        } catch (NoSuchMethodException e5) {
            q.b(e5.getMessage());
        } catch (InvocationTargetException e6) {
            q.b(e6.getMessage());
        }
        a2.stop();
    }

    private static void a(Context context, String str, String str2, String str3, Bundle bundle, String str4) {
        if (!c()) {
            Intent intent = new Intent(context, CommonDynamicLoaderActivity.class);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, k);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
            intent.putExtra(f50370b, bundle);
            intent.putExtra(f50371c, str4);
            intent.putExtra(f50372d, str3);
            intent.putExtra(f50375g, false);
            intent.putExtra(f50373e, str2);
            intent.putExtra(f50374f, str);
            intent.addFlags(268435456);
            intent.putExtra(f50376h, b.DOWNLOAD_INITIALIZE_LOAD.name());
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    private static void b(Context context, String str, String str2, String str3, Bundle bundle, String str4) {
        if (c()) {
            Intent intent = new Intent();
            intent.setClassName(context, k);
            intent.putExtra(f50370b, bundle);
            intent.putExtra(f50371c, str4);
            intent.putExtra(f50372d, str3);
            intent.putExtra(f50375g, false);
            intent.putExtra(f50374f, str);
            intent.putExtra(f50373e, str2);
            intent.putExtra(f50376h, b.INITIALIZE_LOAD.name());
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    private static boolean c() {
        return DynamicModuleManager.getInstance().isInstalled("ddbase");
    }

    private static void b(Context context, String str) {
        if (c()) {
            Intent intent = new Intent();
            intent.setClassName(context, k);
            intent.putExtra(f50371c, str);
            intent.putExtra(f50376h, b.DOWNLOAD_INITIALIZE_DEEPLINK.name());
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    private static void c(Context context, String str) {
        if (!c()) {
            Intent intent = new Intent(context, CommonDynamicLoaderActivity.class);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, k);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
            intent.putExtra(f50371c, str);
            intent.putExtra(f50376h, b.DOWNLOAD_INITIALIZE_DEEPLINK.name());
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void a(Activity activity, double d2) {
        c.a aVar = c.f48417a;
        if (activity != null) {
            d.a aVar2 = d.f48562a;
            Intent a2 = d.a.a() != null ? d.a((Context) activity, "wallet") : null;
            if (a2 != null) {
                a2.putExtra("amount", d2);
            }
            if (a2 != null) {
                a2.putExtra("done_button_text", "Done");
            }
            if (a2 != null) {
                a2.putExtra("isSessionTimeoutCallbackRequiredH5", true);
            }
            if (a2 != null) {
                a2.putExtra("isCallbackRequired", true);
            }
            activity.startActivityForResult(a2, 9901);
        }
    }

    public static boolean a(DeepLinkData deepLinkData) {
        if (deepLinkData.f50289g != null) {
            return deepLinkData.f50289g.toString().startsWith("paytmmp://mini-app?");
        }
        return false;
    }

    public final void a(Context context, DeepLinkData deepLinkData) {
        if (deepLinkData.f50289g != null) {
            a(context, deepLinkData.f50289g.toString());
        }
    }
}
