package com.arthurivanets.arvi;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import com.arthurivanets.arvi.a.a.b;
import com.arthurivanets.arvi.c;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.o;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.HashMap;
import java.util.Map;

public final class k implements j {

    /* renamed from: a  reason: collision with root package name */
    public static final c f31017a = new c(new c.a(), (byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static volatile j f31018b;

    /* renamed from: c  reason: collision with root package name */
    private final String f31019c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f31020d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<c, b> f31021e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map<b, h> f31022f = new HashMap();

    public static j a(Context context) {
        com.arthurivanets.arvi.b.b.c.a((Object) context);
        if (f31018b == null) {
            synchronized (k.class) {
                if (f31018b == null) {
                    f31018b = new k(context.getApplicationContext());
                }
            }
        }
        return f31018b;
    }

    private k(Context context) {
        b.a();
        this.f31019c = ae.a(context, "ARVI-1.2.0");
        this.f31020d = context.getApplicationContext();
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        if (CookieHandler.getDefault() != cookieManager) {
            CookieHandler.setDefault(cookieManager);
        }
    }

    public final o a(c cVar, Uri uri) {
        com.arthurivanets.arvi.b.b.c.a((Object) cVar);
        com.arthurivanets.arvi.b.b.c.a((Object) uri);
        return a(cVar).a(uri);
    }

    public final String a() {
        return this.f31019c;
    }

    public final Context b() {
        return this.f31020d;
    }

    public final com.arthurivanets.arvi.a.b a(c cVar, String str) {
        com.arthurivanets.arvi.b.b.c.a((Object) cVar);
        com.arthurivanets.arvi.b.b.c.a(str);
        h b2 = b(cVar);
        if (b2 == null || !b2.e(str)) {
            return null;
        }
        return b2.d(str).f31016c;
    }

    public final com.arthurivanets.arvi.a.b b(c cVar, String str) {
        com.arthurivanets.arvi.b.b.c.a((Object) cVar);
        com.arthurivanets.arvi.b.b.c.a(str);
        b a2 = a(cVar);
        h hVar = this.f31022f.get(a2);
        if (hVar == null) {
            hVar = b.c().a();
            this.f31022f.put(a2, hVar);
        }
        Pair pair = new Pair(a2, hVar);
        b bVar = (b) pair.first;
        h hVar2 = (h) pair.second;
        g d2 = hVar2.d(str);
        if (d2 == null && (d2 = hVar2.b(str)) == null) {
            if (hVar2.a()) {
                d2 = hVar2.c(str);
            } else {
                d2 = new g(bVar.a()).a(str);
                hVar2.a(d2);
            }
        }
        return d2.f31016c;
    }

    private b a(c cVar) {
        b bVar = this.f31021e.get(cVar);
        if (bVar != null) {
            return bVar;
        }
        b a2 = b.b().a(this, cVar);
        this.f31021e.put(cVar, a2);
        return a2;
    }

    private h b(c cVar) {
        b bVar = this.f31021e.get(cVar);
        if (bVar != null) {
            return this.f31022f.get(bVar);
        }
        return null;
    }

    public final boolean c(c cVar, String str) {
        com.arthurivanets.arvi.b.b.c.a((Object) cVar);
        com.arthurivanets.arvi.b.b.c.a(str);
        return a(cVar, str) != null;
    }

    public final void d(c cVar, String str) {
        com.arthurivanets.arvi.b.b.c.a((Object) cVar);
        com.arthurivanets.arvi.b.b.c.a(str);
        h b2 = b(cVar);
        if (b2 != null) {
            b2.a(str);
        }
    }
}
