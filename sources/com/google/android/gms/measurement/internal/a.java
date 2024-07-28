package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.s;

final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f11686a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f11687b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ z f11688c;

    a(z zVar, String str, long j) {
        this.f11688c = zVar;
        this.f11686a = str;
        this.f11687b = j;
    }

    public final void run() {
        z zVar = this.f11688c;
        String str = this.f11686a;
        long j = this.f11687b;
        zVar.h();
        s.a(str);
        if (zVar.f12365b.isEmpty()) {
            zVar.f12366c = j;
        }
        Integer num = zVar.f12365b.get(str);
        if (num != null) {
            zVar.f12365b.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (zVar.f12365b.size() >= 100) {
            zVar.J_().f11831f.a("Too many ads visible");
        } else {
            zVar.f12365b.put(str, 1);
            zVar.f12364a.put(str, Long.valueOf(j));
        }
    }
}
