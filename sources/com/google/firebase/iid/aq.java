package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.paytm.android.chat.utils.KeyList;
import java.util.ArrayDeque;
import java.util.Queue;

public final class aq {

    /* renamed from: d  reason: collision with root package name */
    private static aq f38823d;

    /* renamed from: a  reason: collision with root package name */
    Boolean f38824a = null;

    /* renamed from: b  reason: collision with root package name */
    Boolean f38825b = null;

    /* renamed from: c  reason: collision with root package name */
    public final Queue<Intent> f38826c = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    private String f38827e = null;

    public static synchronized aq a() {
        aq aqVar;
        synchronized (aq.class) {
            if (f38823d == null) {
                f38823d = new aq();
            }
            aqVar = f38823d;
        }
        return aqVar;
    }

    private aq() {
    }

    /* access modifiers changed from: package-private */
    public final int a(Context context, Intent intent) {
        ComponentName componentName;
        String b2 = b(context, intent);
        if (b2 != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(b2);
                if (valueOf.length() != 0) {
                    "Restricting intent to a specific service: ".concat(valueOf);
                } else {
                    new String("Restricting intent to a specific service: ");
                }
            }
            intent.setClassName(context.getPackageName(), b2);
        }
        try {
            if (a(context)) {
                componentName = at.a(context, intent);
            } else {
                componentName = context.startService(intent);
            }
            if (componentName == null) {
                return H5ErrorCode.HTTP_NOT_FOUND;
            }
            return -1;
        } catch (SecurityException unused) {
            return 401;
        } catch (IllegalStateException e2) {
            String valueOf2 = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 45);
            sb.append("Failed to start service while in background: ");
            sb.append(valueOf2);
            return KeyList.IntentRequestKey.INTENT_USER_CENTER_RESULT_ACTION_CLEAR;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0091, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String b(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.f38827e     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x0009
            java.lang.String r4 = r3.f38827e     // Catch:{ all -> 0x0092 }
            monitor-exit(r3)
            return r4
        L_0x0009:
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch:{ all -> 0x0092 }
            r1 = 0
            android.content.pm.ResolveInfo r5 = r0.resolveService(r5, r1)     // Catch:{ all -> 0x0092 }
            r0 = 0
            if (r5 == 0) goto L_0x0090
            android.content.pm.ServiceInfo r1 = r5.serviceInfo     // Catch:{ all -> 0x0092 }
            if (r1 != 0) goto L_0x001b
            goto L_0x0090
        L_0x001b:
            android.content.pm.ServiceInfo r5 = r5.serviceInfo     // Catch:{ all -> 0x0092 }
            java.lang.String r1 = r4.getPackageName()     // Catch:{ all -> 0x0092 }
            java.lang.String r2 = r5.packageName     // Catch:{ all -> 0x0092 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0092 }
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = r5.name     // Catch:{ all -> 0x0092 }
            if (r1 != 0) goto L_0x002e
            goto L_0x0062
        L_0x002e:
            java.lang.String r0 = r5.name     // Catch:{ all -> 0x0092 }
            java.lang.String r1 = "."
            boolean r0 = r0.startsWith(r1)     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x005a
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x0092 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0092 }
            java.lang.String r5 = r5.name     // Catch:{ all -> 0x0092 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0092 }
            int r0 = r5.length()     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x0051
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x0092 }
            goto L_0x0057
        L_0x0051:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0092 }
            r5.<init>(r4)     // Catch:{ all -> 0x0092 }
            r4 = r5
        L_0x0057:
            r3.f38827e = r4     // Catch:{ all -> 0x0092 }
            goto L_0x005e
        L_0x005a:
            java.lang.String r4 = r5.name     // Catch:{ all -> 0x0092 }
            r3.f38827e = r4     // Catch:{ all -> 0x0092 }
        L_0x005e:
            java.lang.String r4 = r3.f38827e     // Catch:{ all -> 0x0092 }
            monitor-exit(r3)
            return r4
        L_0x0062:
            java.lang.String r4 = r5.packageName     // Catch:{ all -> 0x0092 }
            java.lang.String r5 = r5.name     // Catch:{ all -> 0x0092 }
            java.lang.String r1 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0092 }
            int r1 = r1.length()     // Catch:{ all -> 0x0092 }
            int r1 = r1 + 94
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0092 }
            int r2 = r2.length()     // Catch:{ all -> 0x0092 }
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0092 }
            r2.<init>(r1)     // Catch:{ all -> 0x0092 }
            java.lang.String r1 = "Error resolving target intent service, skipping classname enforcement. Resolved service was: "
            r2.append(r1)     // Catch:{ all -> 0x0092 }
            r2.append(r4)     // Catch:{ all -> 0x0092 }
            java.lang.String r4 = "/"
            r2.append(r4)     // Catch:{ all -> 0x0092 }
            r2.append(r5)     // Catch:{ all -> 0x0092 }
            monitor-exit(r3)
            return r0
        L_0x0090:
            monitor-exit(r3)
            return r0
        L_0x0092:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.aq.b(android.content.Context, android.content.Intent):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Context context) {
        if (this.f38824a == null) {
            this.f38824a = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f38824a.booleanValue()) {
            Log.isLoggable("FirebaseInstanceId", 3);
        }
        return this.f38824a.booleanValue();
    }
}
