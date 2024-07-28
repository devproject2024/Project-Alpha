package net.one97.paytm.h5paytmsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.Toast;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.iap.android.webapp.sdk.kit.AppContainerKit;
import com.alipay.iap.android.webapp.sdk.utils.KitUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5ActivityProvider;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.h5paytmsdk.a.c;
import net.one97.paytm.h5paytmsdk.a.d;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.h5paytmsdk.c.ae;
import net.one97.paytm.h5paytmsdk.c.n;
import net.one97.paytm.h5paytmsdk.d.e;
import net.one97.paytm.h5paytmsdk.d.f;

public final class PaytmH5Manager {
    public static final String DELIMITER = "--";
    public static final PaytmH5Manager INSTANCE = new PaytmH5Manager();
    public static final String TAG = "PaytmH5Sdk";
    private static Application application;
    private static boolean isDebug;
    private static boolean isFromDeepLinkStatus;
    private static boolean isInit;

    public interface a {
    }

    private PaytmH5Manager() {
    }

    public final boolean isDebug$h5paytmsdk_debug() {
        return isDebug;
    }

    public final void setDebug$h5paytmsdk_debug(boolean z) {
        isDebug = z;
    }

    public final boolean isFromDeepLinkStatus$h5paytmsdk_debug() {
        return isFromDeepLinkStatus;
    }

    public final void setFromDeepLinkStatus$h5paytmsdk_debug(boolean z) {
        isFromDeepLinkStatus = z;
    }

    public static /* synthetic */ void init$default(Application application2, String str, List list, List list2, boolean z, net.one97.paytm.h5paytmsdk.c.b bVar, int i2, Object obj) {
        init(application2, str, (i2 & 4) != 0 ? null : list, (i2 & 8) != 0 ? null : list2, (i2 & 16) != 0 ? false : z, bVar);
    }

    public static final void init(Application application2, String str, List<? extends ad> list, List<? extends Object> list2, boolean z, net.one97.paytm.h5paytmsdk.c.b bVar) {
        k.c(application2, "application");
        k.c(str, "appPublicKey");
        k.c(bVar, "appDataProvider");
        if (!isInit) {
            isDebug = z;
            application = application2;
            net.one97.paytm.h5paytmsdk.a.b.a().a(application2, str, bVar, z);
            if (f.a(application2)) {
                d.b();
                d.b(list2);
                d.a();
                d.a(list);
            }
            isInit = true;
        }
    }

    public static final Application getContext() {
        Application application2 = application;
        if (application2 == null) {
            k.a("application");
        }
        return application2;
    }

    public static /* synthetic */ boolean loadPage$default(String str, String str2, Bundle bundle, String str3, boolean z, List list, List list2, int i2, Object obj) {
        List list3 = null;
        Bundle bundle2 = (i2 & 4) != 0 ? null : bundle;
        String str4 = (i2 & 8) != 0 ? null : str3;
        boolean z2 = (i2 & 16) != 0 ? false : z;
        List list4 = (i2 & 32) != 0 ? null : list;
        if ((i2 & 64) == 0) {
            list3 = list2;
        }
        return loadPage(str, str2, bundle2, str4, z2, list4, list3);
    }

    public static final boolean loadPage(String str, String str2, Bundle bundle, String str3, boolean z, List<? extends ad> list, List<? extends Object> list2) {
        k.c(str, "appUniqueId");
        k.c(str2, "urlOrAssetPath");
        loadPage(str, str2, (a) null, bundle, str3, z, list, list2);
        return true;
    }

    public static /* synthetic */ void loadPage$default(String str, String str2, a aVar, Bundle bundle, String str3, boolean z, List list, List list2, int i2, Object obj) {
        int i3 = i2;
        loadPage(str, str2, aVar, (i3 & 8) != 0 ? null : bundle, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? false : z, (i3 & 64) != 0 ? null : list, (i3 & 128) != 0 ? null : list2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: net.one97.paytm.h5paytmsdk.c.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: net.one97.paytm.h5paytmsdk.c.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: net.one97.paytm.h5paytmsdk.c.l} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void loadPage(java.lang.String r13, java.lang.String r14, net.one97.paytm.h5paytmsdk.PaytmH5Manager.a r15, android.os.Bundle r16, java.lang.String r17, boolean r18, java.util.List<? extends net.one97.paytm.h5paytmsdk.b.ad> r19, java.util.List<? extends java.lang.Object> r20) {
        /*
            r9 = r13
            java.lang.String r0 = "appUniqueId"
            kotlin.g.b.k.c(r13, r0)
            java.lang.String r0 = "urlOrAssetPath"
            r2 = r14
            kotlin.g.b.k.c(r14, r0)
            com.alipay.mobile.nebula.provider.H5ProviderManager r0 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()
            if (r0 == 0) goto L_0x001e
            java.lang.Class<net.one97.paytm.h5paytmsdk.c.l> r1 = net.one97.paytm.h5paytmsdk.c.l.class
            java.lang.String r1 = r1.getName()
            java.lang.Object r0 = r0.getProvider(r1)
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            r10 = r0
            net.one97.paytm.h5paytmsdk.c.l r10 = (net.one97.paytm.h5paytmsdk.c.l) r10
            if (r10 == 0) goto L_0x0043
            android.app.Application r0 = getContext()
            r11 = r0
            android.content.Context r11 = (android.content.Context) r11
            net.one97.paytm.h5paytmsdk.PaytmH5Manager$b r12 = new net.one97.paytm.h5paytmsdk.PaytmH5Manager$b
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            net.one97.paytm.h5paytmsdk.a.c r12 = (net.one97.paytm.h5paytmsdk.a.c) r12
            r10.a(r13, r11, r12)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.PaytmH5Manager.loadPage(java.lang.String, java.lang.String, net.one97.paytm.h5paytmsdk.PaytmH5Manager$a, android.os.Bundle, java.lang.String, boolean, java.util.List, java.util.List):void");
    }

    public static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16951a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16952b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Bundle f16953c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f16954d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f16955e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ List f16956f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ List f16957g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ a f16958h;

        b(String str, String str2, Bundle bundle, String str3, boolean z, List list, List list2, a aVar) {
            this.f16951a = str;
            this.f16952b = str2;
            this.f16953c = bundle;
            this.f16954d = str3;
            this.f16955e = z;
            this.f16956f = list;
            this.f16957g = list2;
            this.f16958h = aVar;
        }

        public final /* synthetic */ void a(Boolean bool) {
            PaytmH5Manager.INSTANCE.onDoesAppExistCallback(bool.booleanValue(), this.f16951a, this.f16952b, this.f16953c, this.f16954d, this.f16955e, this.f16956f, this.f16957g, this.f16958h);
        }
    }

    public static final void loadError(String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("paytmShowTitleBar", false);
        AppContainerKit instance = AppContainerKit.getInstance();
        Application application2 = application;
        if (application2 == null) {
            k.a("application");
        }
        instance.openUrl(application2, KitUtils.getAssetUrl("h5_errors/index.html?type=".concat(String.valueOf(str))), bundle);
    }

    public final void clearCache(Activity activity) {
        Set<String> keySet;
        Map<String, String> a2;
        Collection<String> values;
        k.c(activity, "activity");
        try {
            WebView webView = new WebView(activity);
            activity.deleteDatabase("webviewCache.db");
            activity.deleteDatabase("webview.db");
            webView.clearCache(true);
            webView.clearHistory();
            webView.clearFormData();
            WebStorage.getInstance().deleteAllData();
            H5ProviderManager providerManager = Nebula.getProviderManager();
            ae aeVar = (ae) (providerManager != null ? providerManager.getProvider(ae.class.getName()) : null);
            if (!(aeVar == null || (a2 = aeVar.a()) == null || (values = a2.values()) == null)) {
                for (String deleteSharedPreferenceForFileName : values) {
                    INSTANCE.deleteSharedPreferenceForFileName(deleteSharedPreferenceForFileName);
                }
            }
            net.one97.paytm.h5paytmsdk.a.b a3 = net.one97.paytm.h5paytmsdk.a.b.a();
            k.a((Object) a3, "IAPIntegrationHelper.getInstance()");
            Map<String, SubAppConfig> b2 = a3.b();
            if (!(b2 == null || (keySet = b2.keySet()) == null)) {
                for (String str : keySet) {
                    PaytmH5Manager paytmH5Manager = INSTANCE;
                    e.a aVar = e.f17100a;
                    k.a((Object) str, "it");
                    paytmH5Manager.deleteSharedPreferenceForFileName(e.a.b(str));
                }
            }
            e.a aVar2 = e.f17100a;
            e.a aVar3 = e.f17100a;
            for (String deleteSharedPreferenceForFileName2 : e.a.a(e.f17101b).getAll().keySet()) {
                INSTANCE.deleteSharedPreferenceForFileName(deleteSharedPreferenceForFileName2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void deleteSharedPreferenceForFileName(String str) {
        if (str != null) {
            e.a aVar = e.f17100a;
            e.a.a(str).edit().clear().apply();
        }
    }

    /* access modifiers changed from: private */
    public final void onDoesAppExistCallback(boolean z, String str, String str2, Bundle bundle, String str3, boolean z2, List<? extends ad> list, List<? extends Object> list2, a aVar) {
        String str4;
        isFromDeepLinkStatus = bundle != null ? bundle.getBoolean("isFromDeeplink") : false;
        if (!z) {
            Toast.makeText(getContext(), "Your app is not registered with Paytm. Please contact Paytm administrator team.", 1).show();
        } else if (isDebug || !p.b(str2, "http://", false)) {
            H5ProviderManager providerManager = Nebula.getProviderManager();
            Object obj = null;
            n nVar = (n) (providerManager != null ? providerManager.getProvider(n.class.getName()) : null);
            if (nVar == null || nVar.a()) {
                com.alipay.iap.android.common.b.c.e();
            } else {
                com.alipay.iap.android.common.b.c.e();
                boolean z3 = !(bundle != null ? bundle.getBoolean("isFromDeeplink") : false);
                if (str2 != null) {
                    CharSequence charSequence = str2;
                    boolean b2 = p.b(p.b(charSequence).toString(), "http://", false);
                    if (str2 == null) {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    } else if (z3 && (p.b(p.b(charSequence).toString(), "https://", false) | b2)) {
                        H5ProviderManager providerManager2 = Nebula.getProviderManager();
                        if (providerManager2 != null) {
                            obj = providerManager2.getProvider(ae.class.getName());
                        }
                        ae aeVar = (ae) obj;
                        if (aeVar != null && !aeVar.c(str2)) {
                            loadError("AN");
                            return;
                        }
                    }
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            if (str2 != null) {
                CharSequence charSequence2 = str2;
                boolean b3 = p.b(p.b(charSequence2).toString(), "http://", false);
                if (str2 != null) {
                    if (p.b(p.b(charSequence2).toString(), "https://", false) || b3) {
                        str4 = str2;
                    } else {
                        str4 = KitUtils.getAssetUrl(str2);
                        k.a((Object) str4, "KitUtils.getAssetUrl(urlOrAssetPath)");
                    }
                    d.a(str, list);
                    d.b(str, list2);
                    AppContainerKit.getInstance().setProvider(H5ActivityProvider.class.getName(), new net.one97.paytm.h5paytmsdk.c.d(z2));
                    Bundle bundle2 = bundle == null ? new Bundle() : bundle;
                    bundle2.putString("deeplinkData", str3);
                    bundle2.putBoolean(H5Param.LONG_TRANSPARENT, z2);
                    bundle2.putString("appUniqueId", str);
                    "URL: ".concat(String.valueOf(str2));
                    com.alipay.iap.android.common.b.c.e();
                    "isTransparent: ".concat(String.valueOf(z2));
                    com.alipay.iap.android.common.b.c.e();
                    "DeeplinkData: ".concat(String.valueOf(str3));
                    com.alipay.iap.android.common.b.c.e();
                    new StringBuilder("Bundle: ").append(String.valueOf(bundle));
                    com.alipay.iap.android.common.b.c.e();
                    new StringBuilder("UUID: ").append(com.a.a.a.a(getContext()));
                    com.alipay.iap.android.common.b.c.e();
                    AppContainerKit instance = AppContainerKit.getInstance();
                    Application application2 = application;
                    if (application2 == null) {
                        k.a("application");
                    }
                    instance.openUrl(application2, str4, bundle2);
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        } else {
            Toast.makeText(getContext(), "'http' calls not allowed. Use 'https' only or Please contact Paytm administrator team.", 1).show();
        }
    }
}
