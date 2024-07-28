package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;

public class aq {

    /* renamed from: a  reason: collision with root package name */
    private static UserManager f10462a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f10463b = (!a());

    /* renamed from: c  reason: collision with root package name */
    private static boolean f10464c = false;

    private aq() {
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean a(Context context) {
        return !a() || c(context);
    }

    private static boolean b(Context context) {
        boolean z;
        int i2 = 1;
        while (true) {
            z = false;
            if (i2 > 2) {
                break;
            }
            if (f10462a == null) {
                f10462a = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = f10462a;
            if (userManager == null) {
                return true;
            }
            try {
                if (userManager.isUserUnlocked() || !userManager.isUserRunning(Process.myUserHandle())) {
                    z = true;
                }
            } catch (NullPointerException unused) {
                f10462a = null;
                i2++;
            }
        }
        if (z) {
            f10462a = null;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(android.content.Context r3) {
        /*
            boolean r0 = f10463b
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.Class<com.google.android.gms.internal.measurement.aq> r0 = com.google.android.gms.internal.measurement.aq.class
            monitor-enter(r0)
            boolean r2 = f10463b     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r1
        L_0x000f:
            boolean r3 = b(r3)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0017
            f10463b = r3     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r3
        L_0x0019:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.aq.c(android.content.Context):boolean");
    }
}
