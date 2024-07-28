package com.uninstallationtracking;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static long f45709a = 86400000;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f45710b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f45711c = "UIT-Tracker";

    public static void a() {
    }

    public static synchronized boolean a(Context context) {
        boolean z;
        synchronized (b.class) {
            if (a.a(context)) {
                z = false;
            } else {
                z = true;
            }
        }
        return z;
    }

    public static synchronized void b(Context context) {
        synchronized (b.class) {
            a(context, c(context), AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 12345, new Intent(context, AlarmReceiver.class), 134217728);
            ((AlarmManager) context.getSystemService("alarm")).setInexactRepeating(0, System.currentTimeMillis(), f45709a, broadcast);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:2|3|4|5|6|7|8|9|10|(1:12)|13|(1:15)|16|17|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:20|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a3, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x008f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x009e */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x009e=Splitter:B:20:0x009e, B:16:0x008f=Splitter:B:16:0x008f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.Class<com.uninstallationtracking.b> r0 = com.uninstallationtracking.b.class
            monitor-enter(r0)
            java.lang.String r1 = "Caller: "
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00a4 }
            r1.concat(r2)     // Catch:{ all -> 0x00a4 }
            android.widget.ImageView r1 = new android.widget.ImageView     // Catch:{ all -> 0x00a4 }
            r1.<init>(r7)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r7.getPackageName()     // Catch:{ all -> 0x00a4 }
            android.content.pm.PackageManager r3 = r7.getPackageManager()     // Catch:{ NameNotFoundException -> 0x009e }
            r4 = 0
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r2, r4)     // Catch:{ NameNotFoundException -> 0x009e }
            java.lang.String r3 = r3.versionName     // Catch:{ NameNotFoundException -> 0x009e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            java.lang.String r6 = "http://d2wtctrcxsjrgr.cloudfront.net/collect.gif?app="
            r5.<init>(r6)     // Catch:{ all -> 0x00a4 }
            r5.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = "&vid="
            r5.append(r2)     // Catch:{ all -> 0x00a4 }
            r5.append(r8)     // Catch:{ all -> 0x00a4 }
            java.lang.String r8 = "&ver="
            r5.append(r8)     // Catch:{ all -> 0x00a4 }
            r5.append(r3)     // Catch:{ all -> 0x00a4 }
            java.lang.String r8 = "&caller="
            r5.append(r8)     // Catch:{ all -> 0x00a4 }
            r5.append(r9)     // Catch:{ all -> 0x00a4 }
            java.lang.String r8 = "&first_call=0"
            r5.append(r8)     // Catch:{ all -> 0x00a4 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x00a4 }
            android.content.ContentResolver r9 = r7.getContentResolver()     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = "android_id"
            java.lang.String r9 = android.provider.Settings.Secure.getString(r9, r2)     // Catch:{ Exception -> 0x008f }
            if (r9 == 0) goto L_0x006c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008f }
            java.lang.String r3 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x008f }
            r2.<init>(r3)     // Catch:{ Exception -> 0x008f }
            java.lang.String r3 = "&aid="
            r2.append(r3)     // Catch:{ Exception -> 0x008f }
            r2.append(r9)     // Catch:{ Exception -> 0x008f }
            java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x008f }
        L_0x006c:
            java.lang.String r9 = "phone"
            java.lang.Object r7 = r7.getSystemService(r9)     // Catch:{ Exception -> 0x008f }
            android.telephony.TelephonyManager r7 = (android.telephony.TelephonyManager) r7     // Catch:{ Exception -> 0x008f }
            java.lang.String r7 = r7.getDeviceId()     // Catch:{ Exception -> 0x008f }
            if (r7 == 0) goto L_0x008f
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x008f }
            r9.<init>(r2)     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = "&did="
            r9.append(r2)     // Catch:{ Exception -> 0x008f }
            r9.append(r7)     // Catch:{ Exception -> 0x008f }
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x008f }
        L_0x008f:
            com.uninstallationtracking.c r7 = new com.uninstallationtracking.c     // Catch:{ all -> 0x00a4 }
            r7.<init>(r1)     // Catch:{ all -> 0x00a4 }
            r9 = 1
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ all -> 0x00a4 }
            r9[r4] = r8     // Catch:{ all -> 0x00a4 }
            r7.execute(r9)     // Catch:{ all -> 0x00a4 }
            monitor-exit(r0)
            return
        L_0x009e:
            java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch:{ all -> 0x00a4 }
            r7.<init>()     // Catch:{ all -> 0x00a4 }
            throw r7     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uninstallationtracking.b.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    private static synchronized String c(Context context) {
        String uuid;
        synchronized (b.class) {
            new a(context);
            uuid = a.a().toString();
        }
        return uuid;
    }
}
