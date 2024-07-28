package com.paytmmall.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.utility.q;
import com.paytmmall.a.a.b;
import com.paytmmall.a.a.c;
import com.paytmmall.a.a.d;
import com.paytmmall.a.a.e;
import com.paytmmall.a.a.f;
import com.paytmmall.a.a.g;
import com.paytmmall.a.a.h;
import com.paytmmall.a.a.i;
import com.paytmmall.a.a.j;
import com.paytmmall.a.a.k;
import com.paytmmall.a.a.l;
import com.paytmmall.artifact.d.aa;
import com.paytmmall.artifact.d.s;
import com.paytmmall.artifact.d.t;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Set;
import net.one97.paytm.phoenix.PhoenixManager;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f15362a = "H5SDKLaucher";

    /* renamed from: b  reason: collision with root package name */
    private static String f15363b = "https://paytmstores.com.com/";

    public static void a(String str) {
        f15363b = str;
    }

    public static void b(String str) {
        try {
            String e2 = e(str);
            Bundle h2 = h();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new b());
            arrayList.add(new c());
            arrayList.add(new com.paytmmall.a.a.a());
            arrayList.add(new b());
            arrayList.add(new e());
            arrayList.add(new d());
            arrayList.add(new f());
            arrayList.add(new l());
            arrayList.add(new g());
            arrayList.add(new k());
            arrayList.add(new j());
            arrayList.add(new h());
            arrayList.add(new i());
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(t.e().getFetchValueKeysProvider());
            PhoenixManager.loadPage("7688e1fef591b4e2ffbd679ab096e798a35bef82", e2, (PhoenixManager.a) null, h2, "deeplink data", false, arrayList, arrayList2, (Activity) null);
        } catch (Exception e3) {
            s.a(e3);
        }
    }

    private static String e(String str) {
        float f2;
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("notchHeight", "0");
            buildUpon.appendQueryParameter("framework", "h5App");
            buildUpon.appendQueryParameter("isH5InitialPage", "1");
            int i2 = com.paytmmall.artifact.d.c.n(t.b()).y;
            if (i2 == 0) {
                f2 = 0.0f;
            } else {
                f2 = ((float) i2) / Resources.getSystem().getDisplayMetrics().density;
            }
            buildUpon.appendQueryParameter("navBarHeight", String.valueOf(f2));
            if (t.c().g()) {
                buildUpon.appendQueryParameter("debug", "true");
            }
            return buildUpon.build().toString();
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return str;
        }
    }

    private static Bundle h() {
        PackageManager packageManager = t.b().getPackageManager();
        Bundle bundle = new Bundle();
        try {
            bundle.putString("pullRefresh", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString("canPullDown", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString("deviceName", com.paytm.utility.b.b());
            bundle.putString("osVersion", String.valueOf(com.paytm.utility.b.d()));
            bundle.putString("applicationName", "PaytmMall");
            bundle.putString("applicationId", "com.paytmmall.artifact");
            bundle.putBoolean("paytmShowTitleBar", false);
            bundle.putString(H5Param.LONG_BACK_BEHAVIOR, H5Param.DEFAULT_LONG_BACK_BEHAVIOR);
            bundle.putBoolean("isWhatsAppPresent", aa.a(AppConstants.WHATS_APP, packageManager));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bundle;
    }

    public static String c(String str) {
        if (str.contains("https://middleware.paytmmall.com/")) {
            str = str.replace("https://middleware.paytmmall.com/", e());
        } else if (str.contains("https://middleware.paytm.com/")) {
            str = str.replace("https://middleware.paytm.com/", e());
        } else if (str.contains("https://catalog.paytmmall.com/")) {
            str = str.replace("https://catalog.paytmmall.com/", e());
        } else if (str.contains("https://catalog.paytm.com/")) {
            str = str.replace("https://catalog.paytm.com/", e());
        } else if (str.contains("https://middleware-staging.paytmmall.com/")) {
            str = str.replace("https://middleware-staging.paytmmall.com/", e());
        } else if (str.contains("https://middleware-staging.paytm.com/")) {
            str = str.replace("https://middleware-staging.paytm.com/", e());
        } else if (str.contains("https://catalog-staging.paytmmall.com/")) {
            str = str.replace("https://catalog-staging.paytmmall.com/", e());
        } else if (str.contains("https://catalog-staging.paytm.com/")) {
            str = str.replace("https://catalog-staging.paytm.com/", e());
        }
        if (str.contains("/v1/")) {
            return str.replace("/v1/", "/shop/");
        }
        if (str.contains("/v2/")) {
            return str.replace("/v2/", "/shop/");
        }
        return str.contains("/search") ? str.replace("/search", "/shop/search") : str;
    }

    public static boolean a() {
        return d((String) null);
    }

    public static boolean d(String str) {
        String str2 = e() + "cart";
        if (!TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str);
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                Uri parse2 = Uri.parse(str2);
                Uri.Builder encodedAuthority = new Uri.Builder().scheme(parse2.getScheme()).encodedAuthority(parse2.getAuthority());
                encodedAuthority.appendEncodedPath("cart");
                for (String next : queryParameterNames) {
                    encodedAuthority.appendQueryParameter(next, parse.getQueryParameter(next));
                }
                str2 = String.valueOf(encodedAuthority.build().normalizeScheme());
            } catch (Exception e2) {
                s.a(e2);
            }
        }
        return b(str2, "cart");
    }

    public static String b() {
        return e() + "flyout";
    }

    public static boolean a(String str, String str2) {
        Uri parse = Uri.parse(e());
        return b(String.valueOf(new Uri.Builder().scheme(parse.getScheme()).encodedAuthority(parse.getAuthority()).appendPath("myorders").appendPath(str).appendQueryParameter("selectedItemId", str2).build().normalizeScheme()), "order_details");
    }

    public static boolean c() {
        return b(com.paytmmall.artifact.common.b.a.a.a(), "order_list");
    }

    public static boolean d() {
        return b(e() + "mystore", "mystore");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.lang.String r4, java.lang.String r5) {
        /*
            boolean r0 = f()
            r1 = 0
            if (r0 == 0) goto L_0x0097
            r0 = -1
            int r2 = r5.hashCode()
            r3 = 1
            switch(r2) {
                case -1271338501: goto L_0x007a;
                case -640848945: goto L_0x0070;
                case -404972101: goto L_0x0065;
                case -309474065: goto L_0x005b;
                case 3046176: goto L_0x0051;
                case 3181382: goto L_0x0047;
                case 120898265: goto L_0x003c;
                case 756171503: goto L_0x0032;
                case 1377628753: goto L_0x0028;
                case 1527551669: goto L_0x001e;
                case 1536904518: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0084
        L_0x0012:
            java.lang.String r2 = "checkout"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0084
            r5 = 10
            goto L_0x0085
        L_0x001e:
            java.lang.String r2 = "mystore"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0084
            r5 = 7
            goto L_0x0085
        L_0x0028:
            java.lang.String r2 = "order_details"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0084
            r5 = 3
            goto L_0x0085
        L_0x0032:
            java.lang.String r2 = "order_list"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0084
            r5 = 5
            goto L_0x0085
        L_0x003c:
            java.lang.String r2 = "paytmbang"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0084
            r5 = 9
            goto L_0x0085
        L_0x0047:
            java.lang.String r2 = "grid"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0084
            r5 = 0
            goto L_0x0085
        L_0x0051:
            java.lang.String r2 = "cart"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0084
            r5 = 2
            goto L_0x0085
        L_0x005b:
            java.lang.String r2 = "product"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0084
            r5 = 1
            goto L_0x0085
        L_0x0065:
            java.lang.String r2 = "mpordersummary"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0084
            r5 = 8
            goto L_0x0085
        L_0x0070:
            java.lang.String r2 = "itemdetails"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0084
            r5 = 4
            goto L_0x0085
        L_0x007a:
            java.lang.String r2 = "flyout"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x0084
            r5 = 6
            goto L_0x0085
        L_0x0084:
            r5 = -1
        L_0x0085:
            switch(r5) {
                case 0: goto L_0x0089;
                case 1: goto L_0x0089;
                case 2: goto L_0x0089;
                case 3: goto L_0x0089;
                case 4: goto L_0x0089;
                case 5: goto L_0x0089;
                case 6: goto L_0x0089;
                case 7: goto L_0x0089;
                case 8: goto L_0x0089;
                case 9: goto L_0x0089;
                case 10: goto L_0x0089;
                default: goto L_0x0088;
            }
        L_0x0088:
            goto L_0x0097
        L_0x0089:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0096
            java.lang.String r4 = c(r4)
            b(r4)
        L_0x0096:
            return r3
        L_0x0097:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.a.a.b(java.lang.String, java.lang.String):boolean");
    }

    public static boolean a(String str, boolean z) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z) {
            str2 = f15363b + "/" + str;
        } else {
            str2 = e() + "shop/summary/" + str;
        }
        b(str2, "mpordersummary");
        return true;
    }

    public static String e() {
        com.paytmmall.artifact.common.a.a.a();
        if (com.paytmmall.artifact.common.a.a.b()) {
            return com.paytmmall.artifact.d.j.b("https://staging.paytmmall.com/");
        }
        return com.paytmmall.artifact.d.j.b("https://paytmmall.com/");
    }

    public static boolean f() {
        com.paytmmall.artifact.common.a.a.a();
        return com.paytmmall.artifact.common.a.a.a("isH5PageSupported", true);
    }

    public static String g() {
        boolean z = com.paytmmall.artifact.d.c.f15691a;
        String str = e() + "settings?isWebView=true";
        if (!z) {
            return str;
        }
        return str + "&isDebug=" + z;
    }
}
