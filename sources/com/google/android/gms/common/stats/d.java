package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.s;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f8955a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f8956b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f8957c = false;

    public static d a() {
        return f8955a;
    }

    public static void a(Context context, String str, int i2, String str2, String str3, int i3, List<String> list, long j) {
        int i4 = i2;
        List<String> list2 = list;
        if (f8956b == null) {
            f8956b = Boolean.FALSE;
        }
        if (f8956b.booleanValue()) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "missing wakeLock key. ".concat(valueOf);
                } else {
                    new String("missing wakeLock key. ");
                }
            } else if (7 == i4 || 8 == i4 || 10 == i4 || 11 == i4) {
                long currentTimeMillis = System.currentTimeMillis();
                if (list2 != null && list.size() == 1 && "com.google.android.gms".equals(list2.get(0))) {
                    list2 = null;
                }
                List<String> list3 = list2;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int a2 = s.a(context);
                String packageName = context.getPackageName();
                WakeLockEvent wakeLockEvent = r1;
                WakeLockEvent wakeLockEvent2 = new WakeLockEvent(currentTimeMillis, i2, str2, i3, list3, str, elapsedRealtime, a2, str3, "com.google.android.gms".equals(packageName) ? null : packageName, s.b(context), j);
                try {
                    context.startService(new Intent().setComponent(b.f8946a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
                } catch (Exception e2) {
                    Log.wtf("WakeLockTracker", e2);
                }
            }
        }
    }
}
