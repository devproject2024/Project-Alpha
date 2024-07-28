package com.alipay.imobile.network.quake;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieSyncManager;
import com.alipay.imobile.network.a.a.a;
import com.alipay.imobile.network.quake.i.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public static String f14737a = "Quake";

    /* renamed from: b  reason: collision with root package name */
    private static a f14738b;

    /* renamed from: c  reason: collision with root package name */
    private n f14739c;

    /* renamed from: d  reason: collision with root package name */
    private m f14740d;

    /* renamed from: e  reason: collision with root package name */
    private Context f14741e;

    /* renamed from: f  reason: collision with root package name */
    private List<Object> f14742f = new LinkedList();

    /* renamed from: g  reason: collision with root package name */
    private a f14743g;

    private c(Context context) {
        if (context != null) {
            this.f14741e = context.getApplicationContext();
            com.alipay.iap.android.common.b.c.a(this.f14741e);
            this.f14740d = m.a(this.f14741e);
            b.a();
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(this.f14741e);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Context param must not be null.");
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (c.class) {
            if (f14738b == null) {
                f14738b = new c(context);
            }
            aVar = f14738b;
        }
        return aVar;
    }

    public static synchronized a g() throws com.alipay.mobile.b.b.a {
        a aVar;
        synchronized (c.class) {
            if (f14738b != null) {
                aVar = f14738b;
            } else {
                throw new com.alipay.mobile.b.b.a((Integer) 9, "IQuake has not been initialized by createInstance(Context).");
            }
        }
        return aVar;
    }

    public final List<Object> e() {
        return this.f14742f;
    }

    public final a f() {
        return this.f14743g;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        com.alipay.iap.android.common.b.c.c();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x007c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.alipay.imobile.network.quake.d r9) throws com.alipay.imobile.network.quake.c.b {
        /*
            r8 = this;
            monitor-enter(r8)
            com.alipay.imobile.network.quake.m r0 = r8.f14740d     // Catch:{ all -> 0x00c9 }
            com.alipay.imobile.network.quake.d r1 = r0.m     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x0016
            com.alipay.imobile.network.quake.d r1 = r0.m     // Catch:{ all -> 0x00c9 }
            if (r9 != r1) goto L_0x000c
            goto L_0x0016
        L_0x000c:
            com.alipay.imobile.network.quake.c.b r9 = new com.alipay.imobile.network.quake.c.b     // Catch:{ all -> 0x00c9 }
            r0 = 9
            java.lang.String r1 = "Error to duplicate setting QuakeConfig."
            r9.<init>(r0, r1)     // Catch:{ all -> 0x00c9 }
            throw r9     // Catch:{ all -> 0x00c9 }
        L_0x0016:
            r0.m = r9     // Catch:{ all -> 0x00c9 }
            com.alipay.imobile.network.quake.d r9 = r0.m     // Catch:{ all -> 0x00c9 }
            java.lang.String r9 = r9.f14747d     // Catch:{ all -> 0x00c9 }
            r0.f14935i = r9     // Catch:{ all -> 0x00c9 }
            com.alipay.imobile.network.quake.d r9 = r0.m     // Catch:{ all -> 0x00c9 }
            java.lang.String r9 = r9.f14744a     // Catch:{ all -> 0x00c9 }
            r0.f14930d = r9     // Catch:{ all -> 0x00c9 }
            com.alipay.imobile.network.quake.d r9 = r0.m     // Catch:{ all -> 0x00c9 }
            java.lang.String r9 = r9.f14745b     // Catch:{ all -> 0x00c9 }
            r0.f14929c = r9     // Catch:{ all -> 0x00c9 }
            com.alipay.imobile.network.quake.d r9 = r0.m     // Catch:{ all -> 0x00c9 }
            java.lang.String r9 = r9.f14746c     // Catch:{ all -> 0x00c9 }
            r0.f14931e = r9     // Catch:{ all -> 0x00c9 }
            com.alipay.imobile.network.quake.d r9 = r0.m     // Catch:{ all -> 0x00c9 }
            java.lang.String r9 = r9.f14748e     // Catch:{ all -> 0x00c9 }
            r0.j = r9     // Catch:{ all -> 0x00c9 }
            com.alipay.imobile.network.quake.d r9 = r0.m     // Catch:{ all -> 0x00c9 }
            java.lang.String r9 = r9.f14749f     // Catch:{ all -> 0x00c9 }
            r0.k = r9     // Catch:{ all -> 0x00c9 }
            com.alipay.imobile.network.quake.d r9 = r0.m     // Catch:{ all -> 0x00c9 }
            java.lang.String r9 = r9.f14750g     // Catch:{ all -> 0x00c9 }
            r0.l = r9     // Catch:{ all -> 0x00c9 }
            boolean r9 = r0.n     // Catch:{ all -> 0x00c9 }
            if (r9 != 0) goto L_0x00c7
            r9 = 0
            r1 = 0
            r2 = 1
            java.lang.String r3 = "com.google.gson.f"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x007c }
            java.lang.String r4 = "com.alipay.imobile.network.quake.ext.protocol.gson.GsonProtocol"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ Exception -> 0x007c }
            if (r3 == 0) goto L_0x007f
            if (r4 == 0) goto L_0x007f
            java.lang.Class<com.alipay.imobile.network.quake.e.b> r3 = com.alipay.imobile.network.quake.e.b.class
            boolean r3 = r3.isAssignableFrom(r4)     // Catch:{ Exception -> 0x007c }
            if (r3 == 0) goto L_0x007f
            com.alipay.iap.android.common.b.c.c()     // Catch:{ Exception -> 0x007c }
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x007c }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r3[r1] = r5     // Catch:{ Exception -> 0x007c }
            java.lang.reflect.Constructor r3 = r4.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x007c }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x007c }
            android.content.Context r5 = r0.f14928b     // Catch:{ Exception -> 0x007c }
            r4[r1] = r5     // Catch:{ Exception -> 0x007c }
            java.lang.Object r3 = r3.newInstance(r4)     // Catch:{ Exception -> 0x007c }
            com.alipay.imobile.network.quake.e.b r3 = (com.alipay.imobile.network.quake.e.b) r3     // Catch:{ Exception -> 0x007c }
            r9 = r3
            goto L_0x007f
        L_0x007c:
            com.alipay.iap.android.common.b.c.c()     // Catch:{ all -> 0x00c9 }
        L_0x007f:
            if (r9 != 0) goto L_0x008b
            com.alipay.iap.android.common.b.c.c()     // Catch:{ all -> 0x00c9 }
            com.alipay.imobile.network.quake.e.a.a r9 = new com.alipay.imobile.network.quake.e.a.a     // Catch:{ all -> 0x00c9 }
            android.content.Context r3 = r0.f14928b     // Catch:{ all -> 0x00c9 }
            r9.<init>(r3)     // Catch:{ all -> 0x00c9 }
        L_0x008b:
            com.alipay.imobile.network.quake.m r3 = com.alipay.imobile.network.quake.m.f14927a     // Catch:{ all -> 0x00c9 }
            java.lang.String r4 = "INNER_JSON_SIGN_V1"
            r3.a((java.lang.String) r4, (com.alipay.imobile.network.quake.e.b<?>) r9)     // Catch:{ all -> 0x00c9 }
            com.alipay.imobile.network.quake.m r9 = com.alipay.imobile.network.quake.m.f14927a     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = "alipay.client.executerpc"
            com.alipay.imobile.network.quake.e.c r4 = new com.alipay.imobile.network.quake.e.c     // Catch:{ all -> 0x00c9 }
            android.content.Context r5 = r0.f14928b     // Catch:{ all -> 0x00c9 }
            r4.<init>(r5)     // Catch:{ all -> 0x00c9 }
            r9.a((java.lang.String) r3, (com.alipay.imobile.network.quake.e.b<?>) r4)     // Catch:{ all -> 0x00c9 }
            com.alipay.imobile.network.quake.m r9 = com.alipay.imobile.network.quake.m.f14927a     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = "INNER_HTTP_V1"
            com.alipay.imobile.network.quake.h.a.d r4 = new com.alipay.imobile.network.quake.h.a.d     // Catch:{ all -> 0x00c9 }
            r4.<init>()     // Catch:{ all -> 0x00c9 }
            r9.a((java.lang.String) r3, (com.alipay.imobile.network.quake.h.c) r4)     // Catch:{ all -> 0x00c9 }
            com.alipay.imobile.network.quake.m r9 = com.alipay.imobile.network.quake.m.f14927a     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = "INNER_DISK_V1"
            com.alipay.imobile.network.quake.b.b r4 = new com.alipay.imobile.network.quake.b.b     // Catch:{ all -> 0x00c9 }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x00c9 }
            android.content.Context r6 = r0.f14928b     // Catch:{ all -> 0x00c9 }
            java.io.File r6 = r6.getCacheDir()     // Catch:{ all -> 0x00c9 }
            java.lang.String r7 = "quake"
            r5.<init>(r6, r7)     // Catch:{ all -> 0x00c9 }
            r4.<init>(r5, r1)     // Catch:{ all -> 0x00c9 }
            r9.a((java.lang.String) r3, (com.alipay.imobile.network.quake.b.a) r4)     // Catch:{ all -> 0x00c9 }
            r0.n = r2     // Catch:{ all -> 0x00c9 }
        L_0x00c7:
            monitor-exit(r8)
            return
        L_0x00c9:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.c.a(com.alipay.imobile.network.quake.d):void");
    }

    public final synchronized d a() {
        return this.f14740d.m;
    }

    public final synchronized String b() {
        return this.f14740d.f14933g;
    }

    public final synchronized String c() {
        return this.f14740d.f14934h;
    }

    public final synchronized String d() {
        return this.f14740d.f14932f;
    }

    public final synchronized e a(e eVar) {
        if (this.f14739c == null && this.f14739c == null) {
            this.f14739c = new n(this.f14740d);
            n nVar = this.f14739c;
            if (nVar.f14941f != null) {
                h hVar = nVar.f14941f;
                hVar.f14820a = true;
                hVar.interrupt();
            }
            if (nVar.f14940e != null) {
                l lVar = nVar.f14940e;
                lVar.f14920a = true;
                lVar.interrupt();
            }
            if (nVar.f14942g != null) {
                i iVar = nVar.f14942g;
                iVar.f14893a = true;
                iVar.interrupt();
            }
            nVar.f14941f = new h(nVar.f14936a, nVar.f14937b, nVar.f14939d, nVar.f14943h);
            nVar.f14941f.start();
            nVar.f14940e = new l(nVar.f14937b, nVar.f14938c, nVar.f14939d, nVar.f14943h);
            nVar.f14940e.start();
            nVar.f14942g = new i(nVar.f14938c, nVar.f14939d, nVar.f14943h);
            nVar.f14942g.start();
        }
        Iterator<Object> it2 = this.f14742f.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
        this.f14739c.b(eVar);
        return eVar;
    }
}
