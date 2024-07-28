package com.alipay.imobile.network.quake;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.imobile.network.quake.b.a;
import com.alipay.imobile.network.quake.e.b;
import com.alipay.imobile.network.quake.h.c;
import java.util.HashMap;
import java.util.Map;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    static m f14927a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14928b;

    /* renamed from: c  reason: collision with root package name */
    public String f14929c;

    /* renamed from: d  reason: collision with root package name */
    public String f14930d;

    /* renamed from: e  reason: collision with root package name */
    public String f14931e = "";

    /* renamed from: f  reason: collision with root package name */
    String f14932f = "INNER_JSON_SIGN_V1";

    /* renamed from: g  reason: collision with root package name */
    String f14933g = "INNER_DISK_V1";

    /* renamed from: h  reason: collision with root package name */
    String f14934h = "INNER_HTTP_V1";

    /* renamed from: i  reason: collision with root package name */
    String f14935i = null;
    public String j;
    public String k;
    public String l;
    public d m;
    boolean n = false;
    private Map<String, b<?>> o;
    private Map<String, a> p;
    private Map<String, c> q;

    private m(Context context) {
        if (context != null) {
            this.o = new HashMap();
            this.p = new HashMap();
            this.q = new HashMap();
            this.f14928b = context;
            return;
        }
        throw new com.alipay.mobile.b.b.a((Integer) 9, "QuakeContext can not be initialized with null parameters.");
    }

    public static synchronized m a() throws com.alipay.mobile.b.b.a {
        m mVar;
        synchronized (m.class) {
            if (f14927a != null) {
                mVar = f14927a;
            } else {
                throw new com.alipay.mobile.b.b.a((Integer) 9, "QuakeContext instance has not been initialized.");
            }
        }
        return mVar;
    }

    public static synchronized m a(Context context) {
        m mVar;
        synchronized (m.class) {
            if (f14927a == null) {
                f14927a = new m(context);
            }
            mVar = f14927a;
        }
        return mVar;
    }

    public final synchronized b a(String str) throws com.alipay.imobile.network.quake.c.a {
        b bVar;
        String concat = "can not find request protocol which name is ".concat(String.valueOf(str));
        if (!TextUtils.isEmpty(str)) {
            bVar = this.o.get(str);
            if (bVar == null) {
                throw new com.alipay.imobile.network.quake.c.a((Integer) 18, concat);
            }
        } else {
            throw new com.alipay.imobile.network.quake.c.a((Integer) 18, concat);
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(String str, a aVar) throws com.alipay.imobile.network.quake.c.b {
        a aVar2;
        if (!TextUtils.isEmpty(str)) {
            if (this.p.containsKey(str) && (aVar2 = this.p.get(str)) != null) {
                if (!aVar2.equals(aVar)) {
                    String str2 = "The cache specified with name=" + str + " has already exist, and it is not equals to " + aVar;
                    String str3 = c.f14737a;
                    com.alipay.iap.android.common.b.c.i();
                    throw new com.alipay.imobile.network.quake.c.b(9, str2);
                }
            }
            String str4 = c.f14737a;
            "register cache with the name=".concat(String.valueOf(str));
            com.alipay.iap.android.common.b.c.e();
            this.p.put(str, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0063, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r4, com.alipay.imobile.network.quake.e.b<?> r5) throws com.alipay.imobile.network.quake.c.b {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0064 }
            if (r0 != 0) goto L_0x0062
            if (r5 != 0) goto L_0x000a
            goto L_0x0062
        L_0x000a:
            java.util.Map<java.lang.String, com.alipay.imobile.network.quake.e.b<?>> r0 = r3.o     // Catch:{ all -> 0x0064 }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x0064 }
            r1 = 9
            if (r0 == 0) goto L_0x0046
            java.util.Map<java.lang.String, com.alipay.imobile.network.quake.e.b<?>> r0 = r3.o     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0064 }
            com.alipay.imobile.network.quake.e.b r0 = (com.alipay.imobile.network.quake.e.b) r0     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x004e
            boolean r0 = r0.equals(r5)     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x0025
            goto L_0x004e
        L_0x0025:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "The protocol specified with name="
            r0.<init>(r2)     // Catch:{ all -> 0x0064 }
            r0.append(r4)     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = " has already exist, and it is not equals to "
            r0.append(r4)     // Catch:{ all -> 0x0064 }
            r0.append(r5)     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x0064 }
            java.lang.String r5 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0064 }
            com.alipay.iap.android.common.b.c.i()     // Catch:{ all -> 0x0064 }
            com.alipay.imobile.network.quake.c.b r5 = new com.alipay.imobile.network.quake.c.b     // Catch:{ all -> 0x0064 }
            r5.<init>(r1, r4)     // Catch:{ all -> 0x0064 }
            throw r5     // Catch:{ all -> 0x0064 }
        L_0x0046:
            java.lang.String r0 = "Quake"
            boolean r0 = r4.startsWith(r0)     // Catch:{ all -> 0x0064 }
            if (r0 != 0) goto L_0x0055
        L_0x004e:
            java.util.Map<java.lang.String, com.alipay.imobile.network.quake.e.b<?>> r0 = r3.o     // Catch:{ all -> 0x0064 }
            r0.put(r4, r5)     // Catch:{ all -> 0x0064 }
            monitor-exit(r3)
            return
        L_0x0055:
            java.lang.String r4 = "The name of the request protocol can not start with 'Quake' and 'quake'"
            java.lang.String r5 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0064 }
            com.alipay.iap.android.common.b.c.i()     // Catch:{ all -> 0x0064 }
            com.alipay.imobile.network.quake.c.b r5 = new com.alipay.imobile.network.quake.c.b     // Catch:{ all -> 0x0064 }
            r5.<init>(r1, r4)     // Catch:{ all -> 0x0064 }
            throw r5     // Catch:{ all -> 0x0064 }
        L_0x0062:
            monitor-exit(r3)
            return
        L_0x0064:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.m.a(java.lang.String, com.alipay.imobile.network.quake.e.b):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(String str, c cVar) throws com.alipay.imobile.network.quake.c.b {
        c cVar2;
        if (!TextUtils.isEmpty(str)) {
            if (this.q.containsKey(str) && (cVar2 = this.q.get(str)) != null) {
                if (!cVar2.equals(cVar)) {
                    String str2 = "The transporter specified with name=" + str + " has already exist, and it is not equals to " + cVar;
                    String str3 = c.f14737a;
                    com.alipay.iap.android.common.b.c.i();
                    throw new com.alipay.imobile.network.quake.c.b(9, str2);
                }
            }
            String str4 = c.f14737a;
            "register transporter with the name=".concat(String.valueOf(str));
            com.alipay.iap.android.common.b.c.e();
            this.q.put(str, cVar);
        }
    }

    public final synchronized a b(String str) throws com.alipay.imobile.network.quake.c.a {
        a aVar;
        String concat = "can not find cache which name is ".concat(String.valueOf(str));
        if (!TextUtils.isEmpty(str)) {
            aVar = this.p.get(str);
            if (aVar == null) {
                throw new com.alipay.imobile.network.quake.c.a((Integer) 19, concat);
            }
        } else {
            throw new com.alipay.imobile.network.quake.c.a((Integer) 19, concat);
        }
        return aVar;
    }

    public final synchronized c c(String str) throws com.alipay.imobile.network.quake.c.a {
        c cVar;
        String concat = "can not find transporter which name is ".concat(String.valueOf(str));
        if (!TextUtils.isEmpty(str)) {
            cVar = this.q.get(str);
            if (cVar == null) {
                throw new com.alipay.imobile.network.quake.c.a((Integer) 1, concat);
            }
        } else {
            throw new com.alipay.imobile.network.quake.c.a((Integer) 1, concat);
        }
        return cVar;
    }
}
