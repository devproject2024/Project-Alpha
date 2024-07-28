package com.google.android.gms.internal.icing;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static UserManager f10259a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f10260b = (!a());

    /* renamed from: c  reason: collision with root package name */
    private static boolean f10261c = false;

    private k() {
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
            if (f10259a == null) {
                f10259a = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = f10259a;
            if (userManager == null) {
                return true;
            }
            try {
                if (userManager.isUserUnlocked() || !userManager.isUserRunning(Process.myUserHandle())) {
                    z = true;
                }
            } catch (NullPointerException unused) {
                f10259a = null;
                i2++;
            }
        }
        if (z) {
            f10259a = null;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(android.content.Context r3) {
        /*
            boolean r0 = f10260b
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.Class<com.google.android.gms.internal.icing.k> r0 = com.google.android.gms.internal.icing.k.class
            monitor-enter(r0)
            boolean r2 = f10260b     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r1
        L_0x000f:
            boolean r3 = b(r3)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0017
            f10260b = r3     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r3
        L_0x0019:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.k.c(android.content.Context):boolean");
    }
}
