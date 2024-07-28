package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import com.google.android.gms.b.d;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.ax;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.concurrent.Callable;

final class n {

    /* renamed from: a  reason: collision with root package name */
    private static volatile av f8882a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f8883b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Context f8884c;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void a(android.content.Context r2) {
        /*
            java.lang.Class<com.google.android.gms.common.n> r0 = com.google.android.gms.common.n.class
            monitor-enter(r0)
            android.content.Context r1 = f8884c     // Catch:{ all -> 0x0013 }
            if (r1 != 0) goto L_0x0011
            if (r2 == 0) goto L_0x0011
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0013 }
            f8884c = r2     // Catch:{ all -> 0x0013 }
            monitor-exit(r0)
            return
        L_0x0011:
            monitor-exit(r0)
            return
        L_0x0013:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.n.a(android.content.Context):void");
    }

    static w a(String str, o oVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return b(str, oVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static w b(String str, o oVar, boolean z, boolean z2) {
        try {
            if (f8882a == null) {
                s.a(f8884c);
                synchronized (f8883b) {
                    if (f8882a == null) {
                        f8882a = ax.a(DynamiteModule.a(f8884c, DynamiteModule.f9012e, "com.google.android.gms.googlecertificates").a("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            s.a(f8884c);
            try {
                if (f8882a.a(new zzj(str, oVar, z, z2), d.a(f8884c.getPackageManager()))) {
                    return w.a();
                }
                return w.a((Callable<String>) new p(z, str, oVar));
            } catch (RemoteException e2) {
                return w.a("module call", e2);
            }
        } catch (DynamiteModule.a e3) {
            String valueOf = String.valueOf(e3.getMessage());
            return w.a(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e3);
        }
    }

    static final /* synthetic */ String a(boolean z, String str, o oVar) throws Exception {
        boolean z2 = true;
        if (z || !b(str, oVar, true, false).f9000a) {
            z2 = false;
        }
        return w.a(str, oVar, z, z2);
    }
}
