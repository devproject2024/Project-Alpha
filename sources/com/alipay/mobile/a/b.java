package com.alipay.mobile.a;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f14945a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, List<a>> f14946b = new HashMap();

    private b() {
    }

    public static b a() {
        if (f14945a == null) {
            synchronized (b.class) {
                if (f14945a == null) {
                    f14945a = new b();
                }
            }
        }
        return f14945a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r3, com.alipay.mobile.a.a r4, boolean r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x0060
            if (r4 != 0) goto L_0x000a
            goto L_0x0060
        L_0x000a:
            java.util.Map<java.lang.String, java.util.List<com.alipay.mobile.a.a>> r0 = r2.f14946b     // Catch:{ all -> 0x0062 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0062 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x003f
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ all -> 0x0062 }
            r0.<init>()     // Catch:{ all -> 0x0062 }
            r0.add(r4)     // Catch:{ all -> 0x0062 }
            java.util.Map<java.lang.String, java.util.List<com.alipay.mobile.a.a>> r1 = r2.f14946b     // Catch:{ all -> 0x0062 }
            r1.put(r3, r0)     // Catch:{ all -> 0x0062 }
            if (r5 == 0) goto L_0x005e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = "registerPointCutAdvice put: "
            r5.<init>(r0)     // Catch:{ all -> 0x0062 }
            java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0062 }
            r5.append(r4)     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = " @ "
            r5.append(r4)     // Catch:{ all -> 0x0062 }
            r5.append(r3)     // Catch:{ all -> 0x0062 }
            monitor-exit(r2)
            return
        L_0x003f:
            r0.add(r4)     // Catch:{ all -> 0x0062 }
            if (r5 == 0) goto L_0x005e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = "registerPointCutAdvice add: "
            r5.<init>(r0)     // Catch:{ all -> 0x0062 }
            java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0062 }
            r5.append(r4)     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = " @ "
            r5.append(r4)     // Catch:{ all -> 0x0062 }
            r5.append(r3)     // Catch:{ all -> 0x0062 }
        L_0x005e:
            monitor-exit(r2)
            return
        L_0x0060:
            monitor-exit(r2)
            return
        L_0x0062:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.a.b.a(java.lang.String, com.alipay.mobile.a.a, boolean):void");
    }

    public final synchronized void a(a aVar) {
        for (String str : this.f14946b.keySet()) {
            List list = this.f14946b.get(str);
            if (aVar != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    a aVar2 = (a) list.get(size);
                    if (aVar2 == aVar) {
                        list.remove(aVar2);
                    }
                }
            }
        }
    }

    public final void a(String[] strArr, a aVar) {
        for (int i2 = 0; i2 < 2; i2++) {
            a(strArr[i2], aVar, false);
        }
    }

    public final List<a> a(String str) {
        return this.f14946b.get(str);
    }
}
