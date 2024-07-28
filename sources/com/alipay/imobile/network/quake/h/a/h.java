package com.alipay.imobile.network.quake.h.a;

import com.alipay.imobile.network.quake.c;
import com.alipay.imobile.network.quake.h.a.b;
import com.alipay.imobile.network.quake.i.g;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class h implements c {

    /* renamed from: b  reason: collision with root package name */
    private final CookieHandler f14878b;

    public h(CookieHandler cookieHandler) {
        this.f14878b = cookieHandler;
    }

    public final List<b> a(URL url) {
        String str = c.f14737a;
        new StringBuilder("load cookie for url=").append(url.toString());
        com.alipay.iap.android.common.b.c.e();
        try {
            Map<String, List<String>> map = this.f14878b.get(url.toURI(), Collections.emptyMap());
            ArrayList arrayList = null;
            if (map == null) {
                return Collections.emptyList();
            }
            for (Map.Entry next : map.entrySet()) {
                String str2 = (String) next.getKey();
                if (("Cookie".equalsIgnoreCase(str2) || "Cookie2".equalsIgnoreCase(str2) || "Set-Cookie".equalsIgnoreCase(str2) || "Set-Cookie2".equalsIgnoreCase(str2)) && !((List) next.getValue()).isEmpty()) {
                    for (String str3 : (List) next.getValue()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.addAll(a(url, str3));
                    }
                }
            }
            return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
        } catch (IOException | URISyntaxException unused) {
            String str4 = c.f14737a;
            new StringBuilder("Loading cookies failed for ").append(url.toString());
            com.alipay.iap.android.common.b.c.h();
            return Collections.emptyList();
        }
    }

    public final void a(URL url, List<b> list) {
        String str = c.f14737a;
        new StringBuilder("save cookie for url=").append(url.toString());
        com.alipay.iap.android.common.b.c.e();
        if (this.f14878b != null) {
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                arrayList.add(bVar.toString());
            }
            try {
                this.f14878b.put(url.toURI(), Collections.singletonMap("Set-cookie", arrayList));
            } catch (IOException | URISyntaxException unused) {
                String str2 = c.f14737a;
                new StringBuilder("Saving cookies failed for ").append(url.toString());
                com.alipay.iap.android.common.b.c.h();
            }
        }
    }

    private static List<b> a(URL url, String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int a2 = g.a(str, i2, length, ";,");
            int a3 = g.a(str, i2, a2, '=');
            String a4 = g.a(str, i2, a3);
            if (!a4.startsWith("$")) {
                String a5 = a3 < a2 ? g.a(str, a3 + 1, a2) : "";
                if (a5.startsWith("\"") && a5.endsWith("\"")) {
                    a5 = a5.substring(1, a5.length() - 1);
                }
                b.a aVar = new b.a();
                if (a4 == null) {
                    throw new NullPointerException("name == null");
                } else if (a4.trim().equals(a4)) {
                    aVar.f14851a = a4;
                    if (a5 == null) {
                        throw new NullPointerException("value == null");
                    } else if (a5.trim().equals(a5)) {
                        aVar.f14852b = a5;
                        String host = url.getHost();
                        if (host != null) {
                            String a6 = g.a(host);
                            if (a6 != null) {
                                aVar.f14854d = a6;
                                aVar.f14859i = false;
                                arrayList.add(new b(aVar, (byte) 0));
                            } else {
                                throw new IllegalArgumentException("unexpected domain: ".concat(String.valueOf(host)));
                            }
                        } else {
                            throw new IllegalArgumentException("domain == null");
                        }
                    } else {
                        throw new IllegalArgumentException("value is not trimmed");
                    }
                } else {
                    throw new IllegalArgumentException("name is not trimmed");
                }
            }
            i2 = a2 + 1;
        }
        return arrayList;
    }
}
