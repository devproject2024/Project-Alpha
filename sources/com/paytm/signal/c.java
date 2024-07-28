package com.paytm.signal;

import android.content.Context;
import com.paytm.pai.network.d;
import com.paytm.signal.b;
import com.paytm.signal.data.AppDataBase;
import com.paytm.signal.data.a;
import com.paytm.signal.data.b;
import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f43614a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f43615b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile com.paytm.signal.data.c f43616c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile d f43617d;

    private c() {
    }

    public final a a(Context context) {
        a aVar;
        k.c(context, "context");
        a aVar2 = f43615b;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (this) {
            aVar = f43615b;
            if (aVar == null) {
                aVar = new b(AppDataBase.f43634a.a(context).a(), f43614a.b(context));
                f43615b = aVar;
            }
        }
        return aVar;
    }

    public final com.paytm.signal.data.c b(Context context) {
        com.paytm.signal.data.c cVar;
        k.c(context, "context");
        com.paytm.signal.data.c cVar2 = f43616c;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (this) {
            cVar = f43616c;
            if (cVar == null) {
                cVar = new com.paytm.signal.data.c(context);
                f43616c = cVar;
            }
        }
        return cVar;
    }

    public final d a() {
        d dVar;
        d dVar2 = f43617d;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (this) {
            dVar = f43617d;
            if (dVar == null) {
                b.C0745b bVar = b.f43594e;
                dVar = new d(b.k);
                f43617d = dVar;
            }
        }
        return dVar;
    }
}
