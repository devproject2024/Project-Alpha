package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.firebase.analytics.connector.a;
import com.google.firebase.c;
import com.google.firebase.installations.g;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.l;
import com.google.firebase.remoteconfig.internal.m;
import com.google.firebase.remoteconfig.internal.n;
import com.google.firebase.remoteconfig.internal.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final e f39434a = h.d();

    /* renamed from: b  reason: collision with root package name */
    private static final Random f39435b = new Random();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, a> f39436c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f39437d;

    /* renamed from: e  reason: collision with root package name */
    private final ExecutorService f39438e;

    /* renamed from: f  reason: collision with root package name */
    private final c f39439f;

    /* renamed from: g  reason: collision with root package name */
    private final g f39440g;

    /* renamed from: h  reason: collision with root package name */
    private final com.google.firebase.abt.c f39441h;

    /* renamed from: i  reason: collision with root package name */
    private final a f39442i;
    private final String j;
    private Map<String, String> k;

    o(Context context, c cVar, g gVar, com.google.firebase.abt.c cVar2, a aVar) {
        this(context, Executors.newCachedThreadPool(), cVar, gVar, cVar2, aVar, new q(context, cVar.c().f38755b));
    }

    private o(Context context, ExecutorService executorService, c cVar, g gVar, com.google.firebase.abt.c cVar2, a aVar, q qVar) {
        this.f39436c = new HashMap();
        this.k = new HashMap();
        this.f39437d = context;
        this.f39438e = executorService;
        this.f39439f = cVar;
        this.f39440g = gVar;
        this.f39441h = cVar2;
        this.f39442i = aVar;
        this.j = cVar.c().f38755b;
        com.google.android.gms.tasks.h.a((Executor) executorService, p.a(this));
        qVar.getClass();
        com.google.android.gms.tasks.h.a((Executor) executorService, q.a(qVar));
    }

    public final synchronized a a(String str) {
        com.google.firebase.remoteconfig.internal.a a2;
        com.google.firebase.remoteconfig.internal.a a3;
        com.google.firebase.remoteconfig.internal.a a4;
        m mVar;
        a2 = a(str, "fetch");
        a3 = a(str, "activate");
        a4 = a(str, "defaults");
        mVar = new m(this.f39437d.getSharedPreferences(String.format("%s_%s_%s_%s", new Object[]{"frc", this.j, str, "settings"}), 0));
        return a(this.f39439f, str, this.f39440g, this.f39441h, this.f39438e, a2, a3, a4, a(str, a2, mVar), new l(a3, a4), mVar);
    }

    private synchronized a a(c cVar, String str, g gVar, com.google.firebase.abt.c cVar2, Executor executor, com.google.firebase.remoteconfig.internal.a aVar, com.google.firebase.remoteconfig.internal.a aVar2, com.google.firebase.remoteconfig.internal.a aVar3, com.google.firebase.remoteconfig.internal.g gVar2, l lVar, m mVar) {
        a aVar4;
        String str2 = str;
        synchronized (this) {
            if (!this.f39436c.containsKey(str2)) {
                a aVar5 = new a(this.f39437d, cVar, gVar, str2.equals("firebase") && a(cVar) ? cVar2 : null, executor, aVar, aVar2, aVar3, gVar2, lVar, mVar);
                aVar5.f39308d.b();
                aVar5.f39309e.b();
                aVar5.f39307c.b();
                this.f39436c.put(str2, aVar5);
            }
            aVar4 = this.f39436c.get(str2);
        }
        return aVar4;
    }

    private com.google.firebase.remoteconfig.internal.a a(String str, String str2) {
        return a(this.f39437d, this.j, str, str2);
    }

    public static com.google.firebase.remoteconfig.internal.a a(Context context, String str, String str2, String str3) {
        return com.google.firebase.remoteconfig.internal.a.a(Executors.newCachedThreadPool(), n.a(context, String.format("%s_%s_%s_%s.json", new Object[]{"frc", str, str2, str3})));
    }

    private synchronized com.google.firebase.remoteconfig.internal.g a(String str, com.google.firebase.remoteconfig.internal.a aVar, m mVar) {
        com.google.firebase.remoteconfig.internal.g gVar;
        synchronized (this) {
            g gVar2 = this.f39440g;
            gVar = new com.google.firebase.remoteconfig.internal.g(gVar2, a(this.f39439f) ? this.f39442i : null, this.f39438e, f39434a, f39435b, aVar, new ConfigFetchHttpClient(this.f39437d, this.f39439f.c().f38755b, this.f39439f.c().f38754a, str, mVar.b(), mVar.b()), mVar, this.k);
        }
        return gVar;
    }

    private static boolean a(c cVar) {
        return cVar.b().equals("[DEFAULT]");
    }
}
