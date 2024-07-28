package com.google.firebase.crashlytics.a.c;

import com.google.firebase.crashlytics.a.k.e;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

final class p implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    final AtomicBoolean f38301a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final a f38302b;

    /* renamed from: c  reason: collision with root package name */
    private final e f38303c;

    /* renamed from: d  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f38304d;

    interface a {
        void a(e eVar, Thread thread, Throwable th);
    }

    public p(a aVar, e eVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f38302b = aVar;
        this.f38303c = eVar;
        this.f38304d = uncaughtExceptionHandler;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        com.google.firebase.crashlytics.a.b.a().a(6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        com.google.firebase.crashlytics.a.b.a().a(3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        com.google.firebase.crashlytics.a.b.a().a(3);
        r5.f38304d.uncaughtException(r6, r7);
        r5.f38301a.set(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0038 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void uncaughtException(java.lang.Thread r6, java.lang.Throwable r7) {
        /*
            r5 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.f38301a
            r1 = 1
            r0.set(r1)
            r0 = 0
            r1 = 3
            r2 = 6
            if (r6 != 0) goto L_0x0015
            com.google.firebase.crashlytics.a.b r3 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x0038 }
            r3.a(r2)     // Catch:{ Exception -> 0x0038 }
            goto L_0x0026
        L_0x0013:
            r2 = move-exception
            goto L_0x0047
        L_0x0015:
            if (r7 != 0) goto L_0x001f
            com.google.firebase.crashlytics.a.b r3 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x0038 }
            r3.a(r2)     // Catch:{ Exception -> 0x0038 }
            goto L_0x0026
        L_0x001f:
            com.google.firebase.crashlytics.a.c.p$a r3 = r5.f38302b     // Catch:{ Exception -> 0x0038 }
            com.google.firebase.crashlytics.a.k.e r4 = r5.f38303c     // Catch:{ Exception -> 0x0038 }
            r3.a(r4, r6, r7)     // Catch:{ Exception -> 0x0038 }
        L_0x0026:
            com.google.firebase.crashlytics.a.b r2 = com.google.firebase.crashlytics.a.b.a()
            r2.a(r1)
        L_0x002d:
            java.lang.Thread$UncaughtExceptionHandler r1 = r5.f38304d
            r1.uncaughtException(r6, r7)
            java.util.concurrent.atomic.AtomicBoolean r6 = r5.f38301a
            r6.set(r0)
            return
        L_0x0038:
            com.google.firebase.crashlytics.a.b r3 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x0013 }
            r3.a(r2)     // Catch:{ all -> 0x0013 }
            com.google.firebase.crashlytics.a.b r2 = com.google.firebase.crashlytics.a.b.a()
            r2.a(r1)
            goto L_0x002d
        L_0x0047:
            com.google.firebase.crashlytics.a.b r3 = com.google.firebase.crashlytics.a.b.a()
            r3.a(r1)
            java.lang.Thread$UncaughtExceptionHandler r1 = r5.f38304d
            r1.uncaughtException(r6, r7)
            java.util.concurrent.atomic.AtomicBoolean r6 = r5.f38301a
            r6.set(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.c.p.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
