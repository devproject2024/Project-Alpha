package com.alipay.iap.android.common.e.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.alipay.iap.android.common.b.c;
import java.util.Locale;

public class a implements com.alipay.iap.android.common.e.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14694a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f14695b;

    /* renamed from: c  reason: collision with root package name */
    private long f14696c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f14697d = 0;

    public a(Context context) {
        f14695b = context.getSharedPreferences("Alipay_time_sp", 0);
    }

    public final void a(long j, long j2) {
        String.format(Locale.getDefault(), "set serverTime = %d, requestCostTime = %d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
        c.c();
        if (f14695b == null) {
            c.i();
            return;
        }
        synchronized (this) {
            this.f14696c = System.currentTimeMillis();
            this.f14697d = this.f14696c - (j2 + (j / 2));
            f14695b.edit().putLong("sp_time_gap", this.f14697d).putLong("sp_sync_time", this.f14696c).apply();
        }
    }

    public final long a() {
        if (f14695b == null) {
            c.i();
            return System.currentTimeMillis();
        }
        synchronized (this) {
            if (this.f14697d <= 0) {
                this.f14697d = f14695b.getLong("sp_time_gap", 0);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f14697d;
        String.format(Locale.getDefault(), "get serverTime = %d, localTime = %d", new Object[]{Long.valueOf(j), Long.valueOf(currentTimeMillis)});
        c.c();
        return j;
    }
}
