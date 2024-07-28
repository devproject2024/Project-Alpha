package com.alipay.mobile.framework.b;

import java.util.HashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f14956a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Object> f14957b = new HashMap();

    private a() {
    }

    public static final synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f14956a == null) {
                f14956a = new a();
            }
            aVar = f14956a;
        }
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r3, java.lang.Object r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r4 == 0) goto L_0x0026
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x000a
            goto L_0x0026
        L_0x000a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "setProvider name:"
            r0.<init>(r1)     // Catch:{ all -> 0x0023 }
            r0.append(r3)     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = " object:"
            r0.append(r1)     // Catch:{ all -> 0x0023 }
            r0.append(r4)     // Catch:{ all -> 0x0023 }
            java.util.Map<java.lang.String, java.lang.Object> r0 = r2.f14957b     // Catch:{ all -> 0x0023 }
            r0.put(r3, r4)     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            return
        L_0x0023:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x0026:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.framework.b.a.a(java.lang.String, java.lang.Object):void");
    }

    public final synchronized <T> T a(String str) {
        return this.f14957b.get(str);
    }
}
