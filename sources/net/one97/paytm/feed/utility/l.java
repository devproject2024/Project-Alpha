package net.one97.paytm.feed.utility;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.sendbird.android.constant.StringSet;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import net.one97.paytm.feed.e.b;
import net.one97.paytm.feed.e.c;
import net.one97.paytm.feed.ui.feed.FeedFragment;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f35406a = new l();

    private l() {
    }

    public static String a(Context context, String str, String str2, Map<String, ? extends Object> map) {
        k.c(context, "context");
        k.c(str, "baseUrl");
        k.c(str2, "endpoint");
        Uri.Builder path = Uri.parse(str).buildUpon().path(str2);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                path.appendQueryParameter((String) next.getKey(), String.valueOf(next.getValue()));
            }
        }
        Uri.Builder appendQueryParameter = path.appendQueryParameter("client", "android");
        j jVar = j.f35397a;
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("version", j.a(context)).appendQueryParameter("osVersion", Build.VERSION.RELEASE);
        j jVar2 = j.f35397a;
        Uri.Builder appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("deviceName", j.a());
        j jVar3 = j.f35397a;
        Uri.Builder appendQueryParameter4 = appendQueryParameter3.appendQueryParameter("networkType", j.b(context));
        b bVar = b.f34268c;
        try {
            String url = new URL(appendQueryParameter4.appendQueryParameter("appLanguage", b.q()).appendQueryParameter("languages", "EN").build().toString()).toString();
            k.a((Object) url, "url.toString()");
            return url;
        } catch (MalformedURLException unused) {
            return "";
        }
    }

    public static String b(Context context, String str, String str2, Map<String, ? extends Object> map) {
        k.c(context, "context");
        k.c(str, "baseUrl");
        k.c(str2, "endpoint");
        Uri.Builder path = Uri.parse(str).buildUpon().path(str2);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                path.appendQueryParameter((String) next.getKey(), String.valueOf(next.getValue()));
            }
        }
        Uri.Builder appendQueryParameter = path.appendQueryParameter("client", StringSet.Android);
        j jVar = j.f35397a;
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("version", j.a(context)).appendQueryParameter("osVersion", Build.VERSION.RELEASE);
        j jVar2 = j.f35397a;
        Uri.Builder appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("deviceName", j.a());
        j jVar3 = j.f35397a;
        Uri.Builder appendQueryParameter4 = appendQueryParameter3.appendQueryParameter("networkType", j.b(context));
        b bVar = b.f34268c;
        try {
            String url = new URL(appendQueryParameter4.appendQueryParameter("appLanguage", b.q()).appendQueryParameter(H5Param.APP_TYPE, "PaytmDefault").build().toString()).toString();
            k.a((Object) url, "url.toString()");
            return url;
        } catch (MalformedURLException unused) {
            return "";
        }
    }

    public static String a(Context context, String str, String str2, String str3, String str4) {
        Context context2 = context;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        k.c(context2, "context");
        k.c(str5, "baseUrl");
        k.c(str6, "category");
        k.c(str7, "requestType");
        k.c(str8, "requestCode");
        c cVar = c.f34275a;
        if (TextUtils.isEmpty(c.h())) {
            c cVar2 = c.f34275a;
            c.b("EN,HI");
        }
        if ("REFRESH".equals(str7)) {
            net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
            net.one97.paytm.feed.b.e();
            net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
            net.one97.paytm.feed.b.n();
        }
        FeedFragment.a aVar = FeedFragment.f34877i;
        if (!p.a(str6, FeedFragment.C, true)) {
            FeedFragment.a aVar2 = FeedFragment.f34877i;
            if (p.a(str6, FeedFragment.B, true)) {
                c cVar3 = c.f34275a;
                net.one97.paytm.feed.b bVar3 = net.one97.paytm.feed.b.f33792d;
                net.one97.paytm.feed.b bVar4 = net.one97.paytm.feed.b.f33792d;
                return b(context2, str5, "/content-feed/v2/userProfile/bookmark", ae.a((o<? extends K, ? extends V>[]) new o[]{new o(H5Param.SESSION_ID, c.g()), new o("maxId", net.one97.paytm.feed.b.v()), new o(StringSet.filter, net.one97.paytm.feed.b.k())}));
            } else if ("REFRESH".equals(str7)) {
                c cVar4 = c.f34275a;
                c cVar5 = c.f34275a;
                c cVar6 = c.f34275a;
                c cVar7 = c.f34275a;
                net.one97.paytm.feed.b bVar5 = net.one97.paytm.feed.b.f33792d;
                int f2 = net.one97.paytm.feed.b.f();
                net.one97.paytm.feed.b.a(f2 + 1);
                net.one97.paytm.feed.b bVar6 = net.one97.paytm.feed.b.f33792d;
                net.one97.paytm.feed.b bVar7 = net.one97.paytm.feed.b.f33792d;
                net.one97.paytm.feed.b bVar8 = net.one97.paytm.feed.b.f33792d;
                return b(context2, str5, "/content-feed/v2/feed", ae.a((o<? extends K, ? extends V>[]) new o[]{new o(H5Param.SESSION_ID, c.g()), new o("requestType", str7), new o("requestId", str8), new o("latitude", c.e()), new o("longitude", c.f()), new o("languages", c.h()), new o("category", ""), new o("mfPageNo", Integer.valueOf(f2)), new o("pageNo", Integer.valueOf(net.one97.paytm.feed.b.d())), new o("prevPageNo", Integer.valueOf(net.one97.paytm.feed.b.g())), new o("totalPageCount", Integer.valueOf(net.one97.paytm.feed.b.h()))}));
            } else {
                net.one97.paytm.feed.b bVar9 = net.one97.paytm.feed.b.f33792d;
                if (net.one97.paytm.feed.b.g() == -1) {
                    c cVar8 = c.f34275a;
                    c cVar9 = c.f34275a;
                    c cVar10 = c.f34275a;
                    c cVar11 = c.f34275a;
                    net.one97.paytm.feed.b bVar10 = net.one97.paytm.feed.b.f33792d;
                    int f3 = net.one97.paytm.feed.b.f();
                    net.one97.paytm.feed.b.a(f3 + 1);
                    net.one97.paytm.feed.b bVar11 = net.one97.paytm.feed.b.f33792d;
                    net.one97.paytm.feed.b bVar12 = net.one97.paytm.feed.b.f33792d;
                    return b(context2, str5, "/content-feed/v2/feed", ae.a((o<? extends K, ? extends V>[]) new o[]{new o(H5Param.SESSION_ID, c.g()), new o("requestType", str7), new o("requestId", str8), new o("latitude", c.e()), new o("longitude", c.f()), new o("languages", c.h()), new o("category", ""), new o("mfPageNo", Integer.valueOf(f3)), new o("pageNo", Integer.valueOf(net.one97.paytm.feed.b.d())), new o("prevPageNo", ""), new o("totalPageCount", Integer.valueOf(net.one97.paytm.feed.b.h()))}));
                }
                c cVar12 = c.f34275a;
                c cVar13 = c.f34275a;
                c cVar14 = c.f34275a;
                c cVar15 = c.f34275a;
                net.one97.paytm.feed.b bVar13 = net.one97.paytm.feed.b.f33792d;
                int f4 = net.one97.paytm.feed.b.f();
                net.one97.paytm.feed.b.a(f4 + 1);
                net.one97.paytm.feed.b bVar14 = net.one97.paytm.feed.b.f33792d;
                net.one97.paytm.feed.b bVar15 = net.one97.paytm.feed.b.f33792d;
                net.one97.paytm.feed.b bVar16 = net.one97.paytm.feed.b.f33792d;
                return b(context2, str5, "/content-feed/v2/feed", ae.a((o<? extends K, ? extends V>[]) new o[]{new o(H5Param.SESSION_ID, c.g()), new o("requestType", str7), new o("requestId", str8), new o("latitude", c.e()), new o("longitude", c.f()), new o("languages", c.h()), new o("category", ""), new o("mfPageNo", Integer.valueOf(f4)), new o("pageNo", Integer.valueOf(net.one97.paytm.feed.b.d())), new o("prevPageNo", Integer.valueOf(net.one97.paytm.feed.b.g())), new o("totalPageCount", Integer.valueOf(net.one97.paytm.feed.b.h()))}));
            }
        } else if (k.a((Object) "REFRESH", (Object) str7)) {
            c cVar16 = c.f34275a;
            c cVar17 = c.f34275a;
            c cVar18 = c.f34275a;
            c cVar19 = c.f34275a;
            net.one97.paytm.feed.b bVar17 = net.one97.paytm.feed.b.f33792d;
            int p = net.one97.paytm.feed.b.p();
            net.one97.paytm.feed.b.c(p + 1);
            net.one97.paytm.feed.b bVar18 = net.one97.paytm.feed.b.f33792d;
            net.one97.paytm.feed.b bVar19 = net.one97.paytm.feed.b.f33792d;
            net.one97.paytm.feed.b bVar20 = net.one97.paytm.feed.b.f33792d;
            return b(context2, str5, "/content-feed/v2/feed", ae.a((o<? extends K, ? extends V>[]) new o[]{new o(H5Param.SESSION_ID, c.g()), new o("requestType", str7), new o("requestId", str8), new o("latitude", c.e()), new o("longitude", c.f()), new o("languages", c.h()), new o("category", ""), new o("mfPageNo", Integer.valueOf(p)), new o("pageNo", Integer.valueOf(net.one97.paytm.feed.b.m())), new o("requestTab", "FOLLOWFEED"), new o("prevPageNo", Integer.valueOf(net.one97.paytm.feed.b.o())), new o("totalPageCount", Integer.valueOf(net.one97.paytm.feed.b.h()))}));
        } else {
            net.one97.paytm.feed.b bVar21 = net.one97.paytm.feed.b.f33792d;
            if (net.one97.paytm.feed.b.o() == -1) {
                c cVar20 = c.f34275a;
                c cVar21 = c.f34275a;
                c cVar22 = c.f34275a;
                c cVar23 = c.f34275a;
                net.one97.paytm.feed.b bVar22 = net.one97.paytm.feed.b.f33792d;
                int p2 = net.one97.paytm.feed.b.p();
                net.one97.paytm.feed.b.c(p2 + 1);
                net.one97.paytm.feed.b bVar23 = net.one97.paytm.feed.b.f33792d;
                net.one97.paytm.feed.b bVar24 = net.one97.paytm.feed.b.f33792d;
                return b(context2, str5, "/content-feed/v2/feed", ae.a((o<? extends K, ? extends V>[]) new o[]{new o(H5Param.SESSION_ID, c.g()), new o("requestType", str7), new o("requestId", str8), new o("latitude", c.e()), new o("longitude", c.f()), new o("languages", c.h()), new o("category", ""), new o("mfPageNo", Integer.valueOf(p2)), new o("pageNo", Integer.valueOf(net.one97.paytm.feed.b.m())), new o("prevPageNo", ""), new o("requestTab", "FOLLOWFEED"), new o("totalPageCount", Integer.valueOf(net.one97.paytm.feed.b.h()))}));
            }
            c cVar24 = c.f34275a;
            c cVar25 = c.f34275a;
            c cVar26 = c.f34275a;
            c cVar27 = c.f34275a;
            net.one97.paytm.feed.b bVar25 = net.one97.paytm.feed.b.f33792d;
            int p3 = net.one97.paytm.feed.b.p();
            net.one97.paytm.feed.b.c(p3 + 1);
            net.one97.paytm.feed.b bVar26 = net.one97.paytm.feed.b.f33792d;
            net.one97.paytm.feed.b bVar27 = net.one97.paytm.feed.b.f33792d;
            net.one97.paytm.feed.b bVar28 = net.one97.paytm.feed.b.f33792d;
            return b(context2, str5, "/content-feed/v2/feed", ae.a((o<? extends K, ? extends V>[]) new o[]{new o(H5Param.SESSION_ID, c.g()), new o("requestType", str7), new o("requestId", str8), new o("latitude", c.e()), new o("longitude", c.f()), new o("languages", c.h()), new o("category", ""), new o("mfPageNo", Integer.valueOf(p3)), new o("pageNo", Integer.valueOf(net.one97.paytm.feed.b.m())), new o("requestTab", "FOLLOWFEED"), new o("prevPageNo", Integer.valueOf(net.one97.paytm.feed.b.o())), new o("totalPageCount", Integer.valueOf(net.one97.paytm.feed.b.h()))}));
        }
    }
}
