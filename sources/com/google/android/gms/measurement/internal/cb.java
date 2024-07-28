package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.s;

final class cb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f11749a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f11750b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ z f11751c;

    cb(z zVar, String str, long j) {
        this.f11751c = zVar;
        this.f11749a = str;
        this.f11750b = j;
    }

    public final void run() {
        z zVar = this.f11751c;
        String str = this.f11749a;
        long j = this.f11750b;
        zVar.h();
        s.a(str);
        Integer num = zVar.f12365b.get(str);
        if (num != null) {
            hi z = zVar.e().z();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                zVar.f12365b.remove(str);
                Long l = zVar.f12364a.get(str);
                if (l == null) {
                    zVar.J_().f11828c.a("First ad unit exposure time was never set");
                } else {
                    zVar.f12364a.remove(str);
                    zVar.a(str, j - l.longValue(), z);
                }
                if (!zVar.f12365b.isEmpty()) {
                    return;
                }
                if (zVar.f12366c == 0) {
                    zVar.J_().f11828c.a("First ad exposure time was never set");
                    return;
                }
                zVar.a(j - zVar.f12366c, z);
                zVar.f12366c = 0;
                return;
            }
            zVar.f12365b.put(str, Integer.valueOf(intValue));
            return;
        }
        zVar.J_().f11828c.a("Call to endAdUnitExposure for unknown ad unit id", str);
    }
}
