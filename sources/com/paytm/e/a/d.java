package com.paytm.e.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public final class d implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f42686a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f42687b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private Integer f42688c;

    public d(Context context) {
        this.f42686a = PreferenceManager.getDefaultSharedPreferences(context);
        this.f42686a.registerOnSharedPreferenceChangeListener(this);
    }

    public final long a() {
        return System.currentTimeMillis() + (((long) b()) * 60000);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int b() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f42687b
            monitor-enter(r0)
            java.lang.Integer r1 = r4.f42688c     // Catch:{ all -> 0x0031 }
            if (r1 != 0) goto L_0x0029
            android.content.SharedPreferences r1 = r4.f42686a     // Catch:{ ClassCastException -> 0x0018 }
            java.lang.String r2 = "timeCorrectionMinutes"
            r3 = 0
            int r1 = r1.getInt(r2, r3)     // Catch:{ ClassCastException -> 0x0018 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ ClassCastException -> 0x0018 }
            r4.f42688c = r1     // Catch:{ ClassCastException -> 0x0018 }
            goto L_0x0029
        L_0x0018:
            android.content.SharedPreferences r1 = r4.f42686a     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = "timeCorrectionMinutes"
            java.lang.String r3 = "0"
            java.lang.String r1 = r1.getString(r2, r3)     // Catch:{ all -> 0x0031 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0031 }
            r4.f42688c = r1     // Catch:{ all -> 0x0031 }
        L_0x0029:
            java.lang.Integer r1 = r4.f42688c     // Catch:{ all -> 0x0031 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0031 }
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return r1
        L_0x0031:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.e.a.d.b():int");
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals("timeCorrectionMinutes")) {
            this.f42688c = null;
        }
    }
}
