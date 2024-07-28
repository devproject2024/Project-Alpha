package com.alipay.imobile.network.quake;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.alipay.imobile.network.quake.h.a.c;
import com.alipay.imobile.network.quake.h.a.h;
import com.alipay.imobile.network.quake.h.b;
import com.alipay.imobile.network.quake.h.c.a;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    String f14744a;

    /* renamed from: b  reason: collision with root package name */
    public String f14745b;

    /* renamed from: c  reason: collision with root package name */
    public String f14746c;

    /* renamed from: d  reason: collision with root package name */
    public String f14747d;

    /* renamed from: e  reason: collision with root package name */
    String f14748e;

    /* renamed from: f  reason: collision with root package name */
    String f14749f;

    /* renamed from: g  reason: collision with root package name */
    String f14750g;

    /* renamed from: h  reason: collision with root package name */
    int f14751h;

    /* renamed from: i  reason: collision with root package name */
    public c f14752i;
    public b j;
    public Map<String, String> k;
    CookieManager l;
    private int m;
    private int n;

    public d(d dVar) {
        this(dVar.f14744a, dVar.f14745b, dVar.f14746c, dVar.f14747d, dVar.f14751h);
    }

    public d(String str, String str2, String str3) {
        this(str, str2, str3, (byte) 0);
    }

    private d(String str, String str2, String str3, byte b2) {
        this(str, str2, "", str3, 4);
    }

    public final com.alipay.imobile.network.quake.h.c.b a() {
        return new a(this.m, this.n);
    }

    private d(String str, String str2, String str3, String str4, int i2) {
        this.m = AppConstants.START_OTP_FLOW;
        this.n = 0;
        this.f14744a = str;
        this.f14745b = str2;
        this.f14746c = str3;
        this.f14747d = str4;
        this.f14751h = i2;
        this.j = null;
        try {
            this.l = CookieManager.getInstance();
            this.f14752i = new h(new CookieHandler() {
                public final Map<String, List<String>> get(URI uri, Map<String, List<String>> map) throws IOException {
                    if (uri == null) {
                        return null;
                    }
                    String cookie = d.this.l.getCookie(uri.toString());
                    if (TextUtils.isEmpty(cookie)) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(cookie);
                    HashMap hashMap = new HashMap();
                    hashMap.put("Cookie", arrayList);
                    return hashMap;
                }

                public final void put(URI uri, Map<String, List<String>> map) throws IOException {
                    if (uri != null && map != null && !map.isEmpty()) {
                        for (Map.Entry<String, List<String>> value : map.entrySet()) {
                            for (String cookie : (List) value.getValue()) {
                                d.this.l.setCookie(uri.toString(), cookie);
                            }
                        }
                        if (Build.VERSION.SDK_INT >= 21) {
                            d.this.l.flush();
                        } else {
                            CookieSyncManager.getInstance().sync();
                        }
                    }
                }
            });
        } catch (Throwable unused) {
            String str5 = c.f14737a;
            com.alipay.iap.android.common.b.c.j();
            this.f14752i = new h(new java.net.CookieManager());
        }
    }
}
