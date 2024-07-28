package com.paytm.notification;

import android.content.Context;
import com.paytm.notification.data.c.b;
import com.paytm.notification.data.c.c;
import com.paytm.notification.data.c.d;
import com.paytm.notification.data.c.e;
import com.paytm.notification.data.c.f;
import com.paytm.notification.data.c.h;
import com.paytm.notification.data.c.i;
import com.paytm.notification.data.datasource.dao.AppDatabase;
import com.paytm.notification.g;
import kotlin.g.b.k;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f43241a = new j();

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f43242b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile com.paytm.notification.data.c.j f43243c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile h f43244d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile f f43245e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile d f43246f;

    private j() {
    }

    public final b a() {
        b bVar;
        b bVar2 = f43242b;
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (this) {
            bVar = f43242b;
            if (bVar == null) {
                AppDatabase.a aVar = AppDatabase.f43093a;
                g.c cVar = g.f43191a;
                Context d2 = g.f43192h;
                if (d2 == null) {
                    k.a();
                }
                c cVar2 = new c(aVar.a(d2).a());
                f43242b = cVar2;
                bVar = cVar2;
            }
        }
        return bVar;
    }

    public final com.paytm.notification.data.c.j b() {
        com.paytm.notification.data.c.j jVar;
        com.paytm.notification.data.c.j jVar2 = f43243c;
        if (jVar2 != null) {
            return jVar2;
        }
        synchronized (this) {
            jVar = f43243c;
            if (jVar == null) {
                AppDatabase.a aVar = AppDatabase.f43093a;
                g.c cVar = g.f43191a;
                Context d2 = g.f43192h;
                if (d2 == null) {
                    k.a();
                }
                com.paytm.notification.data.c.k kVar = new com.paytm.notification.data.c.k(aVar.a(d2).b());
                f43243c = kVar;
                jVar = kVar;
            }
        }
        return jVar;
    }

    public final h c() {
        h hVar;
        h hVar2 = f43244d;
        if (hVar2 != null) {
            return hVar2;
        }
        synchronized (this) {
            hVar = f43244d;
            if (hVar == null) {
                g.c cVar = g.f43191a;
                Context d2 = g.f43192h;
                if (d2 == null) {
                    k.a();
                }
                i iVar = new i(new com.paytm.notification.data.b.b(d2));
                f43244d = iVar;
                hVar = iVar;
            }
        }
        return hVar;
    }

    public final f d() {
        f fVar;
        f fVar2 = f43245e;
        if (fVar2 != null) {
            return fVar2;
        }
        synchronized (this) {
            fVar = f43245e;
            if (fVar == null) {
                g.c cVar = g.f43191a;
                Context d2 = g.f43192h;
                if (d2 == null) {
                    k.a();
                }
                com.paytm.notification.data.b.d dVar = new com.paytm.notification.data.b.d(d2);
                AppDatabase.a aVar = AppDatabase.f43093a;
                g.c cVar2 = g.f43191a;
                Context d3 = g.f43192h;
                if (d3 == null) {
                    k.a();
                }
                com.paytm.notification.data.datasource.dao.d c2 = aVar.a(d3).c();
                g.c cVar3 = g.f43191a;
                Context d4 = g.f43192h;
                if (d4 == null) {
                    k.a();
                }
                com.paytm.notification.data.c.g gVar = new com.paytm.notification.data.c.g(d4, c2, dVar);
                f43245e = gVar;
                fVar = gVar;
            }
        }
        return fVar;
    }

    public final d e() {
        d dVar;
        d dVar2 = f43246f;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (this) {
            dVar = f43246f;
            if (dVar == null) {
                g.c cVar = g.f43191a;
                Context d2 = g.f43192h;
                if (d2 == null) {
                    k.a();
                }
                com.paytm.notification.data.b.c cVar2 = new com.paytm.notification.data.b.c(d2);
                AppDatabase.a aVar = AppDatabase.f43093a;
                g.c cVar3 = g.f43191a;
                Context d3 = g.f43192h;
                if (d3 == null) {
                    k.a();
                }
                e eVar = new e(aVar.a(d3).d(), cVar2);
                f43246f = eVar;
                dVar = eVar;
            }
        }
        return dVar;
    }
}
