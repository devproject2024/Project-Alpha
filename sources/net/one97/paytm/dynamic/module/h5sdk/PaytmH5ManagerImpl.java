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
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.h5.a.b;
import net.one97.paytm.h5.a.c;
import net.one97.paytm.h5.a.d;
import net.one97.paytm.h5.a.f;
import net.one97.paytm.h5.a.g;
import net.one97.paytm.h5.a.h;
import net.one97.paytm.h5.a.i;
import net.one97.paytm.h5.a.j;
import net.one97.paytm.h5.a.l;
import net.one97.paytm.h5.a.m;
import net.one97.paytm.h5.a.n;
import net.one97.paytm.h5.a.o;
import net.one97.paytm.h5.a.p;
import net.one97.paytm.h5.a.q;
import net.one97.paytm.h5.b.a;
import net.one97.paytm.h5.b.r;
import net.one97.paytm.h5.b.s;
import net.one97.paytm.h5.b.t;
import net.one97.paytm.h5.b.u;
import net.one97.paytm.h5paytmsdk.PaytmH5Manager;
import net.one97.paytm.h5paytmsdk.b.ad;
import org.json.JSONArray;

public final class PaytmH5ManagerImpl {
    public static final PaytmH5ManagerImpl INSTANCE = new PaytmH5ManagerImpl();
    private static final HashSet<String> appListingData = new HashSet<>();
    private static Bundle defaultBundle;
    private static boolean isH5Init;

    public final void loadPage(String str, String str2, Bundle bundle, String str3, boolean z) {
        loadPage$default(this, str, str2, bundle, str3, z, (List) null, (List) null, 96, (Object) null);
    }

    public final void loadPage(String str, String str2, Bundle bundle, String str3, boolean z, List<? extends ad> list) {
        loadPage$default(this, str, str2, bundle, str3, z, list, (List) null, 64, (Object) null);
    }

    private PaytmH5ManagerImpl() {
    }

    public final void init(Application application, String str) {
        k.c(application, "application");
        k.c(str, "appPublicKey");
        if (!isH5Init) {
            defaultBundle = getDefaultBundleData(application);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new c());
            arrayList.add(new n());
            arrayList.add(new i());
            arrayList.add(new b());
            arrayList.add(new l());
            arrayList.add(new j());
            arrayList.add(new m());
            arrayList.add(new o());
            arrayList.add(new d());
            arrayList.add(new q());
            arrayList.add(new net.one97.paytm.h5.a.k());
            arrayList.add(new f());
            arrayList.add(new h());
            arrayList.add(new g());
            arrayList.add(new p());
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new net.one97.paytm.h5.b.b());
            arrayList2.add(new a());
            arrayList2.add(new net.one97.paytm.h5.b.d());
            arrayList2.add(new net.one97.paytm.h5.b.j());
            arrayList2.add(new net.one97.paytm.h5.b.k());
            arrayList2.add(new net.one97.paytm.h5.b.i());
            arrayList2.add(new net.one97.paytm.h5.b.g());
            arrayList2.add(new net.one97.paytm.h5.b.f());
            arrayList2.add(new s());
            arrayList2.add(new net.one97.paytm.h5.b.q());
            arrayList2.add(new net.one97.paytm.h5.b.n());
            arrayList2.add(new net.one97.paytm.h5.b.h());
            arrayList2.add(new u());
            arrayList2.add(new net.one97.paytm.h5.b.l());
            arrayList2.add(new net.one97.paytm.h5.b.o());
            arrayList2.add(new t());
            arrayList2.add(new net.one97.paytm.h5.b.m());
            arrayList2.add(new r());
            arrayList2.add(new net.one97.paytm.h5.b.p());
            Application application2 = application;
            String str2 = str;
            PaytmH5Manager.init(application2, str2, arrayList, arrayList2, false, net.one97.paytm.h5.b.a.a.a("prod"));
            isH5Init = true;
        }
    }

    public static /* synthetic */ void loadPage$default(PaytmH5ManagerImpl paytmH5ManagerImpl, String str, String str2, Bundle bundle, String str3, boolean z, List list, List list2, int i2, Object obj) {
        paytmH5ManagerImpl.loadPage(str, str2, bundle, str3, z, (i2 & 32) != 0 ? null : list, (i2 & 64) != 0 ? null : list2);
    }

    public final void loadPage(String str, String str2, Bundle bundle, String str3, boolean z, List<? extends ad> list, List<? extends Serializable> list2) {
        k.c(str, "appUniqueId");
        k.c(str2, "urlOrAssetPath");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = defaultBundle;
            if (bundle3 != null) {
                bundle2.putAll(bundle3);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            PaytmH5Manager.loadPage(str, str2, bundle2, str3, z, list, list2);
        }
    }

    public final Bundle getDefaultBundleData(Context context) {
        k.c(context, "context");
        Bundle a2 = net.one97.paytm.deeplink.u.a(context);
        k.a((Object) a2, "JarvisH5Manager.getDefaultBundleData(context)");
        return a2;
    }

    public final void addAppListingData(String str) {
        k.c(str, "appId");
        if (!appListingData.contains(str)) {
            H5ProviderManager providerManager = Nebula.getProviderManager();
            if (((net.one97.paytm.h5paytmsdk.c.ad) (providerManager != null ? providerManager.getProvider(net.one97.paytm.h5paytmsdk.c.ad.class.getName()) : null)) != null) {
                k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
                String al = net.one97.paytm.j.c.al();
                if (al != null) {
                    try {
                        if (appListingData.size() <= 0) {
                            try {
                                Object a2 = net.one97.paytm.h5paytmsdk.c.ad.a("app_opened_thru_dl", al);
                                if (a2 instanceof String) {
                                    JSONArray jSONArray = new JSONArray((String) a2);
                                    int length = jSONArray.length();
                                    for (int i2 = 0; i2 < length; i2++) {
                                        appListingData.add(jSONArray.getString(i2));
                                    }
                                }
                            } catch (Exception e2) {
                                com.paytm.utility.q.b(e2.getMessage());
                            }
                        }
                        appListingData.add(str);
                        String b2 = new com.google.gson.f().b(appListingData);
                        k.a((Object) b2, "Gson().toJson(appListingData)");
                        net.one97.paytm.h5paytmsdk.c.ad.a("app_opened_thru_dl", b2, al);
                    } catch (Exception e3) {
                        com.paytm.utility.q.b(e3.getMessage());
                    }
                }
            }
        }
    }

    public final void handleDeeplink(Context context, String str) {
        k.c(context, "context");
        k.c(str, "deeplink");
        H5InternalDeeplinkHandler.handleDeeplink(context, str);
    }

    public final void clearCache(Activity activity) {
        if (activity != null) {
            activity.runOnUiThread(new PaytmH5ManagerImpl$clearCache$1$1(activity));
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
}
