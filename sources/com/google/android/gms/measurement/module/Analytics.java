package com.google.android.gms.measurement.module;

import android.content.Context;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.internal.fc;

public class Analytics {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Analytics f12398a;

    /* renamed from: b  reason: collision with root package name */
    private final fc f12399b;

    public static Analytics getInstance(Context context) {
        if (f12398a == null) {
            synchronized (Analytics.class) {
                if (f12398a == null) {
                    f12398a = new Analytics(fc.a(context, (zzv) null));
                }
            }
        }
        return f12398a;
    }

    private Analytics(fc fcVar) {
        s.a(fcVar);
        this.f12399b = fcVar;
    }
}
