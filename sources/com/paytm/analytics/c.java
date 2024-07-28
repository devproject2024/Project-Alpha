package com.paytm.analytics;

import android.content.Context;
import com.paytm.analytics.b;
import com.paytm.analytics.data.AppDataBase;
import com.paytm.analytics.data.a;
import com.paytm.analytics.data.b;
import com.paytm.pai.network.d;
import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f40931a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f40932b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile com.paytm.analytics.data.c f40933c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile d f40934d;

    private c() {
    }

    public final a a(Context context) {
        a aVar;
        k.c(context, "context");
        a aVar2 = f40932b;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (this) {
            aVar = f40932b;
            if (aVar == null) {
                aVar = new b(AppDataBase.f40951a.a(context).a(), f40931a.b(context));
                f40932b = aVar;
            }
        }
        return aVar;
    }

    public final com.paytm.analytics.data.c b(Context context) {
        com.paytm.analytics.data.c cVar;
        k.c(context, "context");
        com.paytm.analytics.data.c cVar2 = f40933c;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (this) {
            cVar = f40933c;
            if (cVar == null) {
                cVar = new com.paytm.analytics.data.c(context);
                f40933c = cVar;
            }
        }
        return cVar;
    }

    public final d a() {
        d dVar;
        d dVar2 = f40934d;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (this) {
            dVar = f40934d;
            if (dVar == null) {
                b.C0683b bVar = b.f40911e;
                dVar = new d(b.k);
                f40934d = dVar;
            }
        }
        return dVar;
    }
}
