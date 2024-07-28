package androidx.lifecycle;

import java.util.Queue;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    boolean f3665a;

    /* renamed from: b  reason: collision with root package name */
    boolean f3666b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3667c;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<Runnable> f3668d;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0022 A[Catch:{ all -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0030 A[EDGE_INSN: B:25:0x0030->B:19:0x0030 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r3 = this;
            boolean r0 = r3.f3667c
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            r3.f3667c = r1     // Catch:{ all -> 0x0033 }
        L_0x0009:
            java.util.Queue<java.lang.Runnable> r2 = r3.f3668d     // Catch:{ all -> 0x0033 }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0033 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0033 }
            r2 = r2 ^ r1
            if (r2 == 0) goto L_0x0030
            boolean r2 = r3.f3666b     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x001f
            boolean r2 = r3.f3665a     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r2 = 0
            goto L_0x0020
        L_0x001f:
            r2 = 1
        L_0x0020:
            if (r2 == 0) goto L_0x0030
            java.util.Queue<java.lang.Runnable> r2 = r3.f3668d     // Catch:{ all -> 0x0033 }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x0033 }
            java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x0009
            r2.run()     // Catch:{ all -> 0x0033 }
            goto L_0x0009
        L_0x0030:
            r3.f3667c = r0
            return
        L_0x0033:
            r1 = move-exception
            r3.f3667c = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.e.a():void");
    }
}
